package com.umbrella.stfctracker.CustomComponents;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.umbrella.stfctracker.DataTypes.ResourceMaterial;
import com.umbrella.stfctracker.Structures.ValueIndicator;
import com.umbrella.stfctracker.R;

public class ResourceAmount extends RelativeLayout {
    private ImageView resource;
    private TextView amount;

    private ResourceMaterial.Material material;
    private long value;

    private boolean isNeeded = true;

    public ResourceAmount(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(context, R.layout.custom_resource_amount, this);

        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.ResourceAmount);

        try {
            material = ResourceMaterial.Material.values()[arr.getIndex(R.styleable.ResourceAmount_resourceType)];

            String mAmount = arr.getString(R.styleable.ResourceAmount_amount);
            value = mAmount != null ? Long.parseLong(mAmount) : 0L;
        } catch (IndexOutOfBoundsException ignored) {
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            arr.recycle();
        }

        initComponents();

        if (isNeeded) {
            setValue(value);
            setMaterial(material);
        }
    }

    private void initComponents() {
        resource = requireViewById(R.id.customResourceAmount_ResourceImg);
        amount = requireViewById(R.id.customResourceAmount_ResourceAmount);
    }

    public ResourceMaterial.Material getMaterial() {
        return material;
    }
    public long getValue() {
        return value;
    }
    public boolean isNeeded() {
        return isNeeded;
    }

    public void setMaterial(ResourceMaterial.Material material) {
        if (material == null) return;
        this.material = material;

        Drawable dr = null;
        switch (material) {
            case PARSTEEL:
                dr = getResources().getDrawable(R.drawable.parsteel, null);
                break;
            case TRITANIUM:
                dr = getResources().getDrawable(R.drawable.tritanium, null);
                break;
            case DILITHIUM:
                dr = getResources().getDrawable(R.drawable.dilithium, null);
                break;
        }
        resource.setImageDrawable(dr);
    }

    public void setValue(long val) {
        this.value = val;
        amount.setText(new ValueIndicator().setValueWithIndicator(val));
    }

    public void setNeeded(boolean needed) {
        isNeeded = needed;
        setVisibility(isNeeded ? VISIBLE : GONE);
    }
}
