package com.umbrella.stfctracker.Database.TypeConverters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.umbrella.stfctracker.Database.Entities.Level;

import java.util.LinkedList;

public class LevelListConverter {

    @TypeConverter
    public static String fromListLevels(LinkedList<Level> levels) {
        return new Gson().toJson(levels);
    }

    @TypeConverter
    public static LinkedList<Level> toListLevels(String data) {
        if (data == null) return new LinkedList<>();

        return new Gson().fromJson(data, new TypeToken<LinkedList<Level>>(){}.getType());
    }
}
