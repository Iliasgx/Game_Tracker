package com.umbrella.stfctracker.ui;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.Navigation;

import com.umbrella.stfctracker.DataTypes.Enums.ShipClass;
import com.umbrella.stfctracker.Database.Data.DataFunctions;
import com.umbrella.stfctracker.Database.Entities.BuiltShip;
import com.umbrella.stfctracker.Database.Entities.Tier;
import com.umbrella.stfctracker.R;
import com.umbrella.stfctracker.Structures.TimeDisplay;
import com.umbrella.stfctracker.Structures.ValueIndicator;
import com.umbrella.stfctracker.databinding.FragShipDetailsBinding;

import java.util.Objects;

public class ShipDetailsFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {
    private FragShipDetailsBinding binding;

    private MutableLiveData<BuiltShip> observableShip;
    private Tier currentTier;

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
        observableShip = new MutableLiveData<>(args.getBuiltShip());

        fillBaseData(args.getBuiltShip());
        setUpObserver();

        binding.fragShipDetailsComponents.setOnClickListener(v ->
                Navigation.findNavController(requireView()).navigate(ShipDetailsFragmentDirections.shipDetailsToUpgradeShip(Objects.requireNonNull(observableShip.getValue()))));
        binding.fragShipDetailsScrap.setOnClickListener(v ->
                Navigation.findNavController(requireView()).navigate(ShipDetailsFragmentDirections.shipDetailsToScrapShip(Objects.requireNonNull(observableShip.getValue()))));
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

        // TODO: TiersAdapter
        // TODO: TierClickEvent for going to other tier?
    }

    private void setUpObserver() {
        observableShip.observe(getViewLifecycleOwner(), builtShip -> {
            currentTier = builtShip.getTiers().get(builtShip.getCurrentTier());

            binding.fragShipDetailsShipInfo.setText(getString(R.string.shipDetails_shipInfo, builtShip.getRarity().toString(), builtShip.getCurrentTier()));
            binding.fragShipDetailsLevelSeekBar.setMin(currentTier.getLevels().get(0).getLevel());
            binding.fragShipDetailsLevelSeekBar.setMax(currentTier.getLevels().get(currentTier.getLevels().size() - 1).getLevel());

            // TODO: RepairSpeed and costs
            // TODO: TierAdapter change selectedItem (or activate observer by automatic clicking this)
        });
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Tier.Level level = currentTier.getLevels().get(progress);

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
}
