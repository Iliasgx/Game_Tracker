package com.umbrella.stfctracker.ui.Dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.umbrella.stfctracker.Adapters.ShipRecyclerViewAdapter;
import com.umbrella.stfctracker.Adapters.ShipRecyclerViewAdapter.ItemBuildListener;
import com.umbrella.stfctracker.Adapters.ShipRecyclerViewAdapter.ItemInfoListener;
import com.umbrella.stfctracker.Database.Models.ShipViewModel;
import com.umbrella.stfctracker.R;
import com.umbrella.stfctracker.databinding.DialogShipsChoicesBinding;

public class ShipChooseDialog extends DialogFragment {
    private DialogShipsChoicesBinding binding;

    private ShipRecyclerViewAdapter mAdapter;

    public ShipChooseDialog() {
    }

    @Override
    public int getTheme() {
        return R.style.FullScreenDialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogShipsChoicesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ShipViewModel mViewModel = new ViewModelProvider(this).get(ShipViewModel.class);

        setUpRecyclerView();

        mViewModel.getAllShipsLive().observe(getViewLifecycleOwner(), ships -> mAdapter.setBuiltShips(ships));
    }

    private void setUpRecyclerView() {
        ItemInfoListener itemInfoListener = ship -> Navigation.findNavController(requireView()).navigate(ShipChooseDialogDirections.addShipToShipDetails().setShip(ship));

        ItemBuildListener itemBuildListener = ship -> Navigation.findNavController(requireView())
                .navigate(ShipChooseDialogDirections.addShipToBuild(ship));

        mAdapter = new ShipRecyclerViewAdapter(requireActivity().getApplication(), itemBuildListener, itemInfoListener);
        binding.fragShipsChoicesGrid.setAdapter(mAdapter);
        binding.fragShipsChoicesGrid.setHasFixedSize(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
