package com.umbrella.stfctracker.ui;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.umbrella.stfctracker.CustomComponents.CustomResourceMaterialView;
import com.umbrella.stfctracker.DataTypes.Enums.Material;
import com.umbrella.stfctracker.DataTypes.ResourceMaterial;
import com.umbrella.stfctracker.Database.Data.FunctionsDB;
import com.umbrella.stfctracker.Database.Entities.BuiltShip;
import com.umbrella.stfctracker.Database.Entities.Tier;
import com.umbrella.stfctracker.Database.Models.BuiltShipViewModel;
import com.umbrella.stfctracker.R;
import com.umbrella.stfctracker.Structures.CumulativeBonus;
import com.umbrella.stfctracker.Structures.Data;
import com.umbrella.stfctracker.Structures.TimeDisplay;
import com.umbrella.stfctracker.databinding.FragShipDetailsBinding;
import com.umbrella.stfctracker.databinding.TierLevelBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ShipDetailsFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {
    private FragShipDetailsBinding binding;

    private BuiltShipViewModel vm;

    private BuiltShip builtShip;
    private MutableLiveData<Tier> observableTier = new MutableLiveData<>();

    private CumulativeBonus cumulativeBonus = CumulativeBonus.getInstance();

    private List<ValueAnimator> activeAnimators = new ArrayList<>();
    private List<ValueAnimator> endingAnimators = new ArrayList<>();

    private boolean isBuild;

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

        if (args.getBuiltShip() != null) {
            builtShip = args.getBuiltShip();
            isBuild = true;
        } else if (args.getShip() != null) {
            builtShip = new BuiltShip(args.getShip());
            isBuild = false;
        }
        observableTier.setValue(builtShip.getCurrentTier());

        vm = new ViewModelProvider(this).get(BuiltShipViewModel.class);

        fillBaseData(builtShip);
        setUpObserver();
    }

    private void fillBaseData(BuiltShip builtShip) {
        binding.fragShipDetailsShipName.setText(builtShip.getName());
        binding.fragShipDetailsStars.setNumStars(builtShip.getGrade().ordinal());
        binding.fragShipDetailsStars.setRating(builtShip.getGrade().ordinal());
        binding.fragShipDetailsImg.setImageDrawable(FunctionsDB.decodeDrawable(getResources(), builtShip.getImage()));
        binding.fragShipDetailsClassImg.setImageDrawable(getResources().getDrawable(builtShip.getShipClass().getImageId(), null));
        binding.fragShipDetailsAbilityName.setText(builtShip.getShipAbility());
        binding.fragShipDetailsTitleLayout.setBackgroundColor(getResources().getColor(builtShip.getRarity().getColorInner(), null));
        binding.fragShipDetailsTitleShipInfoLayout.setBackgroundColor(getResources().getColor(builtShip.getRarity().getColorBorder(), null));
        binding.fragShipDetailsFactionName.setText(builtShip.getFaction().toString());

        binding.fragShipDetailsLevelSeekBar.setMin(1);
        binding.fragShipDetailsLevelSeekBar.setMax(5);

        //Ship can't be scrapped when it has no scrapping possibility OR when the opsLevel is not high enough
        boolean usable = (builtShip.getScrapRequiredOperationsLevel() != -1 && Data.getInstance().getOperationsLevel() >= builtShip.getScrapRequiredOperationsLevel());
        binding.fragShipDetailsScrap.setUsable(usable && isBuild);
        binding.fragShipDetailsScrap.setClickable(true);

        binding.fragShipDetailsLevelSeekBar.setOnSeekBarChangeListener(this);

        TierAdapter adapter = new TierAdapter();
        binding.fragShipDetailsTierRecyclerView.setAdapter(adapter);
        adapter.setTiers(builtShip.getTiers());
    }

    private void setUpObserver() {
        if (isBuild) {
            vm.getShipById(builtShip.getId()).observe(getViewLifecycleOwner(), updatedShip -> {
                this.builtShip = updatedShip;
                if (updatedShip != null) {
                    Objects.requireNonNull(binding.fragShipDetailsTierRecyclerView.findViewHolderForAdapterPosition(updatedShip.getCurrentTierId() - 1)).itemView.performClick();
                } else {
                    Toast.makeText(requireContext(), getString(R.string.shipScrap_confirmation, builtShip.getName()), Toast.LENGTH_SHORT).show();
                    Navigation.findNavController(requireView()).navigateUp();
                }
            });
        }

        observableTier.observe(getViewLifecycleOwner(), tier -> {
            binding.fragShipDetailsShipInfo.setText(getString(R.string.shipDetails_shipInfo, builtShip.getRarity().toString(), tier.getTier()));
            binding.fragShipDetailsRepairSpeedTime.setText(new TimeDisplay(requireContext())
                    .getTime(cumulativeBonus.applyBonus(tier.getRepairTime(), cumulativeBonus.getShipRepairSpeedBonus(builtShip.getFaction(), builtShip.getShipClass()))));

            binding.fragShipDetailsLevelSeekBar.setProgress(2);
            binding.fragShipDetailsLevelSeekBar.setProgress(1);

            changeGradually(
                    binding.fragShipDetailsShipInfo,
                    binding.fragShipDetailsRepairSpeedTime,
                    binding.fragShipDetailsAbilityValue,
                    binding.fragShipDetailsLevel,
                    binding.fragShipDetailsXp
            );

            updateRepairCosts(tier);
        });

        binding.fragShipDetailsComponents.setOnClickListener(v ->
                Navigation.findNavController(requireView()).navigate(ShipDetailsFragmentDirections.shipDetailsToUpgradeShip(builtShip, Objects.requireNonNull(observableTier.getValue()).getTier(), isBuild)));
        binding.fragShipDetailsScrap.setOnClickListener(v -> {
            if (builtShip.getScrapRequiredOperationsLevel() == -1) {
                Toast.makeText(requireContext(), getString(R.string.shipScrap_notScrap_warning, builtShip.getName()), Toast.LENGTH_SHORT).show();
            } else {
                Tier.Level currentLevel = Objects.requireNonNull(observableTier.getValue()).getLevels().get(binding.fragShipDetailsLevelSeekBar.getProgress() - 1);
                Navigation.findNavController(requireView()).navigate(ShipDetailsFragmentDirections.shipDetailsToScrapShip(builtShip, currentLevel, isBuild));
            }
        });
    }

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
        LinkedList<ResourceMaterial> tempRss = new LinkedList<>();

        //The next tier if not last tier else @null
        Tier nextTier = (tier.getTier() != builtShip.getTiers().size()) ? builtShip.getTiers().get(tier.getTier()) : null;
        //Get all components of the current tier
        List<Tier.Component> activeComponents = new LinkedList<>(tier.getComponents());

        //Current tier is not last, resources should also be taken from next tier if unlocked.
        if (nextTier != null) {
            nextTier.getComponents().forEach(component -> {
                if (!component.isLocked()) {
                    tempRss.addAll(component.getRepairCosts());
                    activeComponents.removeIf(c -> c.getName().equals(component.getName()));
                }
            });
        }

        //If last tier or not all components of next tier are unlocked, take currentTier components into account.
        activeComponents.forEach(activeComponent ->
            tempRss.addAll(activeComponent.getRepairCosts())
        );

        HashMap<Material, Long> sortedList = CustomResourceMaterialView.computeResources(tempRss);

        sortedList.forEach((material, value) -> sortedList.replace(material, cumulativeBonus
                .applyBonus(value, cumulativeBonus.getShipRepairCostEfficiencyBonus(builtShip.getFaction(), builtShip.getShipClass(), builtShip.getGrade())))
        );

        binding.fragShipDetailsRepairResources.setResources(sortedList);
    }

    private void changeGradually(TextView... views) {
        if (activeAnimators.size() == 0) {
            int highlightColor = getResources().getColor(R.color.color_gold, null);
            int duration = 1000;

            for (TextView view : views) {
                int fromColor = view.getCurrentTextColor();

                ValueAnimator valueAnimatorToGold = ValueAnimator.ofInt(0, view.getText().length());
                ValueAnimator valueAnimatorFromGold = ValueAnimator.ofInt(0, view.getText().length());

                valueAnimatorToGold.setDuration(duration);
                valueAnimatorFromGold.setDuration(duration);

                valueAnimatorToGold.addUpdateListener(animation -> {
                    try {
                        SpannableString strSpan = new SpannableString(view.getText());
                        strSpan.setSpan(new ForegroundColorSpan(highlightColor), 0, Integer.parseInt(animation.getAnimatedValue().toString()), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        view.setText(strSpan);
                    } catch (IndexOutOfBoundsException e) {
                        animation.cancel();
                    }
                });

                valueAnimatorFromGold.addUpdateListener(animation -> {
                    try {
                        SpannableString strSpan = new SpannableString(view.getText());
                        strSpan.setSpan(new ForegroundColorSpan(fromColor), 0, Integer.parseInt(animation.getAnimatedValue().toString()), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                        view.setText(strSpan);
                    } catch (IndexOutOfBoundsException e) {
                        animation.cancel();
                    }
                });

                valueAnimatorToGold.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        valueAnimatorFromGold.start();
                    }
                });

                activeAnimators.add(valueAnimatorToGold);
                endingAnimators.add(valueAnimatorFromGold);
            }
        }

        activeAnimators.forEach(ValueAnimator::start);
    }

    private class TierAdapter extends RecyclerView.Adapter<TierAdapter.CustomViewHolder> {
        private TierLevelBinding tierBinding;

        private LinkedList<Tier> tiers = new LinkedList<>();
        private int selectedItem = 0;

        public TierAdapter() {
        }

        @NonNull
        @Override
        public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            tierBinding = TierLevelBinding.inflate(LayoutInflater.from(requireContext()), parent, false);
            selectedItem = Objects.requireNonNull(observableTier.getValue()).getTier() - 1;
            return new CustomViewHolder(tierBinding.getRoot());
        }

        @Override
        public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
            holder.tierView.setText(String.valueOf(tiers.get(position).getTier()));

            holder.tierView.setTextColor(getResources().getColor((position == selectedItem) ? R.color.color_gold : R.color.textColor_white, null));

            holder.itemView.setOnClickListener(v -> {
                if (!Objects.requireNonNull(observableTier.getValue()).equals(tiers.get(position))) {
                    int temp = selectedItem;

                    selectedItem = position;

                    activeAnimators.forEach(ValueAnimator::cancel);
                    endingAnimators.forEach(ValueAnimator::cancel);
                    observableTier.setValue(builtShip.getTiers().get(position));
                    notifyItemChanged(temp);
                    notifyItemChanged(selectedItem);
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
        activeAnimators.forEach(ValueAnimator::cancel);
        endingAnimators.forEach(ValueAnimator::cancel);
        binding = null;
    }
}
