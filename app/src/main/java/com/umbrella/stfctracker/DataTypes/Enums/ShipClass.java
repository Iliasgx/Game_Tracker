package com.umbrella.stfctracker.DataTypes.Enums;

import android.graphics.drawable.Drawable;

import com.umbrella.stfctracker.R;

// TODO: set images
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
}
