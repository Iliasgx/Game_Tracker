package com.umbrella.stfctracker.ui;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import android.view.animation.LayoutAnimationController;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.umbrella.stfctracker.Adapters.StarbaseRecyclerViewAdapter;
import com.umbrella.stfctracker.Adapters.StarbaseRecyclerViewAdapter.ItemDetailClickListener;
import com.umbrella.stfctracker.Adapters.StarbaseRecyclerViewAdapter.ItemUpgradeClickListener;
import com.umbrella.stfctracker.Adapters.StarbaseRecyclerViewAdapter.ToSubListClickListener;
import com.umbrella.stfctracker.Database.Entities.Building;
import com.umbrella.stfctracker.Database.Models.BuildingViewModel;
import com.umbrella.stfctracker.R;
import com.umbrella.stfctracker.databinding.FragStarbaseBinding;

import java.util.Objects;

public class StarbaseFragment extends Fragment {
    private FragStarbaseBinding binding;

    private static StarbaseRecyclerViewAdapter adapter;
    private static BuildingViewModel mBuildingViewModel;

    private long mLastClickedTime = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Overrides the backPressed() when user is in a sublist. Prevents from going to the mainFragment.
        requireActivity().getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (adapter != null && adapter.isSubList()) {
                    onReturnToMainList();
                } else {
                    this.setEnabled(false);
                    requireActivity().getOnBackPressedDispatcher().onBackPressed();
                }
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragStarbaseBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpRecyclerView();

        binding.fragStarbaseReturnButton.setOnClickListener(v -> onReturnToMainList());
    }

    private void setUpRecyclerView() {
        mBuildingViewModel = new ViewModelProvider(this).get(BuildingViewModel.class);
        changeToOtherList(false);

        ItemDetailClickListener l1 = building ->
                Navigation.findNavController(requireView()).navigate(StarbaseFragmentDirections.starbaseToBuildingLevels(building));

        ItemUpgradeClickListener  l2 = building -> {
            if (SystemClock.elapsedRealtime() - mLastClickedTime < 1000) return;

            mLastClickedTime = SystemClock.elapsedRealtime();

            Navigation.findNavController(requireView()).navigate(StarbaseFragmentDirections.starbaseToBuildingDialog(building));
        };

        ToSubListClickListener l3 = group -> {
            mBuildingViewModel.setCurrentGroup(group);
            changeToOtherList(true);
            binding.fragStarbaseReturnLayout.setVisibility(View.VISIBLE);
            binding.fragStarbaseSublistTitle.setText(group.toString());
        };

        adapter = new StarbaseRecyclerViewAdapter(getResources(), l1, l2, l3);
        binding.fragStarbaseRecyclerView.setAdapter(adapter);
        binding.fragStarbaseRecyclerView.setHasFixedSize(true);
        binding.fragStarbaseRecyclerView.setLayoutManager(new LinearLayoutManager(requireView().getContext()));

        mBuildingViewModel.addItemTouchHelperTo(binding.fragStarbaseRecyclerView, requireContext());
    }

    private void changeToOtherList(boolean isSubList) {
        mBuildingViewModel.getAllBuildingsLive().observe(getViewLifecycleOwner(), buildings -> {
            adapter.setBuildings(isSubList ? mBuildingViewModel.collectBuildingsByGroup(buildings) : mBuildingViewModel.collectAllBuildings(buildings), isSubList);
            binding.fragStarbaseRecyclerView.scheduleLayoutAnimation();
        });
    }

    private void onReturnToMainList() {
        binding.fragStarbaseReturnLayout.setVisibility(View.GONE);
        changeToOtherList(false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
