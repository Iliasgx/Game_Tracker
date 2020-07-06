package com.umbrella.stfctracker.DataTypes.Enums;

import com.umbrella.stfctracker.R;

// TODO: set images
public enum Material {
    PARSTEEL            (R.drawable.parsteel),
    TRITANIUM           (R.drawable.tritanium),
    DILITHIUM           (R.drawable.dilithium),
    GAS                 (R.drawable.gas),
    ORE                 (R.drawable.ore),
    CRYSTAL             (R.drawable.crystal),
    BATTLESHIP_PARTS    (0),
    EXPLORER_PARTS      (0),
    INTERCEPTOR_PARTS   (0),
    SURVEY_PARTS        (0),
    SHIP_XP             (0);

    public int imageId;

    Material(int id) {
        this.imageId = id;
    }

    public int getImageId() {
        return imageId;
    }

}
