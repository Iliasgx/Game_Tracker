package com.umbrella.stfctracker.Database.Models;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.umbrella.stfctracker.DataTypes.Enums.Tree;
import com.umbrella.stfctracker.Database.Dao.DaoResearch;
import com.umbrella.stfctracker.Database.DatabaseClient;
import com.umbrella.stfctracker.Database.Entities.Research;
import com.umbrella.stfctracker.Structures.CumulativeBonus;

import java.util.List;

public class ResearchRepository {

    private DaoResearch daoResearch;
    private Tree tree;

    public ResearchRepository(Application application, Tree tree) {
        DatabaseClient client = DatabaseClient.getInstance(application.getApplicationContext());
        daoResearch = client.daoResearch();

        this.tree = tree;
    }

    LiveData<List<Research>> getLiveResearch() {
        return tree == null ? daoResearch.getLiveAll() : daoResearch.getResearchOfTree(tree);
    }

    void levelDown(Research research) {
        if (research.getUnlockedLevel() != 0) {
            research.setUnlockedLevel(research.getUnlockedLevel() - 1);

            CumulativeBonus bonus = CumulativeBonus.getInstance();

            if (research.getBonus() != null) {
                if (research.getUnlockedLevel() != 0) {
                    bonus.setValue(research.getBonus(), research.getLevels().get(research.getUnlockedLevel() - 1).getBonusA());
                } else {
                    bonus.setValue(research.getBonus(), 0);
                }
            }

            DatabaseClient.dbWriteExecutor.execute(() -> daoResearch.levelDown(research));
        }
    }
}


