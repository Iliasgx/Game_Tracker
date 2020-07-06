package com.umbrella.stfctracker.ui.Dialogs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import com.umbrella.stfctracker.CustomComponents.InformationLabel;
import com.umbrella.stfctracker.CustomComponents.ResourceAmount;
import com.umbrella.stfctracker.CustomComponents.ResourceMaterialAmount;
import com.umbrella.stfctracker.DataTypes.ResourceMaterial;
import com.umbrella.stfctracker.Database.Data.DataFunctions;
import com.umbrella.stfctracker.Database.DatabaseClient;
import com.umbrella.stfctracker.Database.Entities.BuiltShip;
import com.umbrella.stfctracker.Database.Entities.Tier;
import com.umbrella.stfctracker.Database.Models.BuiltShipViewModel;
import com.umbrella.stfctracker.R;
import com.umbrella.stfctracker.databinding.DialogShipUpgradeBinding;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class UpgradeShipDialog extends DialogFragment {
    private DialogShipUpgradeBinding binding;

    private BuiltShip builtShip;
    private MutableLiveData<Tier> observableTier;

    private ComponentAdapter adapter;

    private LinkedList<ResourceMaterialAmount> rma;
    private LinkedList<ResourceAmount> rm;

    public UpgradeShipDialog() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogShipUpgradeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rma = new LinkedList<>(Arrays.asList(binding.dialogShipUpgradeMaterialA, binding.dialogShipUpgradeMaterialB, binding.dialogShipUpgradeMaterialC, binding.dialogShipUpgradeMaterialD));
        rm = new LinkedList<>(Arrays.asList(binding.dialogShipUpgradeAmountA, binding.dialogShipUpgradeAmountB));

        adapter = new ComponentAdapter(requireContext(), new LinkedList<>());

        UpgradeShipDialogArgs args = UpgradeShipDialogArgs.fromBundle(requireArguments());
        builtShip = args.getBuiltShip();
        observableTier = new MutableLiveData<>(args.getSelectedTier());

        binding.dialogShipUpgradeList.setAdapter(adapter);

        setUpListeners();
    }

    private void setUpListeners() {
        observableTier.observe(getViewLifecycleOwner(), tier -> {
            adapter.clear();
            adapter.addAll(tier.getComponents());
            adapter.notifyDataSetChanged();

            if (Objects.requireNonNull(observableTier.getValue()).getComponents().stream().noneMatch(Tier.Component::isLocked)) {
                //All components were max, the ship can only tier up.
                binding.dialogShipUpgradeUp.setTitle(getString(R.string.tierUp));
                binding.dialogShipUpgradeUp.setBorderDrawable(getResources().getDrawable(R.drawable.round_edge_light_red, null));
                binding.dialogShipUpgradeUp.setFrameDrawable(getResources().getDrawable(R.drawable.button_ripple_red, null));
                binding.dialogShipUpgradeUp.setTime(builtShip.getTiers().get(builtShip.getCurrentTier()).getBuildTime());
                binding.dialogShipUpgradeUp.setShowTime(true);
            } else {
                if (binding.dialogShipUpgradeUp.isShowTime()) {
                    //After a tier up the button has to be back to default.
                    binding.dialogShipUpgradeUp.setTitle(getString(R.string.upgrade));
                    binding.dialogShipUpgradeUp.setBorderDrawable(getResources().getDrawable(R.drawable.round_edge, null));
                    binding.dialogShipUpgradeUp.setFrameDrawable(getResources().getDrawable(R.drawable.button_ripple, null));
                    binding.dialogShipUpgradeUp.setShowTime(false);
                }
            }
        });

        binding.dialogShipUpgradeList.setOnItemClickListener((parent, view, position, id) -> {
            if (position == -1) {
                //Clears fields
                rma.forEach(item -> item.setNeeded(false));
                rm.forEach(item -> item.setNeeded(false));
                binding.dialogShipUpgradeUp.setUsable(false);
            } else {
                //SetUp fields
                Tier.Component component = Objects.requireNonNull(adapter.getItem(position));

                LinkedList<ResourceAmount> rss = new LinkedList<>(rm);
                LinkedList<ResourceMaterialAmount> mat = new LinkedList<>(rma);

                component.getResources().forEach(item -> {
                    ResourceAmount curr = rss.pop();
                    curr.setMaterial(item.getMaterial());
                    curr.setValue(item.getValue());
                    curr.setNeeded(true);

                    curr.setOnClickListener(v -> {
                        InformationLabel label = new InformationLabel(requireContext());
                        label.setValue(item.getValue());
                        label.setLocation(v, -15, -10);
                        binding.dialogShipUpgradeCardView.addView(label);
                    });
                });

                component.getMaterials().forEach(item -> {
                    ResourceMaterialAmount curr = mat.pop();
                    curr.setMaterial(item.getMaterial());
                    curr.setGrade(item.getGrade());
                    curr.setRarity(item.getRarity());
                    curr.setValue((int)item.getValue());
                    curr.setNeeded(true);
                });

                rma.forEach(item -> item.setNeeded(false));
                rm.forEach(item -> item.setNeeded(false));

                if (Objects.requireNonNull(observableTier.getValue()).getComponents().stream().anyMatch(Tier.Component::isLocked)) {
                    binding.dialogShipUpgradeUp.setUsable(component.isLocked());
                } else {
                    binding.dialogShipUpgradeUp.setUsable(true);
                }
            }
        });

        binding.dialogShipUpgradeUp.setOnClickListener(listener -> {
            if (Objects.requireNonNull(observableTier.getValue()).getComponents().stream().anyMatch(Tier.Component::isLocked)) {
                //Not all components are leveled up. This means a component is being leveled up now.
                builtShip.getTiers().get(builtShip.getCurrentTier() - 1).getComponents().get(binding.dialogShipUpgradeList.getSelectedItemPosition()).setLocked(false);
            } else {
                //All components are maxed for the current Tier. This means the user wants to tier up now.
                builtShip.setCurrentTier(builtShip.getCurrentTier() + 1);
            }
            DatabaseClient.dbWriteExecutor.execute(() -> {
                DatabaseClient.getInstance(requireContext()).daoBuiltShip().update(builtShip);
                observableTier.setValue(builtShip.getTiers().get(builtShip.getCurrentTier() - 1));
            });
        });
    }

    class ComponentAdapter extends ArrayAdapter<Tier.Component> {
        private List<Tier.Component> components;

        public ComponentAdapter(@NonNull Context context, List<Tier.Component> components) {
            super(context, 0, components);
            this.components = components;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null) convertView = LayoutInflater.from(requireContext()).inflate(R.layout.list_ship_upgrade_item, parent, false);

            Tier.Component component = components.get(position);

            ((ImageView)convertView.requireViewById(R.id.listShipUpgradeItem_img)).setImageDrawable(DataFunctions.decodeDrawable(getResources(), component.getImage()));
            ((TextView)convertView.requireViewById(R.id.listShipUpgradeItem_name)).setText(component.getName().toString());
            convertView.requireViewById(R.id.listShipUpgradeItem_locked).setVisibility(component.isLocked() ? View.VISIBLE : View.INVISIBLE);

            return convertView;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
