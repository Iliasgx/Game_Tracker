package com.umbrella.stfctracker.DataTypes.Enums;

public enum Faction {
    NEUTRAL,
    FEDERATION,
    KLINGON,
    ROMULAN,
    AUGMENT,
    ROGUE;

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
