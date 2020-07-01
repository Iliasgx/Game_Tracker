package com.umbrella.stfctracker.ui.Dialogs;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.MutableLiveData;

import com.umbrella.stfctracker.CustomComponents.InformationLabel;
import com.umbrella.stfctracker.CustomComponents.ResourceAmount;
import com.umbrella.stfctracker.CustomComponents.ResourceMaterialAmount;
import com.umbrella.stfctracker.DataTypes.Enums.BonusType;
import com.umbrella.stfctracker.DataTypes.ResourceMaterial;
import com.umbrella.stfctracker.Database.DatabaseClient;
import com.umbrella.stfctracker.Database.Entities.Building;
import com.umbrella.stfctracker.Database.Entities.Level;
import com.umbrella.stfctracker.R;
import com.umbrella.stfctracker.Structures.CumulativeBonus;
import com.umbrella.stfctracker.Structures.Data;
import com.umbrella.stfctracker.Structures.TimeDisplay;
import com.umbrella.stfctracker.databinding.PopoverBuildingsBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BuildingDialog extends DialogFragment {
    private PopoverBuildingsBinding binding;

    private CumulativeBonus cumulativeBonus = CumulativeBonus.getInstance();

    private MutableLiveData<Building> observeBuilding;
    private Level level;
    private Level nextLevel = null; //If no further level.

    private boolean isUpgradeable = true;

    //Accessed through level selector instead of next upgrade.
    private boolean isSpecAccess = false;

    //Empty constructor required for dialogs.
    public BuildingDialog() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = PopoverBuildingsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        BuildingDialogArgs args = BuildingDialogArgs.fromBundle(requireArguments());
        isSpecAccess = (args.getAccesLevel() != -1);

        observeBuilding = new MutableLiveData<>(args.getBuilding());

        if (isUpgradeable && args.getBuilding().getUnlockedLevel() == 0) {
            level = null;
            nextLevel = args.getBuilding().getLevels().get(0);
        } else {
            level = args.getBuilding().getLevels().get(isSpecAccess ? args.getAccesLevel() - 1 : args.getBuilding().getUnlockedLevel() - 1);

            nextLevel = (args.getBuilding().getLevels().size() > level.getLevel())
                    ? args.getBuilding().getLevels().get(level.getLevel()) // Next level
                    : null; // Is last level
        }

        fillBaseData(args.getBuilding());
        setUpObserver();
    }

    private void fillBaseData(Building building) {
        binding.popoverBuildingsName.setText(building.getName());
        binding.popoverBuildingsLevelMaxValue.setText(String.valueOf(building.getLevels().size()));

        binding.popoverBuildingsUpgradeLayout.setOnClickListener(listener -> {
            binding.popoverBuildingsUpgradeLayout.setClickable(false);
            DatabaseClient.dbWriteExecutor.execute(() -> {
                building.setUnlockedLevel(nextLevel.getLevel());
                DatabaseClient.getInstance(requireContext()).daoBuilding().levelUp(building);

                if (building.getBonusTypeA() != null) cumulativeBonus.setValue(building.getBonusTypeA(), nextLevel.getBonusA());
                if (building.getBonusTypeB() != null) cumulativeBonus.setValue(building.getBonusTypeB(), nextLevel.getBonusB());

                level = nextLevel;
                nextLevel = building.getLevels().size() > level.getLevel() ? building.getLevels().get(building.getUnlockedLevel()) : level;

                if (building.getName().equals("Operations")) Data.getInstance().setOperationsLevel(level.getLevel());

                isUpgradeable = (!isSpecAccess && nextLevel != null && nextLevel.getRequiredOperationsLevel() <= Data.getInstance().getOperationsLevel());

                observeBuilding.postValue(building);
            });
        });
    }

    private void setUpObserver() {
        observeBuilding.observe(getViewLifecycleOwner(), building -> {
            //Get all views of @{ResourceMaterialAmount, ResourceAmount}
            LinkedList<ResourceMaterialAmount> rma = new LinkedList<>(Arrays.asList(binding.popoverBuildingsMaterialA, binding.popoverBuildingsMaterialB));
            LinkedList<ResourceAmount> ra = new LinkedList<>(Arrays.asList(binding.popoverBuildingsAmountA, binding.popoverBuildingsAmountB, binding.popoverBuildingsAmountC));

            //boolean isLastOne = (building.getUnlockedLevel() == building.getLevels().size());
            boolean isLastOne = (level.getLevel() == building.getLevels().size());

            binding.popoverBuildingsUpgradeLayout.setClickable(isUpgradeable);
            binding.popoverBuildingsUpgradeFrame.setVisibility(isUpgradeable ? View.VISIBLE : View.INVISIBLE);

            binding.popoverBuildingsUpgradeLayout.setClickable(isUpgradeable);
            binding.popoverBuildingsUpgradeLayout.setVisibility(isLastOne | isSpecAccess ? View.GONE : View.VISIBLE);
            binding.popoverBuildingsUpgradeFrame.setVisibility(isUpgradeable ? View.VISIBLE : View.INVISIBLE);

            binding.popoverBuildingsLevelValue.setText(String.valueOf(level != null ? level.getLevel() : 0));

            binding.popoverBuildingsUpgradeTime.setText((nextLevel == null) ? "" : new TimeDisplay(requireContext())
                    .getTime( cumulativeBonus.applyBonus(nextLevel.getUpgradeTime(), cumulativeBonus.getBuildSpeedBonus())));

            //Get all materials/resources of the level.
            LinkedList<ResourceMaterial> popMaterials = ((nextLevel != null && nextLevel.getMaterials() != null) ? nextLevel.getMaterials() : new LinkedList<>());
            LinkedList<ResourceMaterial> popResources = ((nextLevel != null && nextLevel.getResources() != null) ? nextLevel.getResources() : new LinkedList<>());

            //Set details of material.
            popMaterials.forEach(resourceMaterial -> {
                ResourceMaterialAmount item = rma.pop();

                item.setValue(Long.valueOf(resourceMaterial.getValue()).intValue());
                item.setRarity(resourceMaterial.getRarity());
                item.setMaterial(resourceMaterial.getMaterial());
                item.setStars(resourceMaterial.getStars());
                item.setNeeded(!isLastOne);
            });

            //Set details of resources.
            popResources.forEach(resourceMaterial -> {
                ResourceAmount item = ra.pop();

                long resVal = resourceMaterial.getValue();

                //Exception for this current building and his level because of the size of the value.
                if (building.getName().equalsIgnoreCase("Parsteel Warehouse") && nextLevel.getLevel() == 50) resVal *= 2;

                item.setValue(cumulativeBonus.applyBonus(resVal, cumulativeBonus.getBuildingCostEfficiencyBonus()));
                item.setMaterial(resourceMaterial.getMaterial());
                item.setNeeded(!isLastOne);

                item.setOnClickListener(view -> {
                    InformationLabel label = new InformationLabel(requireContext());
                    label.setValue(item.getValue());
                    label.setLocation(view, -15, -10);
                    binding.popoverBuildingsCardView.addView(label);
                });
            });

            //Set all residual views to NOT needed.
            rma.forEach(item -> item.setNeeded(false));
            ra.forEach(item -> item.setNeeded(false));

            //Add bonuses for the listView when they are not null (no bonus).
            List<BonusListInfo.BonusItem> bonusItems = new ArrayList<>();

            if (level != null && building.getBonusTypeA() != null) bonusItems.add(
                    new BonusListInfo.BonusItem(building.getBonusTypeA(), cumulativeBonus
                            .applyBonus(level.getBonusA(), cumulativeBonus.applySpecificBonus(building.getBonusTypeA()))
                    )
            );

            if (level != null && building.getBonusTypeB() != null) bonusItems.add(
                    new BonusListInfo.BonusItem(building.getBonusTypeB(), cumulativeBonus
                            .applyBonus(level.getBonusB(), cumulativeBonus.applySpecificBonus(building.getBonusTypeB()))
                    )
            );

            BonusListInfo.BonusAdapter bonusAdapter = new BonusListInfo.BonusAdapter(requireContext(), bonusItems);
            binding.popoverBuildingsListView.setAdapter(bonusAdapter);
        });
    }

    private static class BonusListInfo {
        static class BonusItem {
            private String title;
            private int bonus;

            BonusItem(BonusType title, int bonus) {
                this.title = getBonusName(title);
                this.bonus = bonus;
            }

            String getTitle() {
                return title;
            }

            String getBonus() {
                return String.valueOf(bonus);
            }

            private String getBonusName(BonusType grp) {
                String[] stringSets = grp.name().split("_");

                StringBuilder builder = new StringBuilder();
                for (String set : stringSets) {
                    if (!set.equalsIgnoreCase(stringSets[0])) builder.append(" ");

                    builder.append(set.substring(0, 1).toUpperCase());
                    builder.append(set.substring(1).toLowerCase());
                }

                return builder.toString();
            }
        }

        static class BonusAdapter extends ArrayAdapter<BonusItem> {
            private Context mContext;
            private List<BonusItem> items;

            BonusAdapter(@NonNull Context context, List<BonusItem> items) {
                super(context, 0, items);
                this.mContext = context;
                this.items = items;
            }

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                if (convertView == null) convertView = LayoutInflater.from(mContext).inflate(R.layout.list_building_bonus_item, parent, false);

                BonusItem bonusItem = items.get(position);

                TextView titleView = convertView.requireViewById(R.id.listBuildingBonusItem_name);
                TextView bonusView = convertView.requireViewById(R.id.listBuildingBonusItem_value);

                titleView.setText(bonusItem.getTitle());
                bonusView.setText(bonusItem.getBonus());

                return convertView;
            }
        }
    }
}