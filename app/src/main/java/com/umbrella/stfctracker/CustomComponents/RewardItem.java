package com.umbrella.stfctracker.CustomComponents;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.umbrella.stfctracker.DataTypes.Enums.Grade;
import com.umbrella.stfctracker.DataTypes.Enums.Material;
import com.umbrella.stfctracker.DataTypes.Enums.Rarity;
import com.umbrella.stfctracker.DataTypes.ResourceMaterial;
import com.umbrella.stfctracker.Structures.ValueIndicator;
import com.umbrella.stfctracker.R;

public class RewardItem extends RelativeLayout {
    private ImageView rewardImg;
    private RatingBar gradeRate;
    private TextView nameDisplay;
    private TextView value;
    private CardView border;
    private CardView layer;

    private String name;
    private long amount;
    private Material reward;
    private Rarity rarity = Rarity.NONE;
    private Grade grade = Grade.NONE;

    public RewardItem(Context context) {
        super(context);
        init(context);
    }

    public void fromDatabase(String name, long amount, Material rewardMaterial, Rarity rarity, Grade grade) {
        this.name = name;
        this.amount = amount;
        this.reward = rewardMaterial;
        this.rarity = rarity;
        this.grade = grade;
    }

    private void init(Context context) {
        inflate(context, R.layout.custom_scrap_reward_item, this);

        rewardImg = requireViewById(R.id.scrapRewardItem_itemImg);
        gradeRate = requireViewById(R.id.scrapRewardItem_grade);
        nameDisplay = requireViewById(R.id.scrapRewardItem_rewardName);
        value = requireViewById(R.id.scrapRewardItem_amount);
        border = requireViewById(R.id.scrapRewardItem_border);
        layer = requireViewById(R.id.scrapRewardItem_outerLayer);
    }

    public String getName() {
        return name;
    }
    public long getAmount() {
        return amount;
    }
    public Material getReward() {
        return reward;
    }
    public Rarity getRarity() {
        return rarity;
    }
    public Grade getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
        nameDisplay.setText(name);
    }

    public void setAmount(long amount) {
        this.amount = amount;
        value.setText(getResources().getString(R.string.rewardItem_amount, new ValueIndicator().setValueWithIndicator(amount)));
    }

    public void setReward(Material reward) {
        this.reward = reward;
        rewardImg.setImageDrawable(getResources().getDrawable(reward.getImageId(), null));
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;

        int borderColor = 0;
        int innerColor = 0;

        switch (rarity) {
            case NONE:
            case COMMON:
                borderColor = getResources().getColor(R.color.shipScrapRewardItem_greyBorder, null);
                innerColor = getResources().getColor(R.color.shipScrapRewardItem_greyInner, null);
                break;
            case UNCOMMON:
                borderColor = getResources().getColor(R.color.shipScrapRewardItem_greenBorder, null);
                innerColor = getResources().getColor(R.color.shipScrapRewardItem_greenInner, null);
                break;
            case RARE:
                borderColor = getResources().getColor(R.color.shipScrapRewardItem_blueBorder, null);
                innerColor = getResources().getColor(R.color.shipScrapRewardItem_blueInner, null);
                break;
        }

        border.setCardBackgroundColor(borderColor);
        layer.setCardBackgroundColor(innerColor);
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
        gradeRate.setNumStars(grade.ordinal());
        gradeRate.setRating(grade.ordinal());
    }
}
