package com.umbrella.stfctracker.Database.Data;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.umbrella.stfctracker.DataTypes.ResourceMaterial;
import com.umbrella.stfctracker.Database.Entities.Level;
import com.umbrella.stfctracker.Database.Entities.Tier;
import com.umbrella.stfctracker.MainActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class FunctionsDB {

    public LinkedList<Level> addLevels(Level... levels) {
        return new LinkedList<>(new ArrayList<>(Arrays.asList(levels)));
    }

    public LinkedList<ResourceMaterial> addResources(ResourceMaterial... resourceMaterials) {
        return new LinkedList<>(new ArrayList<>(Arrays.asList(resourceMaterials)));
    }

    public LinkedList<ResourceMaterial> addMaterials(ResourceMaterial... resourceMaterials) {
        return addResources(resourceMaterials);
    }

    public LinkedList<Tier> addTiers(Tier... tiers) {
        return new LinkedList<>(new ArrayList<>(Arrays.asList(tiers)));
    }

    public LinkedList<Tier.Level> addShipLevels(Tier.Level... levels) {
        return new LinkedList<>(new ArrayList<>(Arrays.asList(levels)));
    }

    public LinkedList<Tier.Component> addComponents(Tier.Component... components) {
        return new LinkedList<>(new ArrayList<>(Arrays.asList(components)));
    }

    public LinkedList<ResourceMaterial> addRepairCostResources(ResourceMaterial... resourceMaterials) {
        return new LinkedList<>(new ArrayList<>(Arrays.asList(resourceMaterials)));
    }

    public LinkedList<ResourceMaterial> addRewards(ResourceMaterial... resourceMaterials) {
        return new LinkedList<>(new ArrayList<>(Arrays.asList(resourceMaterials)));
    }

    public LinkedList<ResourceMaterial> setEmpty() {
        return new LinkedList<>();
    }

    public static Drawable decodeDrawable(Resources resources, String code) {
        return resources.getDrawable(resources.getIdentifier(code, "drawable", Application.getProcessName()), null);
    }
}
