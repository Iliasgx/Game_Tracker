package com.umbrella.stfctracker.CustomComponents;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.umbrella.stfctracker.R;

public class ResearchItem extends RelativeLayout {

    private ImageView imageView;
    private ImageView upgradeArrow;
    private TextView nameView;
    private TextView maxView;
    private CustomProgressbar levelProgressbar;
    private FrameLayout lockedFrame;

    private boolean canUpgrade = false;
    private boolean isLocked = false;
    private int level = 0;
    private int max = 1;
    private String name;
    private Drawable img;

    public ResearchItem(Context context) {
        super(context, null);
    }

    public ResearchItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public void fromDatabase(String name, Drawable img, int level, int max, boolean canUpgrade, boolean isLocked) {
        setName(name);
        setImg(img);
        setMax(max);
        setLevel(level);
        setCanUpgrade(canUpgrade);
        setLocked(isLocked);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(context, R.layout.research_item, this);

        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.ResearchItem);

        try {
            canUpgrade = arr.getBoolean(R.styleable.ResearchItem_canUpgrade, false);
            isLocked = arr.getBoolean(R.styleable.ResearchItem_isLocked, false);
            level = arr.getInt(R.styleable.ResearchItem_currentLevel, 0);
            max = arr.getInt(R.styleable.ResearchItem_maxLevel, 1);
            name = arr.getString(R.styleable.ResearchItem_name);
            img = arr.getDrawable(R.styleable.ResearchItem_image);
        } finally {
            arr.recycle();
        }

        initComponents();

        setCanUpgrade(canUpgrade);
        setLocked(isLocked);
        setMax(max);
        setLevel(level);
        setName(name);
        setImg(img);
    }

    private void initComponents() {
        imageView = requireViewById(R.id.researchItem_img);
        upgradeArrow = requireViewById(R.id.researchItem_arrowUp);
        nameView = requireViewById(R.id.researchItem_name);
        maxView = requireViewById(R.id.researchItem_maxed);
        levelProgressbar = requireViewById(R.id.researchItem_level);
        lockedFrame = requireViewById(R.id.researchItem_lockedFrame);
    }

    public boolean isCanUpgrade() {
        return canUpgrade;
    }
    public boolean isLocked() {
        return isLocked;
    }
    public int getLevel() {
        return level;
    }
    public int getMax() {
        return max;
    }
    public String getName() {
        return name;
    }
    public Drawable getImg() {
        return img;
    }

    public void setCanUpgrade(boolean canUpgrade) {
        this.canUpgrade = canUpgrade;
        upgradeArrow.setVisibility(canUpgrade ? VISIBLE : INVISIBLE);
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
        lockedFrame.setVisibility(locked ? VISIBLE : GONE);
    }

    public void setLevel(int level) {
        this.level = level;

        levelProgressbar.setValue(level, this.max);
        if (level == max) {
            levelProgressbar.setVisibility(INVISIBLE);
            maxView.setVisibility(VISIBLE);
        } else {
            levelProgressbar.setVisibility(VISIBLE);
            maxView.setVisibility(INVISIBLE);
        }
    }

    public void setMax(int max) {
        this.max = max;
        levelProgressbar.setValue(this.level, max);
        if (level == max) {
            levelProgressbar.setVisibility(INVISIBLE);
            maxView.setVisibility(VISIBLE);
        } else {
            levelProgressbar.setVisibility(VISIBLE);
            maxView.setVisibility(INVISIBLE);
        }
    }

    public void setName(String name) {
        this.name = name;
        nameView.setText(name);
    }

    public void setImg(Drawable img) {
        this.img = img;
        imageView.setImageDrawable(img);
    }
}
