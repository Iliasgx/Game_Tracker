package com.umbrella.stfctracker.CustomComponents;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.umbrella.stfctracker.R;

public class ShipItem extends RelativeLayout {

    public ShipItem(Context context) {
        super(context, null);
    }

    public ShipItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(context, R.layout.ship_item, this);
    }
}
