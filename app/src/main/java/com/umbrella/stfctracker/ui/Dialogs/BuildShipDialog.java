package com.umbrella.stfctracker.ui.Dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.umbrella.stfctracker.CustomComponents.InformationLabel;
import com.umbrella.stfctracker.CustomComponents.ResourceAmount;
import com.umbrella.stfctracker.CustomComponents.ResourceMaterialAmount;
import com.umbrella.stfctracker.DataTypes.ResourceMaterial;
import com.umbrella.stfctracker.Database.DatabaseClient;
import com.umbrella.stfctracker.Database.Entities.BuiltShip;
import com.umbrella.stfctracker.Database.Entities.Ship;
import com.umbrella.stfctracker.Database.Entities.Tier;
import com.umbrella.stfctracker.R;
import com.umbrella.stfctracker.databinding.DialogShipBuildBinding;

import java.util.Arrays;
import java.util.LinkedList;

public class BuildShipDialog extends DialogFragment {
    private DialogShipBuildBinding binding;

    private Ship ship;

    public BuildShipDialog() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogShipBuildBinding.inflate(inflater, container, false);
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

        LinkedList<ResourceAmount> ra = new LinkedList<>(Arrays.asList(binding.dialogShipUpgradeAmountA, binding.dialogShipUpgradeAmountB));
        LinkedList<ResourceMaterialAmount> rma = new LinkedList<>(Arrays.asList(binding.dialogShipUpgradeMaterialA, binding.dialogShipUpgradeMaterialB, binding.dialogShipUpgradeMaterialC, binding.dialogShipUpgradeMaterialD));

        firstTier.getComponents().get(0).getResources().forEach(rss -> {
            ResourceAmount curr = ra.pop();

            curr.setMaterial(rss.getMaterial());
            curr.setValue(rss.getValue());
            curr.setNeeded(true);

            curr.setOnClickListener(view -> {
                InformationLabel label = new InformationLabel(requireContext());
                label.setValue(rss.getValue());
                label.setLocation(view, -15, -10);
                binding.dialogShipUpgradeCardView.addView(label);
            });
        });

        firstTier.getComponents().get(0).getMaterials().forEach(mat -> {
            ResourceMaterialAmount curr = rma.pop();

            curr.setMaterial(mat.getMaterial());
            curr.setGrade(mat.getGrade());
            curr.setRarity(mat.getRarity());
            curr.setValue((int)mat.getValue());
            curr.setNeeded(true);
        });

        ra.forEach(itemLeft -> itemLeft.setNeeded(false));
        rma.forEach(itemLeft -> itemLeft.setNeeded(false));
    }

    private void setUpMainListener() {
        binding.dialogShipUpgradeTierUp.setOnClickListener(listener -> {
            BuiltShip builtShip = (BuiltShip)ship;

            DatabaseClient.dbWriteExecutor.execute(() -> {
                DatabaseClient.getInstance(requireContext()).daoBuiltShip().insert(builtShip);
                Toast.makeText(requireContext(), getString(R.string.builtShip_create_confirmation, ship.getName()), Toast.LENGTH_SHORT).show();
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
