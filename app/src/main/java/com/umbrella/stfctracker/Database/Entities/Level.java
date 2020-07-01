package com.umbrella.stfctracker.Database.Entities;

import com.umbrella.stfctracker.DataTypes.ResourceMaterial;

import java.io.Serializable;
import java.util.LinkedList;

public class Level implements Serializable {

    private int level;
    private int upgradeTime;
    private int requiredOperationsLevel;
    private int bonusA;
    private int bonusB;
    private LinkedList<ResourceMaterial> resources;
    private LinkedList<ResourceMaterial> materials;

    public Level(int level, int upgradeTime, int requiredOperationsLevel, int bonusA, LinkedList<ResourceMaterial> resources, LinkedList<ResourceMaterial> materials) {
        this.level = level;
        this.upgradeTime = upgradeTime;
        this.requiredOperationsLevel = requiredOperationsLevel;
        this.bonusA = bonusA;
        this.bonusB = -1;
        this.resources = resources;
        this.materials = materials;
    }

    public Level(int level, int upgradeTime, int requiredOperationsLevel, int bonusA, int bonusB, LinkedList<ResourceMaterial> resources, LinkedList<ResourceMaterial> materials) {
        this.level = level;
        this.upgradeTime = upgradeTime;
        this.requiredOperationsLevel = requiredOperationsLevel;
        this.bonusA = bonusA;
        this.bonusB = bonusB;
        this.resources = resources;
        this.materials = materials;
    }

    public int getLevel() {
        return level;
    }
    public int getUpgradeTime() {
        return upgradeTime;
    }
    public int getRequiredOperationsLevel() {
        return requiredOperationsLevel;
    }
    public int getBonusA() {
        return bonusA;
    }
    public int getBonusB() {
        return bonusB;
    }
    public LinkedList<ResourceMaterial> getResources() {
        return resources;
    }
    public LinkedList<ResourceMaterial> getMaterials() {
        return materials;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public void setUpgradeTime(int upgradeTime) {
        this.upgradeTime = upgradeTime;
    }
    public void setRequiredOperationsLevel(int requiredOperationsLevel) {
        this.requiredOperationsLevel = requiredOperationsLevel;
    }
    public void setBonusA(int bonusA) {
        this.bonusA = bonusA;
    }
    public void setBonusB(int bonusB) {
        this.bonusB = bonusB;
    }
    public void setResources(LinkedList<ResourceMaterial> resources) {
        this.resources = resources;
    }
    public void setMaterials(LinkedList<ResourceMaterial> materials) {
        this.materials = materials;
    }
}
