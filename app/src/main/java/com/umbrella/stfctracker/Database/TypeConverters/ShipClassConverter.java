package com.umbrella.stfctracker.Database.TypeConverters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.umbrella.stfctracker.DataTypes.Enums.ShipClass;

import java.util.LinkedList;

public class ShipClassConverter {

    @TypeConverter
    public ShipClass fromInt(int index) {
        return (index == -1) ? null : ShipClass.values()[index];
    }

    @TypeConverter
    public int toInt(ShipClass shipClass) {
        return (shipClass == null) ? -1 : shipClass.ordinal();
    }
}
