package com.umbrella.stfctracker.Database.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.umbrella.stfctracker.Database.Entities.Building;

import java.util.List;

@Dao
public interface DaoBuilding {

    @Query("SELECT * FROM building ORDER BY `group` ASC, name ASC")
    LiveData<List<Building>> getLiveAll();

    @Query("SELECT * FROM building WHERE id=:id")
    Building getBuilding(long id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(Building... buildings);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Building building);

    @Update
    void levelUp(Building building);

    @Update
    void levelDown(Building building);
}
