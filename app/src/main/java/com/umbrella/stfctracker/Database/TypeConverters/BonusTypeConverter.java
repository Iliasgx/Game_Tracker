package com.umbrella.stfctracker.Database.TypeConverters;

import androidx.room.TypeConverter;

import com.umbrella.stfctracker.DataTypes.Enums.BonusType;

public class BonusTypeConverter {

    @TypeConverter
    public BonusType fromInt(int index) {
        if (index == -1) return null;
        return BonusType.values()[index];
    }

    @TypeConverter
    public int toInt(BonusType bonus) {
        if (bonus == null) return -1;
        return bonus.ordinal();
    }
}
