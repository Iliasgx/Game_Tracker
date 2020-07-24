package com.umbrella.stfctracker.DataTypes.Enums;

import com.umbrella.stfctracker.R;

import java.io.Serializable;

public enum Tree implements Serializable {
    COMBAT  (R.drawable.research_tree_combat),
    STATION (R.drawable.research_tree_starbase),
    GALAXY  (R.drawable.research_tree_galaxy),
    OUTLAW  (R.drawable.research_tree_outlaw);

    private int backgroundId;

    Tree(int backgroundId) {
        this.backgroundId = backgroundId;
    }

    public int getBackgroundId() {
        return backgroundId;
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
