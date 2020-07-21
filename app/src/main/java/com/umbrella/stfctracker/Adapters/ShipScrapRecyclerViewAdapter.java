package com.umbrella.stfctracker.Adapters;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.umbrella.stfctracker.DataTypes.ResourceMaterial;
import com.umbrella.stfctracker.R;
import com.umbrella.stfctracker.Structures.ValueIndicator;
import com.umbrella.stfctracker.databinding.CustomScrapRewardItemBinding;

import java.util.LinkedList;

public class ShipScrapRecyclerViewAdapter extends RecyclerView.Adapter<ShipScrapRecyclerViewAdapter.CustomViewHolder> {
    private CustomScrapRewardItemBinding binding;
    private Application application;

    private LinkedList<ResourceMaterial> rewards = new LinkedList<>();

    public ShipScrapRecyclerViewAdapter(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = CustomScrapRewardItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CustomViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        ResourceMaterial material = rewards.get(position);

        if (material != null) {
            holder.rewardImg.setImageDrawable(application.getDrawable(material.getMaterial().getImageId()));
            holder.nameDisplay.setText(material.getMaterial().toString());
            holder.value.setText(application.getString(R.string.rewardItem_amount, new ValueIndicator().setValueWithIndicator(material.getValue())));

            if (material.getRarity() != null) {
                holder.border.setCardBackgroundColor(application.getColor(material.getRarity().getColorBorder()));
                holder.layer.setCardBackgroundColor(application.getColor(material.getRarity().getColorInner()));
            }
            if (material.getGrade() != null) {
                holder.gradeRate.setNumStars(material.getGrade().ordinal());
                holder.gradeRate.setRating(material.getGrade().ordinal());
            } else {
                holder.gradeRate.setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return rewards.size();
    }

    public void setRewards(LinkedList<ResourceMaterial> rewards) {
        this.rewards = rewards;
        notifyDataSetChanged();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        private ImageView rewardImg;
        private RatingBar gradeRate;
        private TextView nameDisplay;
        private TextView value;
        private CardView border;
        private CardView layer;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            rewardImg = binding.scrapRewardItemItemImg;
            gradeRate = binding.scrapRewardItemGrade;
            nameDisplay = binding.scrapRewardItemRewardName;
            value = binding.scrapRewardItemAmount;
            border = binding.scrapRewardItemBorder;
            layer = binding.scrapRewardItemOuterLayer;
        }
    }
}
