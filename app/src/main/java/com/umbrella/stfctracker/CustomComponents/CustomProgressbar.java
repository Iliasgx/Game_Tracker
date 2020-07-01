package com.umbrella.stfctracker.CustomComponents;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.umbrella.stfctracker.R;

public class CustomProgressbar extends RelativeLayout {

    private ProgressBar progressBar;
    private TextView value;

    private int progress = 0;
    private int max = 1;

    public CustomProgressbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(context, R.layout.custom_progressbar, this);

        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.CustomProgressbar);

        try {
            progress = arr.getInt(R.styleable.CustomProgressbar_currentLevel, 0);
            max = arr.getInt(R.styleable.CustomProgressbar_maxLevel, 1);
        } finally {
            arr.recycle();
        }

        initComponent();

        setProgress(progress);
        setMax(max);

    }

    private void initComponent() {
        progressBar = requireViewById(R.id.customProgressbar_progressbar);
        value = requireViewById(R.id.customProgressbar_value);
    }

    public int getProgress() {
        return progressBar.getProgress();
    }
    public int getMax() {
        return progressBar.getMax();
    }

    public void setProgress(int progress) {
        this.progress = progress;
        progressBar.setProgress(progress);
        value.setText(getResources().getString(R.string.progressString, progress, max));
    }
    public void setMax(int max) {
        this.max = max;
        progressBar.setMax(max);
        value.setText(getResources().getString(R.string.progressString, progress, max));
    }

    public void setValue(int progress, int max) {
        this.progress = progress;
        this.max = max;
        setMax(max);
        setProgress(progress);
    }
}
