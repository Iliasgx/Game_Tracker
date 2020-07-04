package com.umbrella.stfctracker.Database.TypeConverters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.umbrella.stfctracker.Database.Entities.Tier;

import java.util.LinkedList;

public class TierConverter {

    @TypeConverter
    public String fromTierList(LinkedList<Tier> tiers) {
        if (tiers == null) return null;
        return new Gson().toJson(tiers, new TypeToken<LinkedList<Tier>>(){}.getType());
    }

    @TypeConverter
    public LinkedList<Tier> toTierList(String tiersString) {
        if (tiersString == null) return null;
        return new Gson().fromJson(tiersString, new TypeToken<LinkedList<Tier>>(){}.getType());
    }
}
