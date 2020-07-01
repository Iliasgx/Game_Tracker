package com.umbrella.stfctracker.Database.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.umbrella.stfctracker.DataTypes.Enums.Tree;
import com.umbrella.stfctracker.Database.Entities.Research;

import java.util.List;

@Dao
public interface DaoResearch {

    @Query("SELECT * FROM research ORDER BY tree ASC, name ASC")
    LiveData<List<Research>> getLiveAll();

    @Query("SELECT * FROM research WHERE tree=:tree ORDER BY position_y ASC, position_x ASC")
    LiveData<List<Research>> getResearchOfTree(Tree tree);

    @Query("SELECT * FROM research WHERE id=:id")
    Research getResearch(long id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(Research... researches);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Research research);

    @Update
    void levelUp(Research building);

    @Update
    void levelDown(Research building);
}
