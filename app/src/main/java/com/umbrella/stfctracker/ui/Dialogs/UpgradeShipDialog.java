package com.umbrella.stfctracker.ui.Dialogs;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.MutableLiveData;

import com.umbrella.stfctracker.DataTypes.ResourceMaterial;
import com.umbrella.stfctracker.Database.DatabaseClient;
import com.umbrella.stfctracker.Database.Entities.BuiltShip;
import com.umbrella.stfctracker.Database.Entities.Tier;
import com.umbrella.stfctracker.R;
import com.umbrella.stfctracker.Structures.CumulativeBonus;
import com.umbrella.stfctracker.databinding.DialogShipUpgradeBinding;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class UpgradeShipDialog extends DialogFragment {
    private DialogShipUpgradeBinding binding;

    private CumulativeBonus cumulativeBonus = CumulativeBonus.getInstance();

    private BuiltShip builtShip;
    private MutableLiveData<Tier> observableTier;

    private int selectedListPos = ListView.INVALID_POSITION;
    private boolean observedTierIsLastTier;

    private ComponentAdapter adapter;

    public UpgradeShipDialog() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogShipUpgradeBinding.inflate(inflater, container, false);
        Objects.requireNonNull(requireDialog().getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        UpgradeShipDialogArgs args = UpgradeShipDialogArgs.fromBundle(requireArguments());
        builtShip = args.getBuiltShip();

        //Current tier that was selected is the last one on the list of tiers. Equal to the last tier.
        observedTierIsLastTier = (args.getSelectedTier() == builtShip.getTiers().getLast());

        //If selected tier is last one, observe the last tier, else show everything of next tier.
        observableTier = new MutableLiveData<>(observedTierIsLastTier ? args.getSelectedTier() : builtShip.getTiers().get(args.getSelectedTier().getTier()));

        binding.dialogShipUpgradeShipName.setText(builtShip.getName());
        adapter = new ComponentAdapter(requireContext(), new LinkedList<>());
        binding.dialogShipUpgradeList.setAdapter(adapter);

        setUpListeners();
    }

    private void setUpListeners() {
        binding.dialogShipUpgradeList.setOnItemClickListener((parent, view, position, id) -> {
            selectedListPos = position;

            if (!observedTierIsLastTier) {
                Tier.Component component = Objects.requireNonNull(adapter.getItem(position));

                //Set resources
                LinkedList<ResourceMaterial> rss = new LinkedList<>(component.getResources());
                rss.forEach(resourceMaterial -> resourceMaterial.setValue(cumulativeBonus
                        .applyBonus(resourceMaterial.getValue(), cumulativeBonus.getShipCostEfficiencyBonus(builtShip.getFaction(), resourceMaterial.getMaterial()))));
                binding.dialogShipUpgradeCosts.setResources(rss);

                //Set materials
                LinkedList<ResourceMaterial> mats = new LinkedList<>(component.getMaterials());
                mats.forEach(resourceMaterial -> resourceMaterial.setValue(cumulativeBonus
                        .applyBonus(resourceMaterial.getValue(), cumulativeBonus.getShipMaterialCostEfficiencyBonus(builtShip.getFaction(), builtShip.getShipClass(), resourceMaterial.getMaterial()))));
                binding.dialogShipUpgradeCosts.setMaterials(mats);

                if (Objects.requireNonNull(observableTier.getValue()).getComponents().stream().anyMatch(Tier.Component::isLocked)) {
                    //If any component can still be upgraded.
                    binding.dialogShipUpgradeUp.setUsable(component.isLocked());
                } else {
                    //All components upgraded. Setting button usable to tier up.
                    binding.dialogShipUpgradeUp.setUsable(true);
                }
            }
        });

        observableTier.observe(getViewLifecycleOwner(), tier -> {
            adapter.clear();
            adapter.addAll(tier.getComponents());

            boolean usable = false;

            if (observedTierIsLastTier) {
                setButton(getString(R.string.max_level), R.drawable.round_edge_light_red, R.drawable.button_ripple_red, -1);
            } else {
                //Observing next tier of current tier, only way any upgrade may happen.
                if (tier.getTier() - 1 == builtShip.getCurrentTierId()) {
                    usable = (selectedListPos != -1);
                    //All components are unlocked. Ready to tier up.
                    if (tier.getComponents().stream().noneMatch(Tier.Component::isLocked)) {
                        setButton(getString(R.string.tierUp), R.drawable.round_edge_light_red, R.drawable.button_ripple_red, tier.getBuildTime());
                    } else {
                        //Not all components are unlocked.
                        setButton(getString(R.string.upgrade), R.drawable.round_edge, R.drawable.button_ripple, -1);
                    }
                } else {
                    //Observing other tiers, upgrade not possible.
                    setButton(getString(R.string.upgrade), R.drawable.round_edge, R.drawable.button_ripple, -1);
                }
            }
            adapter.notifyDataSetChanged();
            binding.dialogShipUpgradeUp.setUsable(usable);
        });

        binding.dialogShipUpgradeUp.setOnClickListener(listener -> {
            if (Objects.requireNonNull(observableTier.getValue()).getComponents().stream().noneMatch(Tier.Component::isLocked)) {
                //All components are unlocked. User wants to tier up.
                builtShip.setCurrentTierId(builtShip.getCurrentTierId() + 1);

                //Return selected position back to default;
                selectedListPos = ListView.INVALID_POSITION;

                //Remove costs because nothing is selected anymore.
                binding.dialogShipUpgradeCosts.setMaterials(new LinkedList<>());
                binding.dialogShipUpgradeCosts.setResources(new LinkedList<>());
            } else {
                //User wants to upgrade a component. Not all are unlocked yet.
                builtShip.getNextTier().getComponents().get(selectedListPos).setLocked(false);
            }
            // TODO: Tier up gets NOT usable before clicking on an item again.
            DatabaseClient.dbWriteExecutor.execute(() -> {
                DatabaseClient.getInstance(requireContext()).daoBuiltShip().update(builtShip);
                observableTier.postValue(builtShip.getNextTier());
                requireActivity().runOnUiThread(() -> binding.dialogShipUpgradeUp.setUsable(false));
            });
        });
    }

    private void setButton(String title, int border, int frame, int time) {
        binding.dialogShipUpgradeUp.setTitle(title);
        binding.dialogShipUpgradeUp.setBorderDrawable(getResources().getDrawable(border, null));
        binding.dialogShipUpgradeUp.setFrameDrawable(getResources().getDrawable(frame, null));
        binding.dialogShipUpgradeUp.setTime((time != -1) ? time : 0);
        binding.dialogShipUpgradeUp.setShowTime(time != -1);
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

            ImageView img = (ImageView)convertView.requireViewById(R.id.listShipUpgradeItem_img);

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(img.getLayoutParams());
            params.setMargins(dim(10), dim(1), dim(0), dim(1));
            img.setLayoutParams(params);

            img.setImageDrawable(getResources().getDrawable(component.getImage(), null));
            ((TextView)convertView.requireViewById(R.id.listShipUpgradeItem_name)).setText(component.getName().toString());
            convertView.requireViewById(R.id.listShipUpgradeItem_locked).setVisibility(component.isLocked() ? View.VISIBLE : View.INVISIBLE);

            return convertView;
        }
    }

    private int dim(int dp) {
        return Float.valueOf(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics())).intValue();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
