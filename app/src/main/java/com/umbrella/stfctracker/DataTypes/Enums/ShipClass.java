package com.umbrella.stfctracker.DataTypes.Enums;

import android.graphics.drawable.Drawable;

import com.umbrella.stfctracker.R;

// TODO: set images
public enum ShipClass {
    BATTLESHIP  (R.drawable.add),
    EXPLORER    (0),
    INTERCEPTOR (0),
    SURVEY      (0);

    public int imageId;

    ShipClass(int id) {
        this.imageId = id;
    }

    public int getImageId() {
        return imageId;
    }
}
