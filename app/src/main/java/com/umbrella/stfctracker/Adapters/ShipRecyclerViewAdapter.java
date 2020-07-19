package com.umbrella.stfctracker.Adapters;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.umbrella.stfctracker.CustomComponents.CustomButton;
import com.umbrella.stfctracker.DataTypes.Enums.ShipClass;
import com.umbrella.stfctracker.Database.Data.DataFunctions;
import com.umbrella.stfctracker.Database.Entities.Ship;
import com.umbrella.stfctracker.R;
import com.umbrella.stfctracker.Structures.CumulativeBonus;
import com.umbrella.stfctracker.Structures.TimeDisplay;
import com.umbrella.stfctracker.Structures.ValueIndicator;
import com.umbrella.stfctracker.databinding.ListShipItemBinding;

import java.util.ArrayList;
import java.util.List;

public class ShipRecyclerViewAdapter extends RecyclerView.Adapter<ShipRecyclerViewAdapter.CustomViewHolder> {
    private ListShipItemBinding binding;
    private Application application;

    private CumulativeBonus cumulativeBonus = CumulativeBonus.getInstance();

    private ItemBuildListener itemBuildListener;

    private List<Ship> ships = new ArrayList<>();

    //Used for selecting a new ship to build.
    public ShipRecyclerViewAdapter(Application app, ItemBuildListener itemBuildListener) {
        this.application = app;
        this.itemBuildListener = itemBuildListener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ListShipItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CustomViewHolder(binding.getRoot(), itemBuildListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Ship ship = ships.get(position);

        holder.name.setText(ship.getName());
        holder.shipImage.setImageDrawable(DataFunctions.decodeDrawable(application.getResources(), ship.getImage()));
        holder.tier.setText(application.getResources().getString(R.string.tierNumber, 1));
        holder.rarity.setText(ship.getRarity().toString());
        holder.grade.setNumStars(ship.getGrade().ordinal());
        holder.grade.setRating(ship.getGrade().ordinal());
        holder.shipClassImage.setImageDrawable(application.getDrawable(ship.getShipClass().getImageId()));
        holder.faction.setText(ship.getFaction().toString());
        holder.itemView.setLongClickable(true);
        holder.buildFrame.setVisibility(View.VISIBLE);
        holder.buildTime.setTime(ship.getTiers().get(0).getBuildTime());
        holder.buildTime.setTime(cumulativeBonus.applyBonus(ship.getTiers().get(0).getBuildTime(), cumulativeBonus.getShipConstructionSpeedBonus()));
    }

    @Override
    public int getItemCount() {
        return ships.isEmpty() ? 0 : ships.size();
    }

    public void setBuiltShips(List<Ship> ships) {
        this.ships = ships;
        notifyDataSetChanged();
    }

    /**
     * Used only for selecting a new ship to build.
     */
    public interface ItemBuildListener {
        void onBuildClick(Ship ship);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private ImageView shipImage;
        private TextView tier;
        private TextView rarity;
        private RatingBar grade;
        private ImageView shipClassImage;
        private TextView faction;
        private CardView buildFrame;
        private CustomButton buildTime;

        public CustomViewHolder(@NonNull View itemView, ItemBuildListener itemBuildListener) {
            super(itemView);
            name = binding.listShipItemName;
            shipImage = binding.listShipItemShipImg;
            tier = binding.listShipItemTier;
            rarity = binding.listShipItemRarity;
            grade = binding.listShipItemStars;
            shipClassImage = binding.listShipItemShipTypeImg;
            faction = binding.listShipItemFactionName;
            buildFrame = binding.listShipItemBuildFrame;
            buildTime = binding.listShipItemBuildButton;

            buildFrame.setOnClickListener(v -> itemBuildListener.onBuildClick(ships.get(getAdapterPosition())));
        }
    }
}
