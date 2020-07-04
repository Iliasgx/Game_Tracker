package com.umbrella.stfctracker.Database.TypeConverters;

import androidx.room.TypeConverter;

import com.umbrella.stfctracker.DataTypes.Enums.Rarity;

public class RarityConverter {

    @TypeConverter
    public Rarity fromInt(int index) {
        return (index == -1) ? null : Rarity.values()[index];
    }

    @TypeConverter
    public int toInt(Rarity rarity) {
        return (rarity == null) ? -1 : rarity.ordinal();
    }
}
