package com.umbrella.stfctracker.Database.Entities;

import androidx.annotation.IntRange;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.umbrella.stfctracker.DataTypes.Enums.BonusType;
import com.umbrella.stfctracker.DataTypes.Enums.Tree;

import java.io.Serializable;
import java.util.LinkedList;

@Entity(tableName = "research")
public class Research implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "image")
    private String image;

    @ColumnInfo(name = "unlocked_level")
    private int unlockedLevel;

    @ColumnInfo(name = "bonus")
    private BonusType bonus;

    @ColumnInfo(name = "position_x")
    private int positionX;

    @ColumnInfo(name = "position_y")
    private int positionY;

    @ColumnInfo(name = "tree")
    private Tree tree;

    @ColumnInfo(name = "levels")
    private LinkedList<Level> levels;

    public Research(String name, String description, String image, Tree tree, BonusType bonus, int unlockedLevel, @IntRange(from = 1, to = 3) int positionX, int positionY, LinkedList<Level> levels) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.unlockedLevel = unlockedLevel;
        this.bonus = bonus;
        this.positionX = positionX;
        this.positionY = positionY;
        this.tree = tree;
        this.levels = levels;
    }

    @Ignore
    public static final String EMPTY_NAME = "EMPTY";

    //Used to create empty items
    @Ignore
    public Research() {
        this.name = EMPTY_NAME;
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getImage() {
        return image;
    }
    public int getUnlockedLevel() {
        return unlockedLevel;
    }
    public BonusType getBonus() {
        return bonus;
    }
    public int getPositionX() {
        return positionX;
    }
    public int getPositionY() {
        return positionY;
    }
    public Tree getTree() {
        return tree;
    }
    public LinkedList<Level> getLevels() {
        return levels;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setUnlockedLevel(int unlockedLevel) {
        this.unlockedLevel = unlockedLevel;
    }
    public void setBonus(BonusType bonus) {
        this.bonus = bonus;
    }
    public void setPositionX(@IntRange(from = 1, to = 3) int positionX) {
        this.positionX = positionX;
    }
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    public void setTree(Tree tree) {
        this.tree = tree;
    }
    public void setLevels(LinkedList<Level> levels) {
        this.levels = levels;
    }
}
