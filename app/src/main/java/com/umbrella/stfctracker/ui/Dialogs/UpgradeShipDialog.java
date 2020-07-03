package com.umbrella.stfctracker.ui.Dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.umbrella.stfctracker.databinding.DialogShipUpgradeBinding;

public class UpgradeShipDialog extends DialogFragment {
    private DialogShipUpgradeBinding binding;

    public UpgradeShipDialog() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogShipUpgradeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
