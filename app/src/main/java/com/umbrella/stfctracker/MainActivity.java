package com.umbrella.stfctracker;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.umbrella.stfctracker.DataTypes.Enums.BonusType;
import com.umbrella.stfctracker.DataTypes.ResourceMaterial;
import com.umbrella.stfctracker.Database.Dao.DaoResearch;
import com.umbrella.stfctracker.Database.DatabaseClient;
import com.umbrella.stfctracker.Database.Entities.Building;
import com.umbrella.stfctracker.Database.Entities.Level;
import com.umbrella.stfctracker.Database.Entities.Research;
import com.umbrella.stfctracker.Structures.CumulativeBonus;
import com.umbrella.stfctracker.Structures.Data;
import com.umbrella.stfctracker.databinding.ActivityMainBinding;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration
                .Builder(R.id.homeFragment, R.id.overviewFragment, R.id.unknownFragment)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        binding.navView.setOnNavigationItemSelectedListener(item -> {
            binding.navView.getMenu().setGroupEnabled(R.id.itemsGroup, true);

            switch (item.getItemId()) {
                case R.id.nav_unknown:
                    item.setEnabled(false);

                    Toast.makeText(this, "Coming soon", Toast.LENGTH_SHORT).show();
                    //navController.navigate(R.id.globalUnknown);
                    break;
                case R.id.nav_starbase:
                    navController.navigate(R.id.globalHome);
                    break;
                case R.id.nav_overview:
                    item.setEnabled(false);
                    navController.navigate(R.id.globalOverview);
                    break;
            }
            return true;
        });

        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(getResources().getDrawable(R.drawable.menu_color_gradient, getTheme()));

        binding.navView.setSelectedItemId(R.id.nav_starbase);

        setUpPrefs();

        //Used for debugging. Do not uncomment this to use otherwise!
        //deleteAllDataAndReferences();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Navigation.findNavController(this, R.id.host_fragment).navigateUp();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setHeader(String header) {
        try {
            Objects.requireNonNull(getSupportActionBar()).setTitle(header);
        } catch (NullPointerException ignored){}
    }

    private void setUpPrefs() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        Map<String, Integer> map = new HashMap<>();

        Data.getInstance().init(preferences.getInt("Operations", 1));

        preferences.getAll().forEach((key, val) -> {
            try {
                BonusType.valueOf(key);
            } catch (IllegalArgumentException e){
                return;
            }
            map.put(key, (Integer)val);
        });

        CumulativeBonus.getInstance().init(map);
    }

    private void safePreferences() {
        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        CumulativeBonus.getInstance().deInit().forEach(editor::putInt);
        editor.putInt("Operations", Data.getInstance().deInit());
        editor.apply();
    }

    @Override
    protected void onPause() {
        super.onPause();
        safePreferences();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    //Used ONLY for debugging, removes all data.
    protected void deleteAllDataAndReferences() {
        Executors.newFixedThreadPool(3).execute(() -> DatabaseClient.getInstance(this).clearAllTables());
        getApplicationContext().deleteDatabase("tracker_database");
        getPreferences(MODE_PRIVATE).edit().clear().apply();
    }
}
