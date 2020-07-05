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

import com.umbrella.stfctracker.DataTypes.Enums.ShipClass;
import com.umbrella.stfctracker.Database.Data.DataFunctions;
import com.umbrella.stfctracker.Database.Entities.Ship;
import com.umbrella.stfctracker.R;
import com.umbrella.stfctracker.Structures.TimeDisplay;
import com.umbrella.stfctracker.Structures.ValueIndicator;
import com.umbrella.stfctracker.databinding.ListShipItemBinding;

import java.util.ArrayList;
import java.util.List;

public class ShipRecyclerViewAdapter extends RecyclerView.Adapter<ShipRecyclerViewAdapter.CustomViewHolder> {
    private ListShipItemBinding binding;
    private Application application;

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
        holder.shipClassImage.setImageDrawable(shipClassDrawable(ship.getShipClass()));
        holder.strength.setText(new ValueIndicator().setStringFormat(ship.getBaseStrength(), '.'));
        holder.itemView.setLongClickable(true);
        holder.buildFrame.setVisibility(View.VISIBLE);
        holder.buildTime.setText(new TimeDisplay(application.getApplicationContext())
                .getTime(ship.getTiers().get(0).getBuildTime()));
    }

    @Override
    public int getItemCount() {
        return ships.isEmpty() ? 0 : ships.size();
    }

    public void setBuiltShips(List<Ship> ships) {
        this.ships = ships;
        notifyDataSetChanged();
    }

    // TODO: Create shipClass images (4)
    private Drawable shipClassDrawable(ShipClass shipClass) {
        switch (shipClass) {
            case BATTLESHIP:    return application.getResources().getDrawable(0, null);
            case EXPLORER:      return application.getResources().getDrawable(0, null);
            case INTERCEPTOR:   return application.getResources().getDrawable(0, null);
            case SURVEY:        return application.getResources().getDrawable(0, null);
        }
        return null;
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
        private TextView strength;
        private CardView buildFrame;
        private TextView buildTime;

        public CustomViewHolder(@NonNull View itemView, ItemBuildListener itemBuildListener) {
            super(itemView);
            name = binding.listShipItemName;
            shipImage = binding.listShipItemShipImg;
            tier = binding.listShipItemTier;
            rarity = binding.listShipItemRarity;
            grade = binding.listShipItemStars;
            shipClassImage = binding.listShipItemShipTypeImg;
            strength = binding.listShipItemStrengthValue;
            buildFrame = binding.listShipItemBuildFrame;
            buildTime = binding.listShipItemBuildTime;

            buildFrame.setOnClickListener(v -> itemBuildListener.onBuildClick(ships.get(getAdapterPosition())));
        }
    }
}
