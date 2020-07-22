package com.umbrella.stfctracker.Adapters;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.umbrella.stfctracker.DataTypes.Enums.Group;
import com.umbrella.stfctracker.Database.Entities.Building;
import com.umbrella.stfctracker.R;
import com.umbrella.stfctracker.Structures.Data;
import com.umbrella.stfctracker.databinding.ListBuildingItemBinding;

import java.util.ArrayList;
import java.util.List;

public class StarbaseRecyclerViewAdapter extends RecyclerView.Adapter<StarbaseRecyclerViewAdapter.CustomViewHolder> {
    private ListBuildingItemBinding binding;
    private Resources rss;

    private ItemDetailClickListener itemDetailClickListener;
    private ItemUpgradeClickListener itemUpgradeClickListener;
    private ToSubListClickListener toSubListClickListener;

    private List<Building> buildings = new ArrayList<>();

    private boolean isSubList = false;

    public StarbaseRecyclerViewAdapter(Resources resources, ItemDetailClickListener l1, ItemUpgradeClickListener l2, ToSubListClickListener l3) {
        rss = resources;
        itemDetailClickListener = l1;
        itemUpgradeClickListener = l2;
        toSubListClickListener = l3;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ListBuildingItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CustomViewHolder(binding.getRoot(), itemDetailClickListener, itemUpgradeClickListener, toSubListClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Building building = buildings.get(position);

        if (building.getLevels().size() != 0 || isSubList) {
            holder.name.setText(building.getName());
            holder.level.setText(rss.getString(R.string.currentLevel, building.getUnlockedLevel()));
            holder.level.setVisibility(View.VISIBLE);
            holder.innerList.setVisibility(View.INVISIBLE);
            holder.itemView.setClickable(true);

            boolean canGoNextLevel = building.getLevels().stream()
                    .filter(level -> level.getLevel() == (building.getUnlockedLevel() + 1))
                    .anyMatch(level -> level.getRequiredOperationsLevel() <= Data.getInstance().getOperationsLevel());

            holder.upgrade.setVisibility(canGoNextLevel ? View.VISIBLE : View.INVISIBLE);
        } else {
            holder.name.setText(building.getGroup().toString());
            holder.level.setVisibility(View.GONE);
            holder.upgrade.setVisibility(View.INVISIBLE);
            holder.innerList.setVisibility(View.VISIBLE);
            holder.itemView.setClickable(false);
        }
    }

    @Override
    public int getItemCount() {
        return buildings.isEmpty() ? 0 : buildings.size();
    }

    public void setBuildings(List<Building> buildings, boolean isSubList) {
        this.isSubList = isSubList;
        this.buildings = buildings;
        notifyDataSetChanged();
    }

    public boolean isSubList() {
        return isSubList;
    }

    /**
     * Opens the level screen with details of each level.
     */
    public interface ItemDetailClickListener {
        void onClick(Building building);
    }

    /**
     * Opens the building dialog to be able to upgrade.
     */
    public interface ItemUpgradeClickListener {
        void onClick(Building building);
    }

    /**
     * Creates a sublist of the selected group.
     */
    public interface ToSubListClickListener {
        void onClick(Group group);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ItemDetailClickListener itemDetailClickListener;
        private ItemUpgradeClickListener itemUpgradeClickListener;
        private ToSubListClickListener toSubListClickListener;

        private TextView name;
        private TextView level;
        private CardView upgrade;
        private ImageView innerList;

        private CustomViewHolder(@NonNull View itemView, ItemDetailClickListener l1, ItemUpgradeClickListener l2, ToSubListClickListener l3) {
            super(itemView);
            name = binding.listBuildingItemName;
            level = binding.listBuildingItemLevel;
            upgrade = binding.listBuildingItemUpgradeCardview;
            innerList = binding.listBuildingItemArrow;

            this.itemDetailClickListener = l1;
            this.itemUpgradeClickListener = l2;
            this.toSubListClickListener = l3;

            upgrade.setOnClickListener(this);
            innerList.setOnClickListener(this);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Building building = buildings.get(getAdapterPosition());

            if (v.equals(upgrade)) {
                itemUpgradeClickListener.onClick(building);
            } else if (v.equals(innerList)) {
                toSubListClickListener.onClick(building.getGroup());
            } else {
                itemDetailClickListener.onClick(building);
            }
        }
    }
}
