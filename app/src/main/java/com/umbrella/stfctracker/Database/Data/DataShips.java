package com.umbrella.stfctracker.Database.Data;

import android.content.res.Resources;

import com.umbrella.stfctracker.Database.Entities.Ship;

import java.util.ArrayList;
import java.util.List;

public final class DataShips extends DataFunctions {
    private static DataShips mInstance;

    private List<Ship> ships = new ArrayList<>();

    private Resources db;

    public static DataShips getInstance(Resources db) {
        if (mInstance == null) {
            mInstance = new DataShips(db);
        }
        return mInstance;
    }

    public DataShips(Resources db) {
        this.db = db;
        initData();
    }

    public List<Ship> getShips() {
        return ships;
    }

    private String img(int id) {
        return db.getResourceEntryName(id);
    }

    private void initData() {
        Battleships();
        Explorers();
        Interceptors();
        Surveys();
    }

    private void Battleships() {

    }

    private void Explorers() {

    }

    private void Interceptors() {

    }

    private void Surveys() {

    }
}
