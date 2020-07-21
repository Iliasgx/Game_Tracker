package com.umbrella.stfctracker.ui.Dialogs;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
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
import com.umbrella.stfctracker.Structures.CumulativeBonus;
import com.umbrella.stfctracker.Structures.Data;
import com.umbrella.stfctracker.databinding.DialogShipScrapBinding;

import java.util.Objects;

public class ScrapShipDialog extends DialogFragment {
    private DialogShipScrapBinding binding;

    public ScrapShipDialog() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogShipScrapBinding.inflate(inflater, container, false);
        Objects.requireNonNull(requireDialog().getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CumulativeBonus cumulativeBonus = CumulativeBonus.getInstance();

        ScrapShipDialogArgs args = ScrapShipDialogArgs.fromBundle(requireArguments());
        BuiltShip builtShip = args.getBuiltShip();
        Tier.Level level = args.getSelectedItem();

        binding.dialogShipScrapSubtitle.setText(getString(R.string.scrapShip_subtitle, level.getLevel(), builtShip.getName()));
        binding.dialogShipScrapScrap.setTime(cumulativeBonus.applyBonus(level.getScrapInfo().getScrapTime(), cumulativeBonus.getShipScrapSpeedBonus()));

        boolean usable = (builtShip.getScrapRequiredOperationsLevel() != -1 &&
                builtShip.getScrapRequiredOperationsLevel() <= Data.getInstance().getOperationsLevel() &&
                builtShip.getTiers().get(builtShip.getCurrentTierId()).getLevels().contains(level));

        binding.dialogShipScrapScrap.setUsable(usable);
        binding.dialogShipScrapScrap.setClickable(true);

        binding.dialogShipScrapCancel.setOnClickListener(v -> requireDialog().cancel());
        binding.dialogShipScrapScrap.setOnClickListener(v -> {
            if (Data.getInstance().getOperationsLevel() < builtShip.getScrapRequiredOperationsLevel()) {
                Toast.makeText(requireContext(), getString(R.string.shipScrap_notScrap_ops_warning, builtShip.getName()), Toast.LENGTH_SHORT).show();
            } else {
                new BuiltShipRepository(requireActivity().getApplication()).scrap(builtShip);
                Toast.makeText(requireContext(), getString(R.string.shipScrap_confirmation, builtShip.getName()), Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });

        ShipScrapRecyclerViewAdapter adapter = new ShipScrapRecyclerViewAdapter(requireActivity().getApplication());
        binding.dialogShipScrapRewardRecyclerView.setAdapter(adapter);
        binding.dialogShipScrapRewardRecyclerView.setHasFixedSize(true);
        adapter.setRewards(level.getScrapInfo().getRewards());

        if (level.getScrapInfo().getRewards().size() > 3) {
            binding.dialogShipScrapRewardRecyclerView.getLayoutParams().height = Float.valueOf(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, getResources().getDisplayMetrics())).intValue();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
