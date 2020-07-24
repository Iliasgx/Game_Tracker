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

    LiveData<List<BuiltShip>> getLiveAllBuiltShip() {
        return daoBuiltShip.getLiveAll();
    }

    LiveData<BuiltShip> getShipById(long id) {
        return daoBuiltShip.getBuiltShip(id);
    }

    public void scrap(BuiltShip builtShip) {
        DatabaseClient.dbWriteExecutor.execute(() -> daoBuiltShip.delete(builtShip));
    }

    void tierDown(BuiltShip builtShip) {
        if (builtShip.getCurrentTierId() == 1) return;

        builtShip.setCurrentTierId(builtShip.getCurrentTierId() - 1);

        //Set components of the previous tier (what we are setting now) to locked
        builtShip.getCurrentTier().getComponents().forEach(component -> component.setLocked(true));
        //Set components of the tier we came from to locked. We haven't reached those components yet so we can't have unlocked them.
        builtShip.getNextTier().getComponents().forEach(component -> component.setLocked(true));

        DatabaseClient.dbWriteExecutor.execute(() -> daoBuiltShip.tierDown(builtShip));
    }
}
