package com.umbrella.stfctracker.CustomComponents;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.Size;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.umbrella.stfctracker.DataTypes.ResourceMaterial;
import com.umbrella.stfctracker.R;

import java.util.Arrays;
import java.util.LinkedList;

public class CustomResourceMaterialView extends RelativeLayout {
    private ConstraintLayout materialLayout;
    private LinearLayout resourceLayout;
    private ImageView emptyA, emptyB, emptyC, emptyD;
    private LinkedList<ResourceMaterialAmount> materialAmounts;
    private LinkedList<ResourceAmount> resourceAmounts;

    private boolean showMaterials = true;
    private boolean showResources = true;
    private NumOfResources numOfResources;
    private MaterialDisplayType materialDisplayType;

    private LinkedList<ResourceMaterial> materials = new LinkedList<>();
    private LinkedList<ResourceMaterial> resources = new LinkedList<>();

    public CustomResourceMaterialView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(context, R.layout.custom_resource_material_view, this);

        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.CustomResourceMaterialView);

        try {
            showMaterials = arr.getBoolean(R.styleable.CustomResourceMaterialView_showMaterials, true);
            showResources = arr.getBoolean(R.styleable.CustomResourceMaterialView_showResources, true);
            numOfResources = NumOfResources.values()[arr.getInt(R.styleable.CustomResourceMaterialView_numOfResources, NumOfResources.LIVE_ADAPTING.ordinal())];
            materialDisplayType = MaterialDisplayType.values()[arr.getInt(R.styleable.CustomResourceMaterialView_materialDisplayType, MaterialDisplayType.FOUR.ordinal())];
        } catch (Exception ignored) {
        } finally {
            arr.recycle();
        }

        initComponents();

        setShowMaterials(showMaterials);
        setShowResources(showResources);
        setNumOfResources(numOfResources);
        setMaterialDisplayType(materialDisplayType);

        resourceAmounts.forEach(item ->
                item.setOnClickListener(view -> {
                    InformationLabel label = new InformationLabel(getContext());
                    label.setValue(item.getValue());
                    label.setLocation(view, -15, -10);
                    ((RelativeLayout)requireViewById(R.id.customResourceMaterialView_layout)).addView(label);
                })
        );
    }

    private void initComponents() {
        materialLayout = requireViewById(R.id.customResourceMaterialView_materialLayout);
        resourceLayout = requireViewById(R.id.customResourceMaterialView_resourceLayout);

        emptyA = requireViewById(R.id.customResourceMaterialView_emptyMaterialA);
        emptyB = requireViewById(R.id.customResourceMaterialView_emptyMaterialB);
        emptyC = requireViewById(R.id.customResourceMaterialView_emptyMaterialC);
        emptyD = requireViewById(R.id.customResourceMaterialView_emptyMaterialD);

        materialAmounts = new LinkedList<>(Arrays.asList(
                requireViewById(R.id.customResourceMaterialView_MaterialA),
                requireViewById(R.id.customResourceMaterialView_MaterialB),
                requireViewById(R.id.customResourceMaterialView_MaterialC),
                requireViewById(R.id.customResourceMaterialView_MaterialD)
        ));

        resourceAmounts = new LinkedList<>(Arrays.asList(
                requireViewById(R.id.customResourceMaterialView_amountA),
                requireViewById(R.id.customResourceMaterialView_amountB),
                requireViewById(R.id.customResourceMaterialView_amountC)
        ));
    }

    public boolean isMaterialsVisible() {
        return showMaterials;
    }
    public boolean isResourcesVisible() {
        return showResources;
    }

    public void setShowMaterials(boolean showMaterials) {
        this.showMaterials = showMaterials;
        materialLayout.setVisibility(showMaterials ? VISIBLE : GONE);
    }

    public void setShowResources(boolean showResources) {
        this.showResources = showResources;
        resourceLayout.setVisibility(showResources ? VISIBLE : GONE);
    }

    public void setNumOfResources(NumOfResources numOfResources) {
        this.numOfResources = numOfResources;

        resourceAmounts.forEach(item -> item.setNeeded(true));

        if (numOfResources.equals(NumOfResources.TWO)) resourceAmounts.getLast().setNeeded(false);

        setResources(resources);
    }

    public void setMaterialDisplayType(MaterialDisplayType materialDisplayType) {
        this.materialDisplayType = materialDisplayType;

        boolean allVisible = (materialDisplayType == MaterialDisplayType.FOUR);

        emptyA.setVisibility(VISIBLE);
        emptyB.setVisibility(VISIBLE);
        emptyC.setVisibility(allVisible ? VISIBLE : GONE);
        emptyD.setVisibility(allVisible ? VISIBLE : GONE);

        setMaterials(materials);
    }

    private enum NumOfResources {
        LIVE_ADAPTING,
        TWO,
        THREE
    }

    private enum MaterialDisplayType {
        TWO,
        FOUR
    }

    public void setResources(@Size(max = 3) LinkedList<ResourceMaterial> resources) {
        this.resources = resources;

        LinkedList<ResourceAmount> pops = new LinkedList<>(resourceAmounts);

        resources.forEach(resourceMaterial -> {
            ResourceAmount item = pops.pop();

            item.setNeeded(true);
            item.setMaterial(resourceMaterial.getMaterial());
            item.setValue(resourceMaterial.getValue());
        });

        pops.forEach(item -> item.setNeeded(false));
    }

    public void setMaterials(@Size(max = 4) LinkedList<ResourceMaterial> materials) {
        this.materials = materials;

        LinkedList<ResourceMaterialAmount> pops = new LinkedList<>(materialAmounts);

        materials.forEach(resourceMaterial -> {
            ResourceMaterialAmount item = pops.pop();

            boolean indexOutOfBoundsMatType = (materialDisplayType.equals(MaterialDisplayType.TWO)) && resourceMaterial.getId() > 2;

            item.setNeeded(!indexOutOfBoundsMatType);
            item.setValue(Long.valueOf(resourceMaterial.getValue()).intValue());
            item.setRarity(resourceMaterial.getRarity());
            item.setMaterial(resourceMaterial.getMaterial());
            item.setGrade(resourceMaterial.getGrade());
        });

        pops.forEach(item -> item.setNeeded(false));
    }
}
