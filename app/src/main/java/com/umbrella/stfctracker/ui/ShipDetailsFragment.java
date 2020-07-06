package com.umbrella.stfctracker.ui;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.LayoutDirection;
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

import com.umbrella.stfctracker.CustomComponents.InformationLabel;
import com.umbrella.stfctracker.CustomComponents.ResourceAmount;
import com.umbrella.stfctracker.DataTypes.Enums.ShipClass;
import com.umbrella.stfctracker.DataTypes.ResourceMaterial;
import com.umbrella.stfctracker.Database.Data.DataFunctions;
import com.umbrella.stfctracker.Database.Entities.BuiltShip;
import com.umbrella.stfctracker.Database.Entities.Tier;
import com.umbrella.stfctracker.R;
import com.umbrella.stfctracker.Structures.TimeDisplay;
import com.umbrella.stfctracker.Structures.ValueIndicator;
import com.umbrella.stfctracker.databinding.FragShipDetailsBinding;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ShipDetailsFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {
    private FragShipDetailsBinding binding;

    private BuiltShip builtShip;
    private MutableLiveData<Tier> observableTier = new MutableLiveData<>();

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

    // TODO: Possible - change color of fragShipDetailsTitleShipInfoLayout to Rarity
    private void fillBaseData(BuiltShip builtShip) {
        binding.fragShipDetailsShipName.setText(builtShip.getName());
        binding.fragShipDetailsStars.setNumStars(builtShip.getGrade().ordinal());
        binding.fragShipDetailsStars.setRating(builtShip.getGrade().ordinal());
        binding.fragShipDetailsImg.setImageDrawable(DataFunctions.decodeDrawable(getResources(), builtShip.getImage()));
        binding.fragShipDetailsClassImg.setImageDrawable(shipClassDrawable(builtShip.getShipClass()));
        binding.fragShipDetailsAbilityName.setText(builtShip.getShipAbility());

        binding.fragShipDetailsLevelSeekBar.setOnSeekBarChangeListener(this);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(binding.fragShipDetailsTierRecyclerView.getLayoutParams());
        params.setLayoutDirection(LayoutDirection.LTR);
        binding.fragShipDetailsTierRecyclerView.setLayoutParams(params);

        TierAdapter adapter = new TierAdapter(requireContext(), builtShip.getTiers());
        binding.fragShipDetailsTierRecyclerView.setAdapter(adapter);
        binding.fragShipDetailsTierRecyclerView.setOnItemClickListener((parent, view, position, id) -> {
            Tier selectedTier = builtShip.getTiers().get(position);

            if (Objects.requireNonNull(observableTier.getValue()).equals(selectedTier)) {
                Toast.makeText(requireContext(), getString(R.string.currentTier_selected), Toast.LENGTH_SHORT).show();
                binding.fragShipDetailsTierRecyclerView.setSelection(position);
            } else {
                observableTier.setValue(builtShip.getTiers().get(position));
            }
        });
    }

    private void setUpObserver() {
        observableTier.observe(getViewLifecycleOwner(), tier -> {
            binding.fragShipDetailsShipInfo.setText(getString(R.string.shipDetails_shipInfo, builtShip.getRarity().toString(), tier.getTier()));
            binding.fragShipDetailsLevelSeekBar.setMin(tier.getLevels().get(0).getLevel());
            binding.fragShipDetailsLevelSeekBar.setMax(tier.getLevels().get(tier.getLevels().size() - 1).getLevel());
            binding.fragShipDetailsRepairSpeedTime.setText(new TimeDisplay(requireContext()).getTime(tier.getRepairTime()));

            updateRepairCosts(tier);
        });
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Tier.Level level = Objects.requireNonNull(observableTier.getValue()).getLevels().get(progress);

        binding.fragShipDetailsLevel.setText(getString(R.string.currentLevel, progress));
        binding.fragShipDetailsXp.setText(getString(R.string.totalXP, level.getRequiredShipXP()));
        binding.fragShipDetailsAbilityValue.setText(getString(R.string.percentage, level.getShipAbilityBonus()));
    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    // TODO: Create shipClass images (4)
    private Drawable shipClassDrawable(ShipClass shipClass) {
        switch (shipClass) {
            case BATTLESHIP:    return getResources().getDrawable(0, null);
            case EXPLORER:      return getResources().getDrawable(0, null);
            case INTERCEPTOR:   return getResources().getDrawable(0, null);
            case SURVEY:        return getResources().getDrawable(0, null);
        }
        return null;
    }

    private void updateRepairCosts(Tier tier) {
        //All resource views
        LinkedList<ResourceAmount> ra = new LinkedList<>(Arrays.asList(binding.fragShipDetailsAmountA, binding.fragShipDetailsAmountB, binding.fragShipDetailsAmountC));
        LinkedList<ResourceMaterial> popResources = new LinkedList<>();

        //The next tier if not last tier else @null
        Tier nextTier = (builtShip.getCurrentTier() != builtShip.getTiers().size()) ? builtShip.getTiers().get(tier.getTier()) : null;
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
            activeComponents.forEach(activeComponent -> {
                finalRss.addAll(activeComponent.getRepairCosts());
                activeComponents.removeIf(c -> c.getName().equals(activeComponent.getName()));
            });
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

        //Add Resource Views that are needed for the repair costs
        sortedList.forEach(sortedItem -> {
            ResourceAmount itemView = ra.pop();

            itemView.setNeeded(true);
            itemView.setMaterial(sortedItem.getMaterial());
            itemView.setValue(sortedItem.getValue());

            itemView.setOnClickListener(view -> {
                InformationLabel label = new InformationLabel(requireContext());
                label.setValue(itemView.getValue());
                label.setLocation(view, -15, -10);
                binding.fragShipDetailsRepairLayout.addView(label);
            });
        });

        //Set all residual views to NOT needed.
        ra.forEach(leftItem -> leftItem.setNeeded(false));
    }

    private static class TierAdapter extends ArrayAdapter<Tier> {
        private Context mContext;
        private List<Tier> items;

        TierAdapter(@NonNull Context context, List<Tier> items) {
            super(context, 0, items);
            this.mContext = context;
            this.items = items;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null) convertView = LayoutInflater.from(mContext).inflate(R.layout.tier_level, parent, false);

            TextView titleView = convertView.requireViewById(R.id.tierLevel_level);

            titleView.setText(items.get(position).getTier());

            return convertView;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
