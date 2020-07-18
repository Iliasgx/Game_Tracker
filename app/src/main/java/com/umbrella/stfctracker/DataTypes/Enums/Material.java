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
    BATTLESHIP_PARTS    (R.drawable.battleship_parts),
    EXPLORER_PARTS      (R.drawable.explorer_parts),
    INTERCEPTOR_PARTS   (R.drawable.interceptor_parts),
    SURVEY_PARTS        (R.drawable.survey_parts),
    SHIP_XP             (R.drawable.ship_xp),
    URANIUM             (R.drawable.plutonium);

    private int imageId;

    Material(int id) {
        this.imageId = id;
    }

    public int getImageId() {
        return imageId;
    }

}
