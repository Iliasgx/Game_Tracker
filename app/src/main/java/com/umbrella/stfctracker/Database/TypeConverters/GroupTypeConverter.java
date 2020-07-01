package com.umbrella.stfctracker.Database.TypeConverters;

import androidx.room.TypeConverter;

import com.umbrella.stfctracker.DataTypes.Enums.Group;

public class GroupTypeConverter {

    @TypeConverter
    public Group fromInt(int groupId) {
        return Group.values()[groupId];
    }

    @TypeConverter
    public int toInt(Group group) {
        return group.ordinal();
    }
}
