package com.umbrella.stfctracker.CustomComponents;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.umbrella.stfctracker.DataTypes.Enums.Grade;
import com.umbrella.stfctracker.DataTypes.Enums.Material;
import com.umbrella.stfctracker.DataTypes.Enums.Rarity;
import com.umbrella.stfctracker.R;

public class ResourceMaterialAmount extends RelativeLayout {
    private ImageView resourceImg;
    private ImageView star1;
    private ImageView star2;
    private ImageView star3;
    private ImageView star4;
    private TextView resourceAmount;
    private TextView resourceType;

    private int value;
    private Rarity rarity;
    private Material material;
    private Grade grade;

    private boolean isNeeded = true;
    private boolean isBackgroundVisible = true;

    public ResourceMaterialAmount(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(context, R.layout.custom_resource_material_amount, this);

        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.ResourceMaterialAmount);

        try {
            value = arr.getInt(R.styleable.ResourceAmount_amount, 0);
            rarity = Rarity.values()[arr.getIndex(R.styleable.ResourceMaterialAmount_rarity)];
            material = Material.values()[3 + arr.getIndex(R.styleable.ResourceMaterialAmount_materialType)];
            grade = Grade.values()[arr.getIndex(R.styleable.ResourceMaterialAmount_stars)];
            isBackgroundVisible = arr.getBoolean(R.styleable.ResourceMaterialAmount_backgroundVisible, true);
        } catch (IndexOutOfBoundsException ignored) {
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            arr.recycle();
        }

        initComponents();

        setIsBackgroundVisible(isBackgroundVisible);

        if (isNeeded) {
            setValue(value);
            setRarity(rarity);
            setMaterial(material);
            setGrade(grade);
        }
    }

    private void initComponents() {
        resourceImg = requireViewById(R.id.customResourceMaterialAmount_ResourceImg);
        star1 = requireViewById(R.id.customResourceMaterial_star1);
        star2 = requireViewById(R.id.customResourceMaterial_star2);
        star3 = requireViewById(R.id.customResourceMaterial_star3);
        star4 = requireViewById(R.id.customResourceMaterial_star4);
        resourceAmount = requireViewById(R.id.customResourceMaterialAmount_ResourceAmount);
        resourceType = requireViewById(R.id.customResourceMaterialAmount_ResourceAmountType);
    }

    public int getValue() {
        return value;
    }
    public Rarity getRarity() {
        return rarity;
    }
    public Material getMaterial() {
        return material;
    }
    public Grade getGrade() {
        return grade;
    }

    public void setValue(int value) {
        this.value = value;
        resourceAmount.setText(String.valueOf(value));
    }

    public void setRarity(Rarity rarity) {
        if (rarity == null | rarity == Rarity.NONE) return;
        this.rarity = rarity;

        String type = "";
        switch (rarity) {
            case COMMON:
                type = getResources().getString(R.string.short_common);
                break;
            case UNCOMMON:
                type = getResources().getString(R.string.short_uncommon);
                break;
            case RARE:
                type = getResources().getString(R.string.short_rare);
                break;
            case EPIC:
                type = getResources().getString(R.string.short_epic);
                break;
        }
        resourceType.setText(type);
    }

    // TODO: setMaterialDrawables
    public void setMaterial(Material material) {
        if (material == null) return;
        this.material = material;

        resourceImg.setImageDrawable(getResources().getDrawable(material.getImageId(), null));
    }

    public void setGrade(Grade grade) {
        if (grade == null | grade == Grade.NONE) return;
        this.grade = grade;

        int nr = grade.ordinal() - 1;
        star1.setVisibility(nr >= Grade.ONE.ordinal() ? VISIBLE : INVISIBLE);
        star2.setVisibility(nr >= Grade.TWO.ordinal() ? VISIBLE : INVISIBLE);
        star3.setVisibility(nr >= Grade.THREE.ordinal() ? VISIBLE : INVISIBLE);
        star4.setVisibility(nr >= Grade.FOUR.ordinal() ? VISIBLE : INVISIBLE);
    }

    public void setNeeded(boolean needed) {
        isNeeded = needed;
        setVisibility(needed ? VISIBLE : INVISIBLE);
    }

    public void setIsBackgroundVisible(boolean isBackgroundVisible) {
        this.isBackgroundVisible = isBackgroundVisible;

        RelativeLayout layout = requireViewById(R.id.customResourceMaterialAmount_SecondLayout);
        layout.setBackgroundColor(isBackgroundVisible
                ? getResources().getColor(R.color.resource_background, getContext().getTheme())
                : getResources().getColor(android.R.color.transparent, getContext().getTheme()));
        invalidate();
    }
}
