package com.umbrella.stfctracker.Database.TypeConverters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.umbrella.stfctracker.DataTypes.ResourceMaterial;

import java.util.LinkedList;

public class ResourceMaterialTypeConverter {

    @TypeConverter
    public String fromResourceMaterialList(LinkedList<ResourceMaterial> resourceMaterials) {
        if (resourceMaterials == null) return (null);
        return new Gson().toJson(resourceMaterials, new TypeToken<LinkedList<ResourceMaterial>>(){}.getType());
    }

    @TypeConverter
    public LinkedList<ResourceMaterial> toResourceMaterialList(String resourceMaterialString) {
        if (resourceMaterialString == null) return (null);
        return new Gson().fromJson(resourceMaterialString, new TypeToken<LinkedList<ResourceMaterial>>(){}.getType());
    }
}
