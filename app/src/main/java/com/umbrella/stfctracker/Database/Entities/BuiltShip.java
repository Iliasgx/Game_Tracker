package com.umbrella.stfctracker.Database.Entities;

import android.os.Parcelable;

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

@Entity(tableName = "built_ship")
public class BuiltShip extends Ship implements Serializable {

    @ColumnInfo(name = "current_tier")
    private int currentTierId;

    public BuiltShip(String name, Rarity rarity, Grade grade, ShipClass shipClass, Faction faction, String image, int baseStrength, String shipAbility, int requiredOperationsLevel, int scrapRequiredOperationsLevel, LinkedList<Tier> tiers, int currentTierId) {
        super(name, rarity, grade, shipClass, faction, image, baseStrength, shipAbility, requiredOperationsLevel, scrapRequiredOperationsLevel, tiers);
        this.currentTierId = currentTierId;
    }

    @Ignore
    public BuiltShip(Ship ship) {
        super(ship.getName(),
                ship.getRarity(),
                ship.getGrade(),
                ship.getShipClass(),
                ship.getFaction(),
                ship.getImage(),
                ship.getBaseStrength(),
                ship.getShipAbility(),
                ship.getRequiredOperationsLevel(),
                ship.getScrapRequiredOperationsLevel(),
                ship.getTiers());
        this.currentTierId = 1;
    }

    public int getCurrentTierId() {
        return currentTierId;
    }

    public void setCurrentTierId(int currentTier) {
        this.currentTierId = currentTier;
    }

    @Ignore
    public Tier getCurrentTier() {
        return getTiers().get(getCurrentTierId() - 1);
    }

    @Ignore
    public Tier getNextTier() {
        return getTiers().get(getCurrentTierId());
    }

}
