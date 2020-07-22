package com.umbrella.stfctracker.DataTypes.Enums;

import java.io.Serializable;

public enum Group implements Serializable {
    NONE,
    DRYDOCKS,
    DEFENSE_PLATFORMS,
    PARSTEEL_BUILDINGS,
    TRITANIUM_BUILDINGS,
    DILITHIUM_BUILDINGS,
    RESEARCH_BUILDINGS,
    SHIP_BUILDINGS;

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
