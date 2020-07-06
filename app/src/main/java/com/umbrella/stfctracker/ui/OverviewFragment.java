package com.umbrella.stfctracker.ui;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.umbrella.stfctracker.DataTypes.Enums.Material;
import com.umbrella.stfctracker.DataTypes.ResourceMaterial;
import com.umbrella.stfctracker.Database.Models.OverviewViewModel;
import com.umbrella.stfctracker.R;
import com.umbrella.stfctracker.Structures.CumulativeBonus;
import com.umbrella.stfctracker.Structures.TimeDisplay;
import com.umbrella.stfctracker.databinding.FragOverviewBinding;
import com.umbrella.stfctracker.databinding.ListCustomResourceItemBinding;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class OverviewFragment extends Fragment {
    private FragOverviewBinding binding;

    private OverviewViewModel model;
    private MaterialAdapter adapter;

    private boolean setupB, setupR;

    private CumulativeBonus cumulativeBonus = CumulativeBonus.getInstance();

    private List<ValueAnimator> animators = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragOverviewBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new MaterialAdapter();
        binding.fragOverviewMaterialGrid.setAdapter(adapter);

        model = new ViewModelProvider(this).get(OverviewViewModel.class);

        setUpObservers();
    }

    private void setUpObservers() {
        model.getLiveBuildings().observe(getViewLifecycleOwner(), buildings -> {
            model.setBuildingList(buildings);
            setupB = true;
            setUpInformation();
        });

        model.getLiveResearch().observe(getViewLifecycleOwner(), research -> {
            model.setResearchList(research);
            setupR = true;
            setUpInformation();
        });
    }

    private void setUpInformation() {
        if (setupB && setupR) {

            //Levels of completion
            model.getFinishedBuildings().observe(getViewLifecycleOwner(), buildings -> changePercentages(buildings, -1));
            model.getFinishedResearch().observe(getViewLifecycleOwner(), research -> changePercentages(-1, research));

            //Upgrade time
            model.getBuildingTime().observe(getViewLifecycleOwner(), time ->
                    binding.fragOverviewTimeBuilding.setText(changeTime(time, cumulativeBonus.getBuildSpeedBonus()))
            );

            model.getResearchTime().observe(getViewLifecycleOwner(), time ->
                    binding.fragOverviewTimeResearch.setText(changeTime(time, cumulativeBonus.getResearchSpeedBonus()))
            );

            //Requirements
            model.getBuildingResource(Material.PARSTEEL).observe(getViewLifecycleOwner(), rss ->
                    changeResource(binding.fragOverviewCostBuildingResourceAValue, rss, true)
            );

            model.getBuildingResource(Material.TRITANIUM).observe(getViewLifecycleOwner(), rss ->
                    changeResource(binding.fragOverviewCostBuildingResourceBValue, rss, true)
            );

            model.getBuildingResource(Material.DILITHIUM).observe(getViewLifecycleOwner(), rss ->
                    changeResource(binding.fragOverviewCostBuildingResourceCValue, rss, true)
            );

            model.getResearchResource(Material.PARSTEEL).observe(getViewLifecycleOwner(), rss ->
                    changeResource(binding.fragOverviewCostResearchResourceAValue, rss, false)
            );

            model.getResearchResource(Material.TRITANIUM).observe(getViewLifecycleOwner(), rss ->
                    changeResource(binding.fragOverviewCostResearchResourceBValue, rss, false)
            );

            model.getResearchResource(Material.DILITHIUM).observe(getViewLifecycleOwner(), rss ->
                    changeResource(binding.fragOverviewCostResearchResourceCValue, rss, false)
            );

            //GridView Materials
            model.getAllMaterials().observe(getViewLifecycleOwner(), rss -> adapter.setMaterials(rss));
        }
    }

    @Override
    public void onDestroy() {
        animators.forEach(ValueAnimator::cancel);
        super.onDestroy();
        binding = null;
    }

    private String changeTime(int time, int bonus) {
        if (time == 0) return getString(R.string.time_placeholder);
        return new TimeDisplay(requireContext()).getTime(Long.valueOf(cumulativeBonus.applyBonus(time, bonus)).intValue());
    }

    private void changeResource(TextView view, Long rss, boolean isBuilding) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.ITALIAN);
        symbols.setGroupingSeparator(' ');
        DecimalFormat pattern = new DecimalFormat("#,###", symbols);

        int bonus = (isBuilding ? cumulativeBonus.getBuildingCostEfficiencyBonus() : cumulativeBonus.getResearchBaseCostEfficiencyBonus());

        try { view.setText(pattern.format(cumulativeBonus.applyBonus(rss, bonus)));
        } catch (Exception ignored) {}
    }

    private void changePercentages(Integer buildings, Integer research) {
        try {
            if (buildings != -1) binding.fragOverviewBuildingsPercentage.setTag(buildings);
            if (research != -1) binding.fragOverviewResearchPercentage.setTag(research);

            Integer _B = (buildings != -1 ? buildings : (Integer)binding.fragOverviewBuildingsPercentage.getTag());
            Integer _R = (research != -1 ? research : (Integer)binding.fragOverviewResearchPercentage.getTag());

            setAnimator(_B, animation -> binding.fragOverviewBuildingsPercentage.setText(getString(R.string.percentage, (int)animation.getAnimatedValue()))).start();
            setAnimator(_R, animation -> binding.fragOverviewResearchPercentage.setText(getString(R.string.percentage, (int)animation.getAnimatedValue()))).start();
            setAnimator(Math.round((_B + _R) / 2f), animation -> binding.fragOverviewTotalPercentage.setText(getString(R.string.percentage, (int)animation.getAnimatedValue()))).start();
        } catch (Exception ignored) {}
    }

    private ValueAnimator setAnimator(int endValue, ValueAnimator.AnimatorUpdateListener listener) {
        ValueAnimator animator = ValueAnimator.ofInt(0, endValue);
        animator.setDuration(2000);
        animator.addUpdateListener(listener);
        animators.add(animator);
        return animator;
    }

    private class MaterialAdapter extends BaseAdapter {
        private ListCustomResourceItemBinding bindingMaterials;

        private List<ResourceMaterial> materials = new LinkedList<>();

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) bindingMaterials = ListCustomResourceItemBinding.inflate(getLayoutInflater(), parent, false);

            ResourceMaterial resMat = materials.get(position);

            bindingMaterials.item.setMaterial(resMat.getMaterial());
            bindingMaterials.item.setGrade(resMat.getGrade());
            bindingMaterials.item.setRarity(resMat.getRarity());
            bindingMaterials.item.setNeeded(true);
            bindingMaterials.item.setIsBackgroundVisible(false);
            bindingMaterials.item.setValue(Long.valueOf(resMat.getValue()).intValue());

            return bindingMaterials.getRoot();
        }

        void setMaterials(List<ResourceMaterial> materials) {
            this.materials = materials;
            notifyDataSetChanged();
        }

        @Override
        public ResourceMaterial getItem(int position) {
            return materials.get(position);
        }

        @Override
        public long getItemId(int position) {
            return materials.get(position).getId();
        }

        @Override
        public int getCount() {
            return materials.size();
        }
    }


}


