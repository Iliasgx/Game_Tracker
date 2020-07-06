package com.umbrella.stfctracker.Adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.umbrella.stfctracker.CustomComponents.RewardItem;
import com.umbrella.stfctracker.DataTypes.Enums.Material;
import com.umbrella.stfctracker.DataTypes.ResourceMaterial;
import com.umbrella.stfctracker.Database.Entities.Tier;

import java.util.ArrayList;
import java.util.List;

public class ShipScrapRecyclerViewAdapter extends RecyclerView.Adapter<ShipScrapRecyclerViewAdapter.CustomViewHolder> {
    private List<ResourceMaterial> rewardList = new ArrayList<>();

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RewardItem rewardItem = new RewardItem(parent.getContext());
        rewardItem.setLayoutParams(new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        return new CustomViewHolder(rewardItem);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        ResourceMaterial reward = rewardList.get(position);

        holder.getRewardItem().fromDatabase(
                reward.getMaterial().toString(),
                reward.getValue(),
                reward.getMaterial(),
                reward.getRarity(),
                reward.getGrade()
        );
    }

    @Override
    public int getItemCount() {
        return rewardList.isEmpty() ? 0 : rewardList.size();
    }

    public void setRewards(List<ResourceMaterial> rewards) {
        this.rewardList = rewards;
        notifyDataSetChanged();
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder {
        private RewardItem rewardItem;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            rewardItem = ((RewardItem)itemView);
        }

        public RewardItem getRewardItem() {
            return rewardItem;
        }
    }
}
