package com.umbrella.stfctracker.Database.Models;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.umbrella.stfctracker.Database.Dao.DaoShip;
import com.umbrella.stfctracker.Database.DatabaseClient;
import com.umbrella.stfctracker.Database.Entities.Ship;

import java.util.List;

public class ShipRepository {
    private DaoShip daoShip;

    public ShipRepository(Application application) {
        DatabaseClient client = DatabaseClient.getInstance(application.getApplicationContext());
        daoShip = client.daoShip();
    }

    LiveData<List<Ship>> getLiveShips() {
        return daoShip.getLiveAll();
    }
}
