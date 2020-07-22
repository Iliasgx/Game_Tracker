package com.umbrella.stfctracker.DataTypes.Enums;

import com.umbrella.stfctracker.R;

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
    URANIUM             (R.drawable.uranium);

    private int imageId;

    Material(int id) {
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
