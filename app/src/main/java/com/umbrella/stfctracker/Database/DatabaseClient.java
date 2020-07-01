package com.umbrella.stfctracker.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.umbrella.stfctracker.Database.Dao.DaoBuilding;
import com.umbrella.stfctracker.Database.Dao.DaoResearch;
import com.umbrella.stfctracker.Database.Data.DataBuildings;
import com.umbrella.stfctracker.Database.Data.DataResearch;
import com.umbrella.stfctracker.Database.Entities.Building;
import com.umbrella.stfctracker.Database.Entities.Research;
import com.umbrella.stfctracker.Database.TypeConverters.BonusTypeConverter;
import com.umbrella.stfctracker.Database.TypeConverters.GroupTypeConverter;
import com.umbrella.stfctracker.Database.TypeConverters.LevelListConverter;
import com.umbrella.stfctracker.Database.TypeConverters.ResearchTreeConverter;
import com.umbrella.stfctracker.Database.TypeConverters.ResourceMaterialTypeConverter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Building.class, Research.class}, version = 1)
@TypeConverters({
        GroupTypeConverter.class,
        BonusTypeConverter.class,
        ResourceMaterialTypeConverter.class,
        ResearchTreeConverter.class,
        LevelListConverter.class})
public abstract class DatabaseClient extends RoomDatabase {
    private static final String DB_NAME = "tracker_database";
    private static volatile DatabaseClient mInstance;

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService dbWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public abstract DaoBuilding daoBuilding();
    public abstract DaoResearch daoResearch();

    public static DatabaseClient getInstance(final Context context) {
        if (mInstance == null) {
            synchronized (DatabaseClient.class) {
                if (mInstance == null) {
                    mInstance = Room.databaseBuilder(context.getApplicationContext(), DatabaseClient.class, DB_NAME)
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    dbWriteExecutor.execute(() -> {
                                        DaoBuilding daoBuilding = mInstance.daoBuilding();

                                       daoBuilding.insertAll(DataBuildings
                                               .getInstance()
                                               .getBuildings()
                                               .toArray(new Building[0]));
                                    });
                                    dbWriteExecutor.execute(() -> {
                                        DaoResearch daoResearch = mInstance.daoResearch();

                                        daoResearch.insertAll(DataResearch
                                                .getInstance(context.getResources())
                                                .getResearch()
                                                .toArray(new Research[0]));
                                    });
                                }
                            })
                            .build();
                }
            }
        }
        return mInstance;
    }

}
