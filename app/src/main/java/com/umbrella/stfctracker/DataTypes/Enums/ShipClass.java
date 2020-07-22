package com.umbrella.stfctracker.DataTypes.Enums;

import android.graphics.drawable.Drawable;

import com.umbrella.stfctracker.R;

public enum ShipClass {
    BATTLESHIP  (R.drawable.shipclass_battleship),
    EXPLORER    (R.drawable.shipclass_explorer),
    INTERCEPTOR (R.drawable.shipclass_interceptor),
    SURVEY      (R.drawable.shipclass_survey);

    private int imageId;

    ShipClass(int id) {
        this.imageId = id;
    }

    public int getImageId() {
        return imageId;
    }

    @Override
    public String toString() {
        String[] temp = super.name().toLowerCase().split("_");

        StringBuilder builder = new StringBuilder();
        for(String psc : temp) {
            builder.append(psc.substring(0,1).toUpperCase()).append(psc.substring(1)).append(" ");
        }

        return builder.toString().trim();
    }
}
