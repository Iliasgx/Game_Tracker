package com.umbrella.stfctracker.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.umbrella.stfctracker.R;
import com.umbrella.stfctracker.databinding.FragHomeBinding;

public class HomeFragment extends Fragment {

    private FragHomeBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.fragHomeAName.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.homeToStarbase));
        binding.fragHomeBName.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.homeToResearch));
        //binding.fragHomeCName.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.homeToOfficers));
        binding.fragHomeCName.setOnClickListener(v -> Toast.makeText(requireContext(), "Coming soon", Toast.LENGTH_SHORT).show());
        //binding.fragHomeDName.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.homeToShips));
        binding.fragHomeDName.setOnClickListener(v -> Toast.makeText(requireContext(), "Coming soon", Toast.LENGTH_SHORT).show());

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
