package com.umbrella.stfctracker.Database.TypeConverters;

import androidx.room.TypeConverter;

import com.umbrella.stfctracker.DataTypes.Enums.Faction;

public class FactionConverter {

    @TypeConverter
    public Faction fromInt(int index) {
        return (index == -1) ? null : Faction.values()[index];
    }

    @TypeConverter
    public int toInt(Faction faction) {
        return (faction == null) ? -1 : faction.ordinal();
    }
}
