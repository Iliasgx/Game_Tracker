package com.umbrella.stfctracker.Database.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.umbrella.stfctracker.DataTypes.Enums.BonusType;
import com.umbrella.stfctracker.DataTypes.Enums.Group;

import java.io.Serializable;
import java.util.LinkedList;

@Entity(tableName = "building")
public class Building implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "group")
    private Group group;

    @ColumnInfo(name = "unlocked_level")
    private int unlockedLevel;

    @ColumnInfo(name = "bonus_one")
    private BonusType bonusTypeA;

    @ColumnInfo(name = "bonus_two")
    private BonusType bonusTypeB;

    @ColumnInfo(name = "levels")
    private LinkedList<Level> levels;

    public Building(String name, Group group, int unlockedLevel, BonusType bonusTypeA, BonusType bonusTypeB, LinkedList<Level> levels) {
        this.name = name;
        this.group = group;
        this.unlockedLevel = unlockedLevel;
        this.bonusTypeA = bonusTypeA;
        this.bonusTypeB = bonusTypeB;
        this.levels = levels;
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Group getGroup() {
        return group;
    }
    public int getUnlockedLevel() {
        return unlockedLevel;
    }
    public LinkedList<Level> getLevels() {
        return levels;
    }
    public BonusType getBonusTypeA() {
        return bonusTypeA;
    }
    public BonusType getBonusTypeB() {
        return bonusTypeB;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGroup(Group group) {
        this.group = group;
    }
    public void setUnlockedLevel(int unlockedLevel) {
        this.unlockedLevel = unlockedLevel;
    }
    public void setLevels(LinkedList<Level> levels) {
        this.levels = levels;
    }
    public void setBonusTypeA(BonusType bonusTypeA) {
        this.bonusTypeA = bonusTypeA;
    }
    public void setBonusTypeB(BonusType bonusTypeB) {
        this.bonusTypeB = bonusTypeB;
    }

    @Ignore
    public static Building createEmptyBuilding(Group group) {
        return new Building(getGroupsName(group), group, 0, null, null, new LinkedList<>());
    }

    @Ignore
    public static String getGroupsName(Group grp) {
        String[] stringSets = grp.name().split("_");

        StringBuilder builder = new StringBuilder();
        for (String set : stringSets) {
            if (!set.equalsIgnoreCase(stringSets[0])) builder.append(" ");

            builder.append(set.substring(0,1).toUpperCase());
            builder.append(set.substring(1).toLowerCase());
        }

        return builder.toString();
    }
}
