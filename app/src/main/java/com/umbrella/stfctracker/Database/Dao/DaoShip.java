package com.umbrella.stfctracker.Database.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.umbrella.stfctracker.Database.Entities.Ship;

import java.util.List;

@Dao
public interface DaoShip {

    @Query("SELECT * FROM ship ORDER BY required_operations_level ASC, name ASC")
    LiveData<List<Ship>> getLiveAll();

    @Query("SELECT * FROM ship WHERE id=:id")
    Ship getShip(long id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(Ship... ships);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Ship ship);

    @Update
    void update(Ship ship);
}
