package com.umbrella.stfctracker.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.umbrella.stfctracker.Database.Entities.Building;
import com.umbrella.stfctracker.Database.Entities.Level;
import com.umbrella.stfctracker.MainActivity;
import com.umbrella.stfctracker.R;
import com.umbrella.stfctracker.databinding.FragLevelOverviewBinding;
import com.umbrella.stfctracker.databinding.GridLevelBinding;

import java.util.LinkedList;

public class BuildingLevelFragment extends Fragment {

    private FragLevelOverviewBinding binding;
    private Building building;

    private long mLastClickedTime = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragLevelOverviewBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        building = BuildingLevelFragmentArgs.fromBundle(requireArguments()).getBuilding();

        binding.fragLevelOverviewGridView.setAdapter(new LevelAdapter(building.getLevels()));
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity)requireActivity()).setHeader(getResources().getString(R.string.title_buildingLevels, building.getName()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private class LevelAdapter extends BaseAdapter {
        private GridLevelBinding bindingLevel;

        private LinkedList<Level> levels;

        private LevelAdapter(LinkedList<Level> levels) {
            this.levels = levels;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            bindingLevel = GridLevelBinding.inflate(getLayoutInflater(), parent, false);

            bindingLevel.gridLevelCardViewInner.setOnClickListener(v -> {
                if (SystemClock.elapsedRealtime() - mLastClickedTime < 1000) return;

                mLastClickedTime = SystemClock.elapsedRealtime();
                Navigation.findNavController(bindingLevel.getRoot())
                        .navigate(BuildingLevelFragmentDirections.buildingLevelsToBuildingDialog(building, getItemLevel(position)));
            });

            bindingLevel.gridLevelLevel.setText(String.valueOf(getItemLevel(position)));

            return bindingLevel.getRoot();
        }

        @Override
        public Level getItem(int position) {
            return levels.get(position);
        }

        @Override
        public long getItemId(int position) {
            return levels.get(position).getLevel();
        }

        private int getItemLevel(int position) {
            return levels.get(position).getLevel();
        }

        @Override
        public int getCount() {
            return levels.size();
        }
    }
}
