package com.umbrella.stfctracker.Database.Models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.umbrella.stfctracker.DataTypes.Enums.Tree;
import com.umbrella.stfctracker.Database.Entities.Research;

import java.util.List;

public class ResearchViewModel extends AndroidViewModel {
    private ResearchRepository mRepos;

    private LiveData<List<Research>> liveDataList;

    private Application application;

    public ResearchViewModel(@NonNull Application application) {
        super(application);
        this.application = application;
    }

    public void initData(Tree tree) {
        mRepos = new ResearchRepository(application, tree);
        liveDataList = mRepos.getLiveResearch();
    }

    public LiveData<List<Research>> getAllResearchLive() {
        return liveDataList;
    }

    public void onLevelDown(Research research) {
        mRepos.levelDown(research);
    }
}
