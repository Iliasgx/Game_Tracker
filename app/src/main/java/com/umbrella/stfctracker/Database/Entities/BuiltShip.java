package com.umbrella.stfctracker.Database.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.umbrella.stfctracker.DataTypes.Enums.Grade;
import com.umbrella.stfctracker.DataTypes.Enums.Rarity;
import com.umbrella.stfctracker.DataTypes.Enums.ShipClass;

import java.io.Serializable;
import java.util.LinkedList;

@Entity(tableName = "built_ship")
public class BuiltShip extends Ship implements Serializable {

    @ColumnInfo(name = "current_tier")
    private int currentTier;

    public BuiltShip(String name, Rarity rarity, Grade grade, ShipClass shipClass, String image, int baseStrength, String shipAbility, int requiredOperationsLevel, int scrapRequiredOperationsLevel, LinkedList<Tier> tiers, int currentTier) {
        super(name, rarity, grade, shipClass, image, baseStrength, shipAbility, requiredOperationsLevel, scrapRequiredOperationsLevel, tiers);
        this.currentTier = currentTier;
    }

    public int getCurrentTier() {
        return currentTier;
    }

    public void setCurrentTier(int currentTier) {
        this.currentTier = currentTier;
    }
}
