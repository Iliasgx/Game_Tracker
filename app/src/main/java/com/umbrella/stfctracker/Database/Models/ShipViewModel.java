package com.umbrella.stfctracker.Database.Models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.umbrella.stfctracker.Database.Entities.Ship;

import java.util.List;

public class ShipViewModel extends AndroidViewModel {
    private ShipRepository mRepos;

    private List<Ship> ships;
    private LiveData<List<Ship>> liveDataList;

    public ShipViewModel(@NonNull Application application) {
        super(application);

        mRepos = new ShipRepository(application);
        liveDataList = mRepos.getLiveShips();
    }

    public LiveData<List<Ship>> getAllShipsLive() {
        return liveDataList;
    }
}
