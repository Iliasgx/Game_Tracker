package com.umbrella.stfctracker.Database.Models;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.umbrella.stfctracker.DataTypes.Enums.Material;
import com.umbrella.stfctracker.DataTypes.ResourceMaterial;
import com.umbrella.stfctracker.Database.Entities.Building;
import com.umbrella.stfctracker.Database.Entities.Level;
import com.umbrella.stfctracker.Database.Entities.Research;
import com.umbrella.stfctracker.Structures.CumulativeBonus;
import com.umbrella.stfctracker.Structures.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class OverviewViewModel extends AndroidViewModel {
    private LiveData<List<Building>> liveBuildingList;
    private LiveData<List<Research>> liveResearchList;

    private List<Building> buildingList = new ArrayList<>();
    private List<Research> researchList = new ArrayList<>();

    public OverviewViewModel(@NonNull Application application) {
        super(application);
        liveBuildingList = new BuildingRepository(application).getLiveBuildings();
        liveResearchList = new ResearchRepository(application, null).getLiveResearch();
    }

    public LiveData<List<Building>> getLiveBuildings() {
        return liveBuildingList;
    }

    public LiveData<List<Research>> getLiveResearch() {
        return liveResearchList;
    }

    public void setBuildingList(List<Building> buildingList) {
        buildingList.retainAll(buildingList.stream().filter(building -> building.getLevels().stream().anyMatch(level -> level.getRequiredOperationsLevel() <= Data.getInstance().getOperationsLevel())).collect(Collectors.toList()));
        this.buildingList = buildingList;
    }

    public void setResearchList(List<Research> researchList) {
        researchList.retainAll(researchList.stream().filter(research -> research.getLevels().stream().anyMatch(level -> level.getRequiredOperationsLevel() <= Data.getInstance().getOperationsLevel())).collect(Collectors.toList()));
        this.researchList = researchList;
    }

    public LiveData<Integer> getFinishedBuildings() {
        return new MutableLiveData<>(getFinishedPercentage(buildingList));
    }

    public LiveData<Integer> getFinishedResearch() {
        return new MutableLiveData<>(getFinishedPercentage(researchList));
    }

    public LiveData<Integer> getBuildingTime() {
        return new MutableLiveData<>(getTime(buildingList));
    }

    public LiveData<Integer> getResearchTime() {
        return new MutableLiveData<>(getTime(researchList));
    }

    public LiveData<Long> getBuildingResource(Material material) {
        return new MutableLiveData<>(getResource(buildingList, material));
    }

    public LiveData<Long> getResearchResource(Material material) {
        return new MutableLiveData<>(getResource(researchList, material));
    }

    public LiveData<LinkedList<ResourceMaterial>> getAllMaterials() {
        return new MutableLiveData<>(getMaterials());
    }

    private Integer getFinishedPercentage(@NonNull List<?> list) {
        AtomicLong nrOfItems = new AtomicLong(0L);
        AtomicLong nrOfFinishedItems = new AtomicLong(0L);

        list.forEach(item -> {
            LinkedList<Level> levels = (item instanceof Building ? ((Building)item).getLevels() : ((Research)item).getLevels());

            nrOfItems.getAndAdd(levels.stream()
                    .filter(level -> level.getRequiredOperationsLevel() <= Data.getInstance().getOperationsLevel())
                    .count());

            nrOfFinishedItems.getAndAdd(levels.stream()
                    .filter(level -> level.getRequiredOperationsLevel() <= Data.getInstance().getOperationsLevel())
                    .filter(level -> level.getLevel() <= (item instanceof Building ? ((Building)item).getUnlockedLevel() : ((Research)item).getUnlockedLevel()))
                    .count());
        });

        if (list.isEmpty()) {
            return 100;
        } else {
            return Math.round((Long.valueOf(nrOfFinishedItems.get()).floatValue() / Long.valueOf(nrOfItems.get()).floatValue()) * 100);
        }
    }

    private Integer getTime(List<?> list) {
        AtomicInteger time = new AtomicInteger(0);

        list.forEach(item -> {
            LinkedList<Level> levels = (item instanceof Building ? ((Building)item).getLevels() : ((Research)item).getLevels());

            levels.stream()
                    .filter(level -> level.getRequiredOperationsLevel() <= Data.getInstance().getOperationsLevel())
                    .filter(level -> level.getLevel() > (item instanceof Building ? ((Building)item).getUnlockedLevel() : ((Research)item).getUnlockedLevel()))
                    .forEach(level -> time.getAndAdd(level.getUpgradeTime()));
        });

        return time.get();
    }

    private long getResource(List<?> list, Material material) {
        AtomicLong value = new AtomicLong(0L);

        list.forEach(item -> {
            LinkedList<Level> levels = (item instanceof Building ? ((Building)item).getLevels() : ((Research)item).getLevels());

            levels.stream()
                    .filter(level -> level.getRequiredOperationsLevel() <= Data.getInstance().getOperationsLevel())
                    .filter(level -> level.getLevel() > (item instanceof Building ? ((Building)item).getUnlockedLevel() : ((Research)item).getUnlockedLevel()))
                    .forEach(level -> {
                        if (level.getResources() == null) return;
                        boolean doubled = (item instanceof Building && ((Building)item).getName().equalsIgnoreCase("Parsteel Warehouse") && level.getLevel() == 50);

                        level.getResources().stream()
                            .filter(res -> res.getMaterial().equals(material))
                            .findFirst().ifPresent(mat -> value.getAndAdd(mat.getValue() * (doubled ? 2 : 1)));
                    });
        });

        return value.get();
    }

    private LinkedList<ResourceMaterial> getMaterials() {
        CumulativeBonus cumul = CumulativeBonus.getInstance();

        LinkedList<ResourceMaterial> fullList = new LinkedList<>();

        buildingList.forEach(building ->
            building.getLevels().stream()
                .filter(level -> level.getRequiredOperationsLevel() <= Data.getInstance().getOperationsLevel())
                .filter(level -> level.getLevel() > building.getUnlockedLevel())
                .forEach(level -> {
                    if (level.getMaterials() == null) return;
                    level.getMaterials().forEach(mat -> {
                        ResourceMaterial m =  fullList.stream()
                                                .filter(item ->
                                                        (item.getMaterial() == mat.getMaterial()) &&
                                                        (item.getRarity() == mat.getRarity()) &&
                                                        (item.getGrade() == mat.getGrade())
                                                ).findFirst().orElse(null);

                        if (m == null) {
                            fullList.add(mat);
                        } else {
                            ResourceMaterial newMat = fullList.get(fullList.indexOf(m));
                            newMat.setValue(newMat.getValue() + mat.getValue());
                            fullList.set(fullList.indexOf(m), newMat);
                        }
                    });
                })
        );

        //Set bonuses for building materials.
        fullList.forEach(resourceMaterial -> resourceMaterial.setValue(cumul.applyBonus(resourceMaterial.getValue(), cumul.getBuildingCostEfficiencyBonus(resourceMaterial.getMaterial()))));
        final LinkedList<ResourceMaterial> firstList = new LinkedList<>(fullList);

        researchList.forEach(research ->
                research.getLevels().stream()
                        .filter(level -> level.getRequiredOperationsLevel() <= Data.getInstance().getOperationsLevel())
                        .filter(level -> level.getLevel() > research.getUnlockedLevel())
                        .forEach(level -> {
                            if (level.getMaterials() == null) return;
                            level.getMaterials().forEach(mat -> {
                                ResourceMaterial m =  fullList.stream()
                                        .filter(item ->
                                                (item.getMaterial() == mat.getMaterial()) &&
                                                        (item.getRarity() == mat.getRarity()) &&
                                                        (item.getGrade() == mat.getGrade())
                                        ).findFirst().orElse(null);

                                if (m == null) {
                                    fullList.add(mat);
                                } else {
                                    ResourceMaterial newMat = fullList.get(fullList.indexOf(m));
                                    newMat.setValue(newMat.getValue() + mat.getValue());
                                    fullList.set(fullList.indexOf(m), newMat);
                                }
                            });
                        })
        );

        //Find research materials totals without buildings and apply bonus.
        fullList.forEach(resourceMaterial -> {
            ResourceMaterial firstListItem = firstList.stream().filter(mat ->
                    mat.getMaterial() == resourceMaterial.getMaterial() &&
                            mat.getGrade() == resourceMaterial.getGrade() &&
                            mat.getRarity() == resourceMaterial.getRarity()).findFirst().orElse(null);

            long tempValue = resourceMaterial.getValue();
            //Item already existed in buildings
            if (firstListItem != null) tempValue -= firstListItem.getValue();

            resourceMaterial.setValue(cumul.applyBonus(tempValue, cumul.getResearchBaseCostEfficiencyBonus(resourceMaterial.getMaterial())));
        });

        return fullList.stream()
                .sorted(Comparator
                        .comparing(ResourceMaterial::getGrade)
                        .thenComparing(ResourceMaterial::getMaterial)
                        .thenComparing(ResourceMaterial::getRarity))
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
