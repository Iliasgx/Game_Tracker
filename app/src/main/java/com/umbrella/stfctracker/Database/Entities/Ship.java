package com.umbrella.stfctracker.Database.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.umbrella.stfctracker.DataTypes.Enums.Faction;
import com.umbrella.stfctracker.DataTypes.Enums.Grade;
import com.umbrella.stfctracker.DataTypes.Enums.Rarity;
import com.umbrella.stfctracker.DataTypes.Enums.ShipClass;

import java.io.Serializable;
import java.util.LinkedList;

@Entity(tableName = "ship")
public class Ship implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "rarity")
    private Rarity rarity;

    @ColumnInfo(name = "grade")
    private Grade grade;

    @ColumnInfo(name = "ship_class")
    private ShipClass shipClass;

    @ColumnInfo(name = "faction")
    private Faction faction;

    @ColumnInfo(name = "image")
    private String image;

    @ColumnInfo(name = "base_strength")
    private int baseStrength;

    @ColumnInfo(name = "ship_ability")
    private String shipAbility;

    @ColumnInfo(name = "required_operations_level")
    private int requiredOperationsLevel;

    @ColumnInfo(name = "scrap_required_operations_level")
    private int scrapRequiredOperationsLevel;

    @ColumnInfo(name = "tiers")
    private LinkedList<Tier> tiers;

    public Ship(String name, Rarity rarity, Grade grade, ShipClass shipClass, Faction faction, String image, int baseStrength, String shipAbility, int requiredOperationsLevel, int scrapRequiredOperationsLevel, LinkedList<Tier> tiers) {
        this.name = name;
        this.rarity = rarity;
        this.grade = grade;
        this.shipClass = shipClass;
        this.faction = faction;
        this.image = image;
        this.baseStrength = baseStrength;
        this.shipAbility = shipAbility;
        this.requiredOperationsLevel = requiredOperationsLevel;
        this.scrapRequiredOperationsLevel = scrapRequiredOperationsLevel;
        this.tiers = tiers;
    }

    @Ignore
    public Ship(String name, Rarity rarity, Grade grade, ShipClass shipClass, Faction faction, String image, int baseStrength, String shipAbility, int requiredOperationsLevel, LinkedList<Tier> tiers) {
        this.name = name;
        this.rarity = rarity;
        this.grade = grade;
        this.shipClass = shipClass;
        this.faction = faction;
        this.image = image;
        this.baseStrength = baseStrength;
        this.shipAbility = shipAbility;
        this.requiredOperationsLevel = requiredOperationsLevel;
        this.scrapRequiredOperationsLevel = -1;
        this.tiers = tiers;
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Rarity getRarity() {
        return rarity;
    }
    public Grade getGrade() {
        return grade;
    }
    public ShipClass getShipClass() {
        return shipClass;
    }
    public Faction getFaction() {
        return faction;
    }
    public String getImage() {
        return image;
    }
    public int getBaseStrength() {
        return baseStrength;
    }
    public String getShipAbility() {
        return shipAbility;
    }
    public int getRequiredOperationsLevel() {
        return requiredOperationsLevel;
    }
    public int getScrapRequiredOperationsLevel() {
        return scrapRequiredOperationsLevel;
    }
    public LinkedList<Tier> getTiers() {
        return tiers;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }
    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    public void setFaction(Faction faction) {
        this.faction = faction;
    }
    public void setShipClass(ShipClass shipClass) {
        this.shipClass = shipClass;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setBaseStrength(int baseStrength) {
        this.baseStrength = baseStrength;
    }
    public void setShipAbility(String shipAbility) {
        this.shipAbility = shipAbility;
    }
    public void setRequiredOperationsLevel(int requiredOperationsLevel) {
        this.requiredOperationsLevel = requiredOperationsLevel;
    }
    public void setScrapRequiredOperationsLevel(int scrapRequiredOperationsLevel) {
        this.scrapRequiredOperationsLevel = scrapRequiredOperationsLevel;
    }
    public void setTiers(LinkedList<Tier> tiers) {
        this.tiers = tiers;
    }
}
