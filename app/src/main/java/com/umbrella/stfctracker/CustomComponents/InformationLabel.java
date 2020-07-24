package com.umbrella.stfctracker.CustomComponents;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.umbrella.stfctracker.R;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class InformationLabel extends CoordinatorLayout {

    private TextView label;
    private ConstraintLayout labelLayout;

    public InformationLabel(Context context) {
        super(context, null);
        inflate(context, R.layout.custom_informationlabel, this);

        label = requireViewById(R.id.customInformationLabel_label);
        labelLayout = requireViewById(R.id.customInformationLabel_layout);

        setBackgroundColor(getResources().getColor(R.color.textColor_yellow, null));
    }

    public void setValue(long val) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.ITALIAN);
        symbols.setGroupingSeparator(' ');
        DecimalFormat pattern = new DecimalFormat("#,###", symbols);

        label.setText(pattern.format(val));
    }

    public void setLocation(View clickedView, int offsetX, int offsetY) {
        //CoordinatorLayout.LayoutParams params = new CoordinatorLayout.LayoutParams(labelLayout.getLayoutParams());

        int[] loc = new int[2];
        clickedView.getLocationInWindow(loc);

        labelLayout.setPadding(loc[0] + offsetX, loc[1] - clickedView.getHeight() + offsetY, 0, 0);

        //params.topMargin = loc[1] - clickedView.getHeight() + offsetY;
        //params.leftMargin = loc[0] + offsetX;

        //labelLayout.setLayoutParams(params);
    }
}
