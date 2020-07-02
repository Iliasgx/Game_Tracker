package com.umbrella.stfctracker.Structures;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class ValueIndicator {

    public ValueIndicator() {
    }

    public String setValueWithIndicator(long val) {
        DecimalFormat df = new DecimalFormat("#.#", new DecimalFormatSymbols(Locale.ITALIAN));

        String text;
        if (val < 10_000) {
            text = String.valueOf(val);
        } else if (val < 1_000_000) {
            text = df.format((double)val / 1_000) + "K";
        } else if (val < 1_000_000_000) {
            text = df.format((double)val / 1_000_000) + "M";
        } else {
            text = df.format((double)val / 1_000_000_000) + "B";
        }
        return text.replace(",", ".");
    }
}