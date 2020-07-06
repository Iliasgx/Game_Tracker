package com.umbrella.stfctracker.Database.Models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.umbrella.stfctracker.Database.Entities.BuiltShip;

import java.util.List;

public class BuiltShipViewModel extends AndroidViewModel {
    private BuiltShipRepository mRepos;

    private List<BuiltShip> builtShips;
    private LiveData<List<BuiltShip>> liveDataList;

    public BuiltShipViewModel(@NonNull Application application) {
        super(application);

        mRepos = new BuiltShipRepository(application);
        liveDataList = mRepos.getLiveAllBuiltShip();
    }

    public LiveData<List<BuiltShip>> getAllBuiltShipsLive() {
        return liveDataList;
    }

    public LiveData<BuiltShip> getShipById(long id) {
        return mRepos.getShipById(id);
    }

    public void onTierDown(BuiltShip builtShip) {
        mRepos.tierDown(builtShip);
    }

    public void onScrap(BuiltShip builtShip) {
        mRepos.scrap(builtShip);
    }
}
