package com.umbrella.stfctracker.Database.TypeConverters;

import androidx.room.TypeConverter;

import com.umbrella.stfctracker.DataTypes.Enums.Tree;

public class ResearchTreeConverter {

    @TypeConverter
    public Tree fromInt(int ordinal) {
        return Tree.values()[ordinal];
    }

    @TypeConverter
    public int toInt(Tree tree) {
        return tree.ordinal();
    }
}
