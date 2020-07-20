package com.umbrella.stfctracker.ui;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.LayoutDirection;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.umbrella.stfctracker.CustomComponents.InformationLabel;
import com.umbrella.stfctracker.CustomComponents.ResourceAmount;
import com.umbrella.stfctracker.DataTypes.Enums.ShipClass;
import com.umbrella.stfctracker.DataTypes.ResourceMaterial;
import com.umbrella.stfctracker.Database.Data.DataFunctions;
import com.umbrella.stfctracker.Database.Entities.BuiltShip;
import com.umbrella.stfctracker.Database.Entities.Tier;
import com.umbrella.stfctracker.R;
import com.umbrella.stfctracker.Structures.CumulativeBonus;
import com.umbrella.stfctracker.Structures.Data;
import com.umbrella.stfctracker.Structures.TimeDisplay;
import com.umbrella.stfctracker.Structures.ValueIndicator;
import com.umbrella.stfctracker.databinding.FragShipDetailsBinding;
import com.umbrella.stfctracker.databinding.TierLevelBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ShipDetailsFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {
    private FragShipDetailsBinding binding;

    private BuiltShip builtShip;
    private MutableLiveData<Tier> observableTier = new MutableLiveData<>();

    private CumulativeBonus cumulativeBonus = CumulativeBonus.getInstance();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragShipDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ShipDetailsFragmentArgs args = ShipDetailsFragmentArgs.fromBundle(requireArguments());
        builtShip = args.getBuiltShip();
        observableTier.setValue(builtShip.getTiers().get(builtShip.getCurrentTier() - 1));

        fillBaseData(builtShip);
        setUpObserver();

        binding.fragShipDetailsComponents.setOnClickListener(v ->
                Navigation.findNavController(requireView()).navigate(ShipDetailsFragmentDirections.shipDetailsToUpgradeShip(builtShip, Objects.requireNonNull(observableTier.getValue()))));
        binding.fragShipDetailsScrap.setOnClickListener(v -> {
            Tier.Level currentLevel = Objects.requireNonNull(observableTier.getValue())
                    .getLevels()
                    .stream()
                    .filter(level -> level.getLevel() == binding.fragShipDetailsLevelSeekBar.getProgress())
                    .collect(Collectors.toList())
                    .get(0);
            Navigation.findNavController(requireView()).navigate(ShipDetailsFragmentDirections.shipDetailsToScrapShip(builtShip, currentLevel));
        });
    }

    private void fillBaseData(BuiltShip builtShip) {
        binding.fragShipDetailsShipName.setText(builtShip.getName());
        binding.fragShipDetailsStars.setNumStars(builtShip.getGrade().ordinal());
        binding.fragShipDetailsStars.setRating(builtShip.getGrade().ordinal());
        binding.fragShipDetailsImg.setImageDrawable(DataFunctions.decodeDrawable(getResources(), builtShip.getImage()));
        binding.fragShipDetailsClassImg.setImageDrawable(getResources().getDrawable(builtShip.getShipClass().getImageId(), null));
        binding.fragShipDetailsAbilityName.setText(builtShip.getShipAbility());
        binding.fragShipDetailsTitleLayout.setBackgroundColor(getResources().getColor(builtShip.getRarity().getColorInner(), null));
        binding.fragShipDetailsTitleShipInfoLayout.setBackgroundColor(getResources().getColor(builtShip.getRarity().getColorBorder(), null));
        binding.fragShipDetailsFactionName.setText(builtShip.getFaction().toString());

        binding.fragShipDetailsLevelSeekBar.setMin(1);
        binding.fragShipDetailsLevelSeekBar.setMax(5);

        //Ship can't be scrapped when it has no scrapping possibility OR when the opsLevel is not high enough
        binding.fragShipDetailsScrap.setUsable(builtShip.getRequiredOperationsLevel() != -1 && Data.getInstance().getOperationsLevel() >= builtShip.getScrapRequiredOperationsLevel());

        binding.fragShipDetailsLevelSeekBar.setOnSeekBarChangeListener(this);

        TierAdapter adapter = new TierAdapter();
        binding.fragShipDetailsTierRecyclerView.setAdapter(adapter);
        adapter.setTiers(builtShip.getTiers());
    }

    private void setUpObserver() {
        observableTier.observe(getViewLifecycleOwner(), tier -> {
            binding.fragShipDetailsShipInfo.setText(getString(R.string.shipDetails_shipInfo, builtShip.getRarity().toString(), tier.getTier()));
            binding.fragShipDetailsRepairSpeedTime.setText(new TimeDisplay(requireContext())
                    .getTime(cumulativeBonus.applyBonus(tier.getRepairTime(), cumulativeBonus.getShipRepairSpeedBonus(builtShip.getFaction(), builtShip.getShipClass()))));

            binding.fragShipDetailsLevelSeekBar.setProgress(2);
            binding.fragShipDetailsLevelSeekBar.setProgress(1);

            updateRepairCosts(tier);
        });
    }

    // TODO: Show rippleColor when clicked
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Tier.Level level = Objects.requireNonNull(observableTier.getValue()).getLevels().get(progress - 1);

        binding.fragShipDetailsLevel.setText(getString(R.string.currentLevel, level.getLevel()));
        binding.fragShipDetailsXp.setText(getString(R.string.totalXP, level.getRequiredShipXP()));

        String temp = (level.getShipAbilityBonus() % 1 == 0) ? String.valueOf(Math.round(level.getShipAbilityBonus())) : String.valueOf(level.getShipAbilityBonus());
        binding.fragShipDetailsAbilityValue.setText(getString(R.string.ship_percentage, temp));
    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    private void updateRepairCosts(Tier tier) {
        LinkedList<ResourceMaterial> popResources = new LinkedList<>();

        //The next tier if not last tier else @null
        Tier nextTier = (tier.getTier() != builtShip.getTiers().size()) ? builtShip.getTiers().get(tier.getTier()) : null;
        //Get all components of the current tier
        List<Tier.Component> activeComponents = new LinkedList<>(tier.getComponents());

        //If no next tier, all repairCosts come from the current tier components.
        if (nextTier == null) {
            LinkedList<ResourceMaterial> finalPopResources = popResources;
            activeComponents.forEach(component -> finalPopResources.addAll(component.getRepairCosts()));
            popResources = finalPopResources;
        } else {
            //Next tier, repairCosts taken from components that are unlocked of the next tier.
            LinkedList<ResourceMaterial> finalRss = popResources;
            nextTier.getComponents().forEach(component -> {
                if (!component.isLocked()) {
                    finalRss.addAll(component.getRepairCosts());
                    activeComponents.removeIf(c -> c.getName().equals(component.getName()));
                }
            });
            //Items that are left are taken from the current tier.
            activeComponents.forEach(activeComponent ->
                finalRss.addAll(activeComponent.getRepairCosts())
            );
            popResources = finalRss;
        }

        LinkedList<ResourceMaterial> sortedList = new LinkedList<>();
        while (!popResources.isEmpty()) {
            ResourceMaterial mat = popResources.pop();

            if (sortedList.stream().anyMatch(item -> item.getMaterial().equals(mat.getMaterial()))) {
                ResourceMaterial src = sortedList.stream().filter(item -> item.getMaterial().equals(mat.getMaterial())).collect(Collectors.toList()).get(0);
                sortedList.get(sortedList.indexOf(src)).setValue(src.getValue() + mat.getValue());
            } else {
                sortedList.add(mat);
            }
        }

        sortedList.forEach(resourceMaterial -> resourceMaterial.setValue(cumulativeBonus
                .applyBonus(resourceMaterial.getValue(), cumulativeBonus.getShipRepairCostEfficiencyBonus(builtShip.getFaction(), builtShip.getShipClass()))));

        binding.fragShipDetailsRepairResources.setResources(sortedList);
    }

    private class TierAdapter extends RecyclerView.Adapter<TierAdapter.CustomViewHolder> {
        private TierLevelBinding tierBinding;

        private LinkedList<Tier> tiers = new LinkedList<>();

        public TierAdapter() {
        }

        @NonNull
        @Override
        public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            tierBinding = TierLevelBinding.inflate(LayoutInflater.from(requireContext()), parent, false);
            return new CustomViewHolder(tierBinding.getRoot());
        }

        @Override
        public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
            holder.tierView.setText(String.valueOf(tiers.get(position).getTier()));

            holder.itemView.setOnClickListener(v -> {
                if (Objects.requireNonNull(observableTier.getValue()).equals(tiers.get(position))) {
                    Toast.makeText(requireContext(), getString(R.string.currentTier_selected), Toast.LENGTH_SHORT).show();
                } else {
                    observableTier.setValue(builtShip.getTiers().get(position));
                }
            });
        }

        public void setTiers(LinkedList<Tier> tiers) {
            this.tiers = tiers;
            notifyDataSetChanged();
        }

        @Override
        public int getItemCount() {
            return tiers.size();
        }

        class CustomViewHolder extends RecyclerView.ViewHolder {
            private TextView tierView;

            public CustomViewHolder(@NonNull View itemView) {
                super(itemView);
                tierView = tierBinding.tierLevelLevel;
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
