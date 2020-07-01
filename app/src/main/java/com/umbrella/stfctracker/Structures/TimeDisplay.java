package com.umbrella.stfctracker.Structures;

import android.content.Context;

import com.umbrella.stfctracker.R;

public final class TimeDisplay {
    private Context ctx;

    private final int second = 1;
    private final int minute = second * 60;
    private final int hour = minute * 60;
    private final int day = hour * 24;
    private final int year = day * 365;

    private int time = 0;

    public TimeDisplay(Context ctx) {
        this.ctx = ctx;
    }

    public String getTime(int timeInSeconds) {
        if (timeInSeconds == 0) return ctx.getResources().getString(R.string.seconds, 0);

        int y = 0, d = 0, h = 0, m = 0, s = 0;
        time = timeInSeconds;

        if (time >= year) {
            y = val(year);
            time -= y * year;
        }
        if (time >= day) {
            d = val(day);
            time -= d * day;
        }
        if (time >= hour) {
            h = val(hour);
            time -= h * hour;
        }
        if (time >= minute) {
            m = val(minute);
            time -= m * minute;
        }
        if (time >= second) {
            s = val(second);
        }

        StringBuilder builder = new StringBuilder("");
        int count = 0;
        if (y > 0) {
            builder.append(ctx.getResources().getString(R.string.years, y)).append(" ");
            count++;
        }
        if (d > 0) {
            builder.append(ctx.getResources().getString(R.string.days, d)).append(" ");
            count++;
        }
        if (h > 0 && count < 2) {
            builder.append(ctx.getResources().getString(R.string.hours, h)).append(" ");
            count++;
        }
        if (m > 0 && count < 2) {
            builder.append(ctx.getResources().getString(R.string.minutes, m)).append(" ");
            count++;
        }
        if (s > 0 && count < 2) {
            builder.append(ctx.getResources().getString(R.string.seconds, s)).append(" ");
        }

        return builder.toString().trim();
    }

    private int val(int T) {
        return (int)Math.floor(time / (double)T);
    }
}
