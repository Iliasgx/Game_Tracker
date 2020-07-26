package com.umbrella.stfctracker.ui.Dialogs;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.MutableLiveData;

import com.umbrella.stfctracker.CustomComponents.CustomResourceMaterialView;
import com.umbrella.stfctracker.DataTypes.Enums.Material;
import com.umbrella.stfctracker.DataTypes.ResourceMaterial;
import com.umbrella.stfctracker.Database.DatabaseClient;
import com.umbrella.stfctracker.Database.Entities.Building;
import com.umbrella.stfctracker.Database.Entities.Level;
import com.umbrella.stfctracker.R;
import com.umbrella.stfctracker.Structures.CumulativeBonus;
import com.umbrella.stfctracker.Structures.Data;
import com.umbrella.stfctracker.databinding.DialogBuildingsBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class BuildingDialog extends DialogFragment {
    private DialogBuildingsBinding binding;

    private CumulativeBonus cumulativeBonus = CumulativeBonus.getInstance();

    private Building building;
    private MutableLiveData<Level> observedLevel = new MutableLiveData<>();

    private Level currentLevel;
    private Level nextLevel;

    private boolean isMaxLevel = false;

    //True if the user selected a level to view, not to upgrade a building.
    private boolean spectatorMode = false;

    public BuildingDialog() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogBuildingsBinding.inflate(inflater, container, false);
        Objects.requireNonNull(requireDialog().getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        BuildingDialogArgs args = BuildingDialogArgs.fromBundle(requireArguments());
        building = args.getBuilding();

        spectatorMode = (args.getAccesLevel() != -1);
        setCurrentLevel();

        observedLevel = new MutableLiveData<>(currentLevel);
        addObservers();

        binding.dialogBuildingsName.setText(building.getName());
        binding.dialogBuildingsLevelMaxValue.setText(String.valueOf(building.getLevels().size()));
    }

    private void addObservers() {
        observedLevel.observe(getViewLifecycleOwner(), level -> {
            isMaxLevel = building.getLevels().size() == level.getLevel();
            setCurrentLevel();
            setNextLevel();

            //Button not usable in spectatorMode or when building is maxed and can't be upgraded.
            binding.dialogBuildingsButton.setUsable(!spectatorMode && !isMaxLevel && nextLevel.getRequiredOperationsLevel() <= Data.getInstance().getOperationsLevel());

            //Show time of next level.
            if (!isMaxLevel) {
                binding.dialogBuildingsButton.setTime(cumulativeBonus.applyBonus(nextLevel.getUpgradeTime(), cumulativeBonus.getBuildSpeedBonus()));
            } else {
                //No next level but in spectatorMode, show time of current level.
                //Else building is maxed, display maxed title and remove time.
                if (spectatorMode) {
                    binding.dialogBuildingsButton.setTime(cumulativeBonus.applyBonus(level.getUpgradeTime(), cumulativeBonus.getBuildSpeedBonus()));
                } else {
                    binding.dialogBuildingsButton.setShowTime(false);
                    binding.dialogBuildingsButton.setTitle(getString(R.string.max_level));
                }
            }

            binding.dialogBuildingsLevelValue.setText(String.valueOf(isZeroLevel() ? 0 : level.getLevel()));

            //Set costs only when building is not max level (except when in spectatorMode).
            if (spectatorMode || !isMaxLevel) {
                //Set resources
                HashMap<Material, Long> resources = new HashMap<>(CustomResourceMaterialView.computeResources(nextLevel.getResources()));

                //Exception for the current building and the level because the size of this buildings value was too big.
                if (building.getName().equalsIgnoreCase("Parsteel Warehouse") && nextLevel.getLevel() == 50) {
                    if (resources.containsKey(Material.PARSTEEL)) {
                        Long tempValue = resources.get(Material.PARSTEEL);
                        resources.replace(Material.PARSTEEL, (tempValue != null ? tempValue : 0L) * 2L);
                    }
                }

                //Apply bonus for resources
                resources.forEach(((material, val) -> resources.replace(material, cumulativeBonus
                        .applyBonus(val, cumulativeBonus.getBuildingCostEfficiencyBonus(material)))
                ));
                binding.dialogBuildingsCosts.setResources(resources);

                //Set materials
                LinkedList<ResourceMaterial> materials = new LinkedList<>(nextLevel.getMaterials());

                materials.forEach(material -> material.setValue(cumulativeBonus
                        .applyBonus(material.getValue(), cumulativeBonus.getBuildingCostEfficiencyBonus(material.getMaterial())))
                );

                binding.dialogBuildingsCosts.setMaterials(materials);
            }

            if(building.getUnlockedLevel() != 0) {
                //Add bonuses
                List<BonusAdapter.BonusItem> bonusItems = new ArrayList<>();
                if (building.getBonusTypeA() != null) bonusItems.add(
                        new BonusAdapter.BonusItem(building.getBonusTypeA().toString(), cumulativeBonus
                                .applyBonus(currentLevel.getBonusA(), cumulativeBonus.applySpecificBonus(building.getBonusTypeA()))
                        )
                );
                if (building.getBonusTypeB() != null) bonusItems.add(
                        new BonusAdapter.BonusItem(building.getBonusTypeB().toString(), cumulativeBonus
                                .applyBonus(currentLevel.getBonusB(), cumulativeBonus.applySpecificBonus(building.getBonusTypeB()))
                        )
                );

                binding.dialogBuildingsListView.setAdapter(new BonusAdapter(requireContext(), bonusItems));
            }
        });

        binding.dialogBuildingsButton.setOnClickListener(v ->
            DatabaseClient.dbWriteExecutor.execute(() -> {
                //Set bonus of next level in CumulativeBonus class.
                if (building.getBonusTypeA() != null) cumulativeBonus.setValue(building.getBonusTypeA(), nextLevel.getBonusA());
                if (building.getBonusTypeB() != null) cumulativeBonus.setValue(building.getBonusTypeB(), nextLevel.getBonusB());

                //When the Operations building is upgraded, Data has to change too because OpsLevel is a requirement for all data retrieval.
                if (building.getName().equalsIgnoreCase("Operations")) Data.getInstance().setOperationsLevel(nextLevel.getLevel());

                //Change unlocked level and save to the database.
                building.setUnlockedLevel(nextLevel.getLevel());
                DatabaseClient.getInstance(requireContext()).daoBuilding().levelUp(building);

                observedLevel.postValue(nextLevel);
            })
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setCurrentLevel() {
        //Return requested level to spectate.
        if (spectatorMode) {
            currentLevel = building.getLevels().get(BuildingDialogArgs.fromBundle(requireArguments()).getAccesLevel() - 1);
        } else {
            //No level unlocked yet, return first.
            if (isZeroLevel()) {
                currentLevel = building.getLevels().getFirst();
            } else {
                //Default: return current unlockedLevel.
                currentLevel = building.getLevels().get(building.getUnlockedLevel() - 1);
            }
        }
    }

    private void setNextLevel() {
        //Spectator mode only observes selected level. | When building is maxed, there is no next level.
        if (spectatorMode | isMaxLevel) {
            //Return current because data that is normally shown from next level should be shown from current now.
            nextLevel = currentLevel;
        } else {
            //Default: return level following the unlockedLevel. Also working when no level was unlocked yet.
            nextLevel = building.getLevels().get(building.getUnlockedLevel());
        }
    }

    private boolean isZeroLevel() {
        return (!spectatorMode && building.getUnlockedLevel() == 0);
    }

    private static class BonusAdapter extends ArrayAdapter<BonusAdapter.BonusItem> {
        private LayoutInflater inflater;
        private List<BonusItem> items;

        public BonusAdapter(@NonNull Context context, List<BonusItem> items) {
            super(context, 0, items);
            this.items = items;
            inflater = LayoutInflater.from(context);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null) convertView = inflater.inflate(R.layout.list_building_bonus_item, parent, false);

            BonusItem bonusItem = items.get(position);

            ((TextView)convertView.requireViewById(R.id.listBuildingBonusItem_name)).setText(bonusItem.getTitle());
            ((TextView)convertView.requireViewById(R.id.listBuildingBonusItem_value)).setText(String.valueOf(bonusItem.getBonus()));

            return convertView;
        }

        static class BonusItem {
            private String title;
            private int bonus;

            public BonusItem(String title, int bonus) {
                this.title = title;
                this.bonus = bonus;
            }

            public String getTitle() {
                return title;
            }
            public int getBonus() {
                return bonus;
            }
        }
    }
}

































