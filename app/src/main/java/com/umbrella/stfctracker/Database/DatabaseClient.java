package com.umbrella.stfctracker.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.umbrella.stfctracker.Database.Dao.*;
import com.umbrella.stfctracker.Database.Data.*;
import com.umbrella.stfctracker.Database.Entities.*;
import com.umbrella.stfctracker.Database.TypeConverters.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {
        Building.class,
        Research.class,
        Ship.class,
        BuiltShip.class},
        version = 1)
@TypeConverters({
        GroupTypeConverter.class,
        BonusTypeConverter.class,
        ResourceMaterialTypeConverter.class,
        ResearchTreeConverter.class,
        LevelListConverter.class,
        RarityConverter.class,
        GradeConverter.class,
        TierConverter.class,
        ShipClassConverter.class,
        FactionConverter.class})
public abstract class DatabaseClient extends RoomDatabase {
    private static final String DB_NAME = "tracker_database";
    private static volatile DatabaseClient mInstance;

    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService dbWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public abstract DaoBuilding daoBuilding();
    public abstract DaoResearch daoResearch();
    public abstract DaoShip daoShip();
    public abstract DaoBuiltShip daoBuiltShip();

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
                                    dbWriteExecutor.execute(() -> {
                                        DaoShip daoShip = mInstance.daoShip();

                                        daoShip.insertAll(DataShips
                                                .getInstance(context.getResources())
                                                .getShips()
                                                .toArray(new Ship[0]));
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
