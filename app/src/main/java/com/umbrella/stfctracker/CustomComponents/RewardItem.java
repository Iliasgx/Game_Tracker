package com.umbrella.stfctracker.CustomComponents;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.umbrella.stfctracker.DataTypes.ValueIndicator;
import com.umbrella.stfctracker.R;
import com.umbrella.stfctracker.databinding.CustomScrapRewardItemBinding;

public class RewardItem extends RelativeLayout {
    private CustomScrapRewardItemBinding binding;

    private ImageView rewardImg;
    private ImageView star1;
    private ImageView star2;
    private ImageView star3;
    private ImageView star4;
    private TextView nameDisplay;
    private TextView value;
    private CardView border;
    private CardView layer;

    private String name;
    private int amount;
    private Reward reward;
    private Rarity rarity = Rarity.NONE;
    private Stars stars = Stars.NONE;

    private Context app;

    public RewardItem(Context context) {
        super(context);
        app = context.getApplicationContext();
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.custom_scrap_reward_item, this);

        rewardImg = requireViewById(R.id.scrapRewardItem_itemImg);
        star1 = requireViewById(R.id.scrapRewardItem__star1);
        star2 = requireViewById(R.id.scrapRewardItem__star2);
        star3 = requireViewById(R.id.scrapRewardItem__star3);
        star4 = requireViewById(R.id.scrapRewardItem__star4);
        nameDisplay = requireViewById(R.id.scrapRewardItem_rewardName);
        value = requireViewById(R.id.scrapRewardItem_amount);
        border = requireViewById(R.id.scrapRewardItem_border);
        layer = requireViewById(R.id.scrapRewardItem_outerLayer);
    }

    public String getName() {
        return name;
    }
    public int getAmount() {
        return amount;
    }
    public Reward getReward() {
        return reward;
    }
    public Rarity getRarity() {
        return rarity;
    }
    public Stars getStars() {
        return stars;
    }

    public void setName(String name) {
        this.name = name;
        nameDisplay.setText(name);
    }

    public void setAmount(int amount) {
        this.amount = amount;
        value.setText(app.getString(R.string.rewardItem_amount, new ValueIndicator().setValueWithIndicator((long)amount)));
    }

    public void setReward(Reward reward) {
        this.reward = reward;
        // TODO: set drawables
        Drawable dr = null;
        switch (reward) {
            case PARSTEEL: dr = app.getDrawable(R.drawable.parsteel);
                break;
            case TRITANIUM: dr = app.getDrawable(R.drawable.tritanium);
                break;
            case DILITHIUM: dr = app.getDrawable(R.drawable.dilithium);
                break;
            case GAS: dr = app.getDrawable(R.drawable.gas);
                break;
            case ORE: dr = app.getDrawable(R.drawable.ore);
                break;
            case CRYSTAL: dr = app.getDrawable(R.drawable.crystal);
                break;
            case XP:
                break;
            case SURVEY_PARTS:
                break;
            case INTERCEPTOR_PARTS:
                break;
            case BATTLESHIP_PARTS:
                break;
            case EXPLORER_PARTS:
                break;
        }

        rewardImg.setImageDrawable(dr);
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;

        int borderColor = 0;
        int innerColor = 0;

        switch (rarity) {
            case NONE:
            case COMMON:
                borderColor = app.getColor(R.color.shipScrapRewardItem_greyBorder);
                innerColor = app.getColor(R.color.shipScrapRewardItem_greyInner);
                break;
            case UNCOMMON:
                borderColor = app.getColor(R.color.shipScrapRewardItem_greenBorder);
                innerColor = app.getColor(R.color.shipScrapRewardItem_greenInner);
                break;
            case RARE:
                borderColor = app.getColor(R.color.shipScrapRewardItem_blueBorder);
                innerColor = app.getColor(R.color.shipScrapRewardItem_blueInner);
                break;
        }

        border.setCardBackgroundColor(borderColor);
        layer.setCardBackgroundColor(innerColor);
    }

    public void setStars(Stars stars) {
        this.stars = stars;

        int nr = stars.ordinal();
        star1.setVisibility(nr >= Stars.ONE.ordinal() ? VISIBLE : INVISIBLE);
        star2.setVisibility(nr >= Stars.TWO.ordinal() ? VISIBLE : INVISIBLE);
        star3.setVisibility(nr >= Stars.THREE.ordinal() ? VISIBLE : INVISIBLE);
        star4.setVisibility(nr >= Stars.FOUR.ordinal() ? VISIBLE : INVISIBLE);
    }

    private enum Reward {
        PARSTEEL,
        TRITANIUM,
        DILITHIUM,
        GAS,
        ORE,
        CRYSTAL,
        XP,
        SURVEY_PARTS,
        INTERCEPTOR_PARTS,
        BATTLESHIP_PARTS,
        EXPLORER_PARTS
    }

    private enum Rarity {
        NONE,
        COMMON,
        UNCOMMON,
        RARE
    }

    private enum Stars {
        NONE,
        ONE,
        TWO,
        THREE,
        FOUR
    }

}
