package com.umbrella.stfctracker.Database.TypeConverters;

import androidx.room.TypeConverter;

import com.umbrella.stfctracker.DataTypes.Enums.Grade;

public class GradeConverter {

    @TypeConverter
    public Grade fromInt(int index) {
        return (index == -1) ? null : Grade.values()[index];
    }

    @TypeConverter
    public int toInt(Grade grade) {
        return (grade == null) ? -1 : grade.ordinal();
    }
}
