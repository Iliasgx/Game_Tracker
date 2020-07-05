package com.umbrella.stfctracker.Database.Data;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.umbrella.stfctracker.DataTypes.ResourceMaterial;
import com.umbrella.stfctracker.Database.Entities.Level;
import com.umbrella.stfctracker.MainActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public abstract class DataFunctions {

    public LinkedList<Level> addLevels(Level... levels) {
        return new LinkedList<>(new ArrayList<>(Arrays.asList(levels)));
    }

    public LinkedList<ResourceMaterial> addResources(ResourceMaterial... resourceMaterials) {
        return new LinkedList<>(new ArrayList<>(Arrays.asList(resourceMaterials)));
    }

    public LinkedList<ResourceMaterial> addMaterials(ResourceMaterial... resourceMaterials) {
        return addResources(resourceMaterials);
    }

    public static Drawable decodeDrawable(Resources resources, String code) {
        //return resources.getDrawable(resources.getIdentifier(code, "drawable", "com.umbrella.stfctracker"), null);
        return resources.getDrawable(resources.getIdentifier(code, "drawable", Application.getProcessName()), null);
    }
}
