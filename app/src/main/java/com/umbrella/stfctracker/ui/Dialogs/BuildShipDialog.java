package com.umbrella.stfctracker.ui.Dialogs;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.umbrella.stfctracker.CustomComponents.CustomResourceMaterialView;
import com.umbrella.stfctracker.CustomComponents.InformationLabel;
import com.umbrella.stfctracker.CustomComponents.ResourceAmount;
import com.umbrella.stfctracker.CustomComponents.ResourceMaterialAmount;
import com.umbrella.stfctracker.DataTypes.ResourceMaterial;
import com.umbrella.stfctracker.Database.DatabaseClient;
import com.umbrella.stfctracker.Database.Entities.BuiltShip;
import com.umbrella.stfctracker.Database.Entities.Ship;
import com.umbrella.stfctracker.Database.Entities.Tier;
import com.umbrella.stfctracker.R;
import com.umbrella.stfctracker.Structures.CumulativeBonus;
import com.umbrella.stfctracker.databinding.DialogShipBuildBinding;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

public class BuildShipDialog extends DialogFragment {
    private DialogShipBuildBinding binding;

    private CumulativeBonus cumulativeBonus = CumulativeBonus.getInstance();

    private Ship ship;

    public BuildShipDialog() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogShipBuildBinding.inflate(inflater, container, false);
        Objects.requireNonNull(requireDialog().getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ship = BuildShipDialogArgs.fromBundle(requireArguments()).getShip();

        binding.dialogShipUpgradeShipName.setText(ship.getName());

        setUpData();
        setUpMainListener();
    }

    private void setUpData() {
        Tier firstTier = ship.getTiers().getFirst();

        binding.dialogShipUpgradeTierUp.setTime(firstTier.getBuildTime());
        binding.dialogShipUpgradeTierUp.setTime(cumulativeBonus.applyBonus(firstTier.getBuildTime(), cumulativeBonus.getShipConstructionSpeedBonus()));

        binding.dialogShipUpgradeBuildCosts.setResources(CustomResourceMaterialView.computeResources(firstTier.getComponents().getFirst().getResources()));
        binding.dialogShipUpgradeBuildCosts.setMaterials(firstTier.getComponents().getFirst().getMaterials());
    }

    private void setUpMainListener() {
        binding.dialogShipUpgradeTierUp.setOnClickListener(listener -> {
            BuiltShip builtShip = new BuiltShip(ship);

            Toast.makeText(requireParentFragment().requireContext(), getString(R.string.builtShip_create_confirmation, ship.getName()), Toast.LENGTH_SHORT).show();

            DatabaseClient.dbWriteExecutor.execute(() -> {
                DatabaseClient.getInstance(requireContext()).daoBuiltShip().insert(builtShip);
                dismiss();
            });
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
