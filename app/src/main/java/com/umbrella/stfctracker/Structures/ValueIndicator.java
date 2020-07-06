package com.umbrella.stfctracker.Structures;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public final class ValueIndicator {

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

    public String setStringFormat(long value, char separator) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.ITALIAN);
        symbols.setGroupingSeparator(separator);
        DecimalFormat pattern = new DecimalFormat("#,###", symbols);
        return pattern.format(value);
    }
}