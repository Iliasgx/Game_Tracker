package com.umbrella.stfctracker.Adapters;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.umbrella.stfctracker.Database.Data.FunctionsDB;
import com.umbrella.stfctracker.Database.Entities.BuiltShip;
import com.umbrella.stfctracker.R;
import com.umbrella.stfctracker.databinding.ListShipItemBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BuiltShipRecyclerViewAdapter extends RecyclerView.Adapter<BuiltShipRecyclerViewAdapter.CustomViewHolder> {
    private ListShipItemBinding binding;
    private Application application;

    private ItemPressedListener itemPressedListener;
    private ItemScrapListener itemScrapListener;

    private List<BuiltShip> builtShips = new ArrayList<>();

    public BuiltShipRecyclerViewAdapter(Application app, ItemPressedListener itemPressedListener, ItemScrapListener itemScrapListener) {
        this.application = app;
        this.itemPressedListener = itemPressedListener;
        this.itemScrapListener = itemScrapListener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ListShipItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CustomViewHolder(binding.getRoot(), itemPressedListener, itemScrapListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        BuiltShip builtShip = builtShips.get(position);

        holder.name.setText(builtShip.getName());
        holder.shipImage.setImageDrawable(FunctionsDB.decodeDrawable(application.getResources(), builtShip.getImage()));
        holder.tier.setText(application.getResources().getString(R.string.tierNumber, builtShip.getCurrentTierId()));
        holder.rarity.setText(builtShip.getRarity().toString());
        holder.grade.setNumStars(builtShip.getGrade().ordinal());
        holder.grade.setRating(builtShip.getGrade().ordinal());
        holder.shipClassImage.setImageDrawable(application.getDrawable(builtShip.getShipClass().getImageId()));
        holder.faction.setText(builtShip.getFaction().toString());
        holder.itemView.setLongClickable(true);

        //Added for the transitions between fragments. Names must be unique.
        ViewCompat.setTransitionName(holder.shipImage, builtShip.getName() + "@" + position);
        ViewCompat.setTransitionName(holder.shipClassImage, builtShip.getShipClass() + "@" + position);
        ViewCompat.setTransitionName(holder.faction, builtShip.getFaction() + "@" + position);

        HashMap<String, View> transitionObjects = new HashMap<>();
        transitionObjects.put("img", holder.shipImage);
        transitionObjects.put("class", holder.shipClassImage);
        transitionObjects.put("faction", holder.faction);

        holder.itemView.setOnClickListener(v -> itemPressedListener.onClick(builtShip, transitionObjects));
        holder.itemView.setOnLongClickListener(v -> {
            itemScrapListener.onLongClick(builtShip);
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return builtShips.isEmpty() ? 0 : builtShips.size();
    }

    public void setBuiltShips(List<BuiltShip> builtShips) {
        this.builtShips = builtShips;
        notifyDataSetChanged();
    }

    /**
     * Used for two pressed actions.
     *
     * 1. Used to show the detail Fragment.
     * 2. Used to identify a ship that needs to tier down. Activation depends on main class.
     */
    public interface ItemPressedListener {
        void onClick(BuiltShip builtShip, HashMap<String, View> transitionsObj);
    }

    /**
     * Activates the Ship Scrap screen.
     */
    public interface ItemScrapListener {
        void onLongClick(BuiltShip builtShip);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private ImageView shipImage;
        private TextView tier;
        private TextView rarity;
        private RatingBar grade;
        private ImageView shipClassImage;
        private TextView faction;

        public CustomViewHolder(@NonNull View itemView, ItemPressedListener itemPressedListener, ItemScrapListener itemScrapListener) {
            super(itemView);

            name = binding.listShipItemName;
            shipImage = binding.listShipItemShipImg;
            tier = binding.listShipItemTier;
            rarity = binding.listShipItemRarity;
            grade = binding.listShipItemStars;
            shipClassImage = binding.listShipItemShipTypeImg;
            faction = binding.listShipItemFactionName;
        }
    }
}
