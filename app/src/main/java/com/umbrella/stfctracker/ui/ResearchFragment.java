package com.umbrella.stfctracker.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.umbrella.stfctracker.DataTypes.Enums.Tree;
import com.umbrella.stfctracker.databinding.FragResearchGroupBinding;

public class ResearchFragment extends Fragment implements View.OnClickListener {
    private FragResearchGroupBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragResearchGroupBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.researchGroupA.setOnClickListener(this);
        binding.researchGroupB.setOnClickListener(this);
        binding.researchGroupC.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Tree tree;

        if (v.equals(binding.researchGroupA)) {
            tree = Tree.COMBAT;
        } else if (v.equals(binding.researchGroupB)) {
            tree = Tree.STATION;
        } else {
            tree = Tree.GALAXY;
        }

        Navigation.findNavController(v).navigate(ResearchFragmentDirections.researchToTree(tree));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
