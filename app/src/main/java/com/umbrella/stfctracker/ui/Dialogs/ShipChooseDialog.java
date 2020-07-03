package com.umbrella.stfctracker.ui.Dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.umbrella.stfctracker.databinding.DialogShipsChoicesBinding;

public class ShipChooseDialog extends DialogFragment {
    private DialogShipsChoicesBinding binding;

    public ShipChooseDialog() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogShipsChoicesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
