package com.umbrella.stfctracker.ui.Dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.umbrella.stfctracker.Adapters.ShipScrapRecyclerViewAdapter;
import com.umbrella.stfctracker.Database.Entities.BuiltShip;
import com.umbrella.stfctracker.Database.Entities.Tier;
import com.umbrella.stfctracker.Database.Models.BuiltShipRepository;
import com.umbrella.stfctracker.R;
import com.umbrella.stfctracker.Structures.Data;
import com.umbrella.stfctracker.databinding.DialogShipScrapBinding;

public class ScrapShipDialog extends DialogFragment {
    private DialogShipScrapBinding binding;

    public ScrapShipDialog() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogShipScrapBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ScrapShipDialogArgs args = ScrapShipDialogArgs.fromBundle(requireArguments());
        BuiltShip builtShip = args.getBuiltShip();
        Tier.Level level = args.getSelectedItem();


        binding.dialogShipScrapSubtitle.setText(getString(R.string.scrapShip_subtitle, level.getLevel(), builtShip.getName()));
        binding.dialogShipScrapScrap.setTime(level.getScrapInfo().getScrapTime());
        binding.dialogShipScrapScrap.setUsable(builtShip.getScrapRequiredOperationsLevel() <= Data.getInstance().getOperationsLevel());

        binding.dialogShipScrapCancel.setOnClickListener(v -> requireDialog().cancel());
        binding.dialogShipScrapScrap.setOnClickListener(v -> {
            new BuiltShipRepository(requireActivity().getApplication()).scrap(builtShip);
            Toast.makeText(requireContext(), getString(R.string.shipScrap_confirmation, builtShip.getName()), Toast.LENGTH_SHORT).show();
            dismiss();
        });

        ShipScrapRecyclerViewAdapter adapter = new ShipScrapRecyclerViewAdapter();
        binding.dialogShipScrapRewardRecyclerView.setAdapter(adapter);
        binding.dialogShipScrapRewardRecyclerView.setHasFixedSize(true);
        adapter.setRewards(level.getScrapInfo().getRewards());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
