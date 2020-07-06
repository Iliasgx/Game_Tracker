package com.umbrella.stfctracker.Database.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.umbrella.stfctracker.Database.Entities.BuiltShip;

import java.util.List;

@Dao
public interface DaoBuiltShip {

    @Query("SELECT * FROM built_ship ORDER BY base_strength DESC, name ASC")
    LiveData<List<BuiltShip>> getLiveAll();

    @Query("SELECT * FROM built_ship WHERE id=:id")
    LiveData<BuiltShip> getBuiltShip(long id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(BuiltShip... builtShips);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(BuiltShip builtShip);

    @Delete
    void delete(BuiltShip builtShip);

    @Update
    void tierUp(BuiltShip builtShip);

    @Update
    void tierDown(BuiltShip builtShip);

    @Update
    void update(BuiltShip builtShip);
}
