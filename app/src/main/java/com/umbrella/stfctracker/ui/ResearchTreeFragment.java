package com.umbrella.stfctracker.ui;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.umbrella.stfctracker.CustomComponents.ResearchItem;
import com.umbrella.stfctracker.DataTypes.Enums.Tree;
import com.umbrella.stfctracker.Database.Data.FunctionsDB;
import com.umbrella.stfctracker.Database.Entities.Research;
import com.umbrella.stfctracker.Database.Models.ResearchViewModel;
import com.umbrella.stfctracker.MainActivity;
import com.umbrella.stfctracker.R;
import com.umbrella.stfctracker.Structures.Data;
import com.umbrella.stfctracker.databinding.FragResearchTreeBinding;
import com.umbrella.stfctracker.databinding.ListResearchItemBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ResearchTreeFragment extends Fragment {
    private FragResearchTreeBinding binding;

    private ResearchViewModel mResearchViewModel;
    private Tree tree;

    private TreeAdapter adapter = new TreeAdapter();

    private long mLastClickedTime = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragResearchTreeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tree = ResearchTreeFragmentArgs.fromBundle(requireArguments()).getTree();

        mResearchViewModel = new ViewModelProvider(this).get(ResearchViewModel.class);
        mResearchViewModel.initData(tree);

        final LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(requireContext(), R.anim.layout_research_pop_up);
        binding.fragResearchTreeGrid.setLayoutAnimation(controller);
        binding.fragResearchTreeGrid.setAdapter(adapter);
        binding.fragResearchTreeGrid.setHasFixedSize(true);

        mResearchViewModel.getAllResearchLive().observe(getViewLifecycleOwner(), research -> {
            adapter.setResearch(collectData(research));
            binding.fragResearchTreeGrid.scheduleLayoutAnimation();
        });

        binding.fragResearchTreeGrid.setBackground(getResources().getDrawable(tree.getBackgroundId(), requireActivity().getTheme()));
    }

    private List<Research> collectData(List<Research> baseList) {
        List<Research> newList = new LinkedList<>();

        AtomicInteger atomX = new AtomicInteger(0);
        AtomicInteger atomY = new AtomicInteger(1);

        baseList.forEach(research -> {
            //Check if zero added
            //Add to newList
            boolean addNormal = true;

            //Still working in the same row or thrown at the next one.
            if (research.getPositionY() != atomY.get()) {
                if (atomX.get() == 1) {
                    newList.addAll(Arrays.asList(new Research(), new Research()));
                } else if (atomX.get() == 2) {
                    newList.add(new Research());
                }

                //Set to 0 for the start of the new row.
                atomX.set(0);
                atomY.incrementAndGet();
            }

            if (research.getPositionX() == atomX.get() + 2) {
                newList.add(new Research());
                addNormal = atomX.get() < 2;
            } else if (atomX.get() == 0 && research.getPositionX() == atomX.get() + 3) {
                newList.addAll(Arrays.asList(new Research(), new Research()));
            }

            if (addNormal) newList.add(research);

            atomX.set(research.getPositionX());
            atomY.set(research.getPositionY());
        });

        return newList;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity)requireActivity()).setHeader(tree.toString());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private class TreeAdapter extends RecyclerView.Adapter<TreeAdapter.CustomHolder> {
        private ListResearchItemBinding itemBinding;

        private List<Research> lstResearch = new ArrayList<>();

        private int opsLevel;

        private RelativeLayout.LayoutParams params;

        public void setResearch(List<Research> researchList) {
            opsLevel = Data.getInstance().getOperationsLevel();
            this.lstResearch = researchList;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            itemBinding = ListResearchItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            setParams();
            return new CustomHolder(itemBinding.getRoot());
        }

        @Override
        public void onBindViewHolder(@NonNull CustomHolder holder, int position) {
            Research research = lstResearch.get(position);

            boolean isEmpty = research.getName().equals(Research.EMPTY_NAME);

            holder.item.setVisibility(!isEmpty ? View.VISIBLE : View.INVISIBLE);
            holder.item.setClickable(!isEmpty);
            holder.item.setLongClickable(!isEmpty);

            if (!isEmpty) {
                holder.item.fromDatabase(
                        research.getName(),
                        FunctionsDB.decodeDrawable(getResources(), research.getImage()),
                        research.getUnlockedLevel(),
                        research.getLevels().size(),
                        research.getLevels().stream()
                                .filter(level -> level.getLevel() > research.getUnlockedLevel())
                                .anyMatch(level -> level.getRequiredOperationsLevel() <= opsLevel),
                        research.getLevels().getFirst().getRequiredOperationsLevel() > opsLevel
                );

                holder.item.setLongClickable(holder.item.isCanUpgrade());

                holder.item.setOnClickListener(listener -> {
                    if (SystemClock.elapsedRealtime() - mLastClickedTime < 1000) return;

                    mLastClickedTime = SystemClock.elapsedRealtime();
                    Navigation.findNavController(requireView()).navigate(ResearchTreeFragmentDirections.researchTreeToResearchDialog(research));
                });

                holder.item.setOnLongClickListener(listener -> {
                    if (research.getUnlockedLevel() == 0) {
                        Toast.makeText(requireContext(), getString(R.string.lowest_level_warning, research.getName()), Toast.LENGTH_SHORT).show();
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
                        builder.setTitle(getResources().getString(R.string.research_lowerLevel_confirmation_title));
                        builder.setMessage(getResources().getString(R.string.research_lowerLevel_confirmation_description, research.getName()));

                        builder.setPositiveButton("YES", ((dialog, which) -> {
                            if (research.getUnlockedLevel() != 0) holder.item.setLevel(holder.item.getLevel() - 1);
                            mResearchViewModel.onLevelDown(research);
                            Toast.makeText(requireContext(), getString(R.string.lower_down_confirmation, research.getName()), Toast.LENGTH_SHORT).show();
                        }));
                        builder.setNegativeButton("NO", ((dialog, which) -> dialog.cancel()));

                        builder.create().show();
                    }
                    return true;
                });
            }
        }

        @Override
        public int getItemCount() {
            return lstResearch.isEmpty() ? 0 : lstResearch.size();
        }

        private void setParams() {
            params = new RelativeLayout.LayoutParams((RelativeLayout.LayoutParams)itemBinding.listResearchItemResearchItem.getLayoutParams());
            params.setMarginStart((int)getResources().getDimension(R.dimen.research_item_horMargin));
            params.setMarginEnd((int)getResources().getDimension(R.dimen.research_item_horMargin));
        }

        private class CustomHolder extends RecyclerView.ViewHolder {
            private ResearchItem item;

            public CustomHolder(@NonNull View itemView) {
                super(itemView);
                item = itemBinding.listResearchItemResearchItem;
                item.setLayoutParams(params);
            }
        }
    }
}