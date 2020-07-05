package com.umbrella.stfctracker.Database.Models;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.umbrella.stfctracker.Database.Dao.DaoBuilding;
import com.umbrella.stfctracker.Database.DatabaseClient;
import com.umbrella.stfctracker.Database.Entities.Building;
import com.umbrella.stfctracker.Structures.CumulativeBonus;
import com.umbrella.stfctracker.Structures.Data;

import java.util.List;
import java.util.stream.Collectors;

public class BuildingRepository {
    private DaoBuilding daoBuilding;

    public BuildingRepository(Application application) {
        DatabaseClient client = DatabaseClient.getInstance(application.getApplicationContext());
        daoBuilding = client.daoBuilding();
    }

    LiveData<List<Building>> getLiveBuildings() {
        return daoBuilding.getLiveAll();
    }

    void levelDown(Building building) {
        if (building.getLevels().stream()
                .filter(level -> level.getLevel() == 1)
                .collect(Collectors.toList()).get(0).getRequiredOperationsLevel() != building.getUnlockedLevel()) {

            CumulativeBonus bonus = CumulativeBonus.getInstance();

            building.setUnlockedLevel(building.getUnlockedLevel() - 1);

            if (building.getName().equals("Operations")) Data.getInstance().setOperationsLevel(building.getUnlockedLevel());

            if (building.getBonusTypeA() != null) {
                if (building.getUnlockedLevel() != 0) {
                    bonus.setValue(building.getBonusTypeA(), building.getLevels().get(building.getUnlockedLevel() - 1).getBonusA());
                } else {
                    bonus.setValue(building.getBonusTypeA(), 0);
                }
            }
            if (building.getBonusTypeB() != null) {
                if (building.getUnlockedLevel() != 0) {
                    bonus.setValue(building.getBonusTypeB(), building.getLevels().get(building.getUnlockedLevel() - 1).getBonusB());
                } else {
                    bonus.setValue(building.getBonusTypeB(), 0);
                }
            }

            DatabaseClient.dbWriteExecutor.execute(() -> daoBuilding.levelDown(building));
        }
    }
}
