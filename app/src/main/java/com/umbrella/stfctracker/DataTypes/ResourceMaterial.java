package com.umbrella.stfctracker.DataTypes;

import com.umbrella.stfctracker.DataTypes.Enums.Grade;
import com.umbrella.stfctracker.DataTypes.Enums.Material;
import com.umbrella.stfctracker.DataTypes.Enums.Rarity;

public final class ResourceMaterial {

    private int id;
    private Material material;
    private Rarity rarity;
    private Grade grade;
    private long value;

    //Materials
    public ResourceMaterial(int id, Material material, Rarity rarity, Grade grade, long value) {
        this.id = id;
        this.material = material;
        this.rarity = rarity;
        this.grade = grade;
        this.value = value;
    }

    //Resources
    public ResourceMaterial(int id, Material material, long value) {
        this.id = id;
        this.material = material;
        this.rarity = null;
        this.grade = null;
        this.value = value;
    }

    //Parts (only COMMON) others should use the 'Constructor for Materials'
    public ResourceMaterial(int id, Material material, Grade grade, long value) {
        this.id = id;
        this.material = material;
        this.rarity = Rarity.COMMON;
        this.grade = grade;
        this.value = value;
    }

    public int getId() {
        return id;
    }
    public Material getMaterial() {
        return material;
    }
    public Rarity getRarity() {
        return rarity;
    }
    public Grade getGrade() {
        return grade;
    }
    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
