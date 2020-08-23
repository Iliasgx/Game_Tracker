package com.umbrella.stfctracker.Structures;

import android.content.Context;

import com.umbrella.stfctracker.MainActivity;

public class DataSaver {
    private static final DataSaver mInstance = new DataSaver();

    private MainActivity main;

    public static DataSaver getInstance() {
        return mInstance;
    }

    private DataSaver() {
    }

    public void setActivity(MainActivity main) {
        this.main = main;
    }

    public synchronized void saveData(String key, Integer value) {
        if (main != null) {
            main.getPreferences(Context.MODE_PRIVATE).edit().putInt(key, value).apply();
        }
    }
}
