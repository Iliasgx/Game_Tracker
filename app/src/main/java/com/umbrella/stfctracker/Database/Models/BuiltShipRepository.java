package com.umbrella.stfctracker.Database.Models;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.umbrella.stfctracker.Database.Dao.DaoBuiltShip;
import com.umbrella.stfctracker.Database.DatabaseClient;
import com.umbrella.stfctracker.Database.Entities.BuiltShip;

import java.util.List;

public class BuiltShipRepository {
    private DaoBuiltShip daoBuiltShip;

    public BuiltShipRepository(Application application) {
        DatabaseClient client = DatabaseClient.getInstance(application.getApplicationContext());
        daoBuiltShip = client.daoBuiltShip();
    }

    LiveData<List<BuiltShip>> getLiveBuiltShip() {
        return daoBuiltShip.getLiveAll();
    }

    void scrap(BuiltShip builtShip) {
        DatabaseClient.dbWriteExecutor.execute(() -> daoBuiltShip.delete(builtShip));
    }

    void tierDown(BuiltShip builtShip) {
        if (builtShip.getCurrentTier() == 1) return;

        builtShip.setCurrentTier(builtShip.getCurrentTier() - 1);

        DatabaseClient.dbWriteExecutor.execute(() -> daoBuiltShip.tierDown(builtShip));
    }
}