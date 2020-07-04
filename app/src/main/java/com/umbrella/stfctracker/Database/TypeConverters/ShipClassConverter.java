package com.umbrella.stfctracker.Database.TypeConverters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.umbrella.stfctracker.DataTypes.Enums.ShipClass;

import java.util.LinkedList;

public class ShipClassConverter {

    @TypeConverter
    public String fromShipClass(LinkedList<ShipClass> shipClasses) {
        if (shipClasses == null) return null;
        return new Gson().toJson(shipClasses, new TypeToken<LinkedList<ShipClass>>(){}.getType());
    }

    @TypeConverter
    public LinkedList<ShipClass> toShipClass(String shipClassString) {
        if (shipClassString == null) return null;
        return new Gson().fromJson(shipClassString, new TypeToken<LinkedList<ShipClass>>(){}.getType());
    }
}
