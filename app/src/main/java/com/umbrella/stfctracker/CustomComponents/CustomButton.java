package com.umbrella.stfctracker.CustomComponents;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.umbrella.stfctracker.R;
import com.umbrella.stfctracker.Structures.TimeDisplay;

public class CustomButton extends ConstraintLayout {

    private ConstraintLayout mBorder;
    private FrameLayout mFrame;
    private TextView mTitle;
    private TextView mTime;

    private Drawable borderDrawable;
    private Drawable frameDrawable;
    private int allTextSize;
    private String title;
    private int time;
    private boolean showTime;
    private boolean isUsable;

    public CustomButton(Context context) {
        this(context, null);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context ctx, AttributeSet attrs) {
        inflate(ctx, R.layout.custom_button, this);

        initComponents();

        TypedArray arr = ctx.obtainStyledAttributes(attrs, R.styleable.CustomButton);

        for (int i = 0; i < arr.getIndexCount(); i++) {
            int N = arr.getIndex(i);
            switch (N) {
                case R.styleable.CustomButton_borderDrawable:
                    borderDrawable = arr.getDrawable(N);
                    setBorderDrawable(borderDrawable);
                    break;
                case R.styleable.CustomButton_frameDrawable:
                    frameDrawable = arr.getDrawable(N);
                    setFrameDrawable(frameDrawable);
                    break;
                case R.styleable.CustomButton_allTextSize:
                    allTextSize = arr.getDimensionPixelSize(N, 0);
                    setAllTextSize(allTextSize);
                    break;
                case R.styleable.CustomButton_title:
                    title = arr.getString(N);
                    setTitle(title);
                    break;
                case R.styleable.CustomButton_time:
                    time = arr.getInteger(N, 0);
                    setTime(time);
                    break;
                case R.styleable.CustomButton_showTime:
                    showTime = arr.getBoolean(N, false);
                    setShowTime(showTime);
                    break;
                case R.styleable.CustomButton_usable:
                    isUsable = arr.getBoolean(N, true);
                    setUsable(isUsable);
                    break;
            }
        }

        arr.recycle();
    }

    private void initComponents() {
        mBorder = requireViewById(R.id.customButton_layout);
        mFrame = requireViewById(R.id.customButton_frame);
        mTitle = requireViewById(R.id.customButton_text);
        mTime = requireViewById(R.id.customButton_time);
    }

    public Drawable getBorderDrawable() {
        return borderDrawable;
    }
    public Drawable getFrameDrawable() {
        return frameDrawable;
    }
    public int getAllTextSize() {
        return allTextSize;
    }
    public String getTitle() {
        return title;
    }
    public int getTime() {
        return time;
    }
    public boolean isShowTime() {
        return showTime;
    }
    public boolean isUsable() {
        return isUsable;
    }

    public void setBorderDrawable(Drawable borderDrawable) {
        this.borderDrawable = borderDrawable;
        mBorder.setForeground(borderDrawable);
    }

    public void setFrameDrawable(Drawable frameDrawable) {
        this.frameDrawable = frameDrawable;
        mFrame.setBackground(frameDrawable);
    }

    public void setAllTextSize(int allTextSize) {
        this.allTextSize = allTextSize;
        mTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, allTextSize);
        mTime.setTextSize(TypedValue.COMPLEX_UNIT_PX, allTextSize);
    }

    public void setTitle(String title) {
        this.title = title;
        mTitle.setText(title);
    }

    public void setTime(int time) {
        this.time = time;
        mTime.setText(new TimeDisplay(getContext()).getTime(time));
    }

    public void setShowTime(boolean showTime) {
        this.showTime = showTime;
        mTime.setVisibility(showTime ? VISIBLE : GONE);
        mTitle.setGravity(showTime ? Gravity.START : Gravity.CENTER_HORIZONTAL);
    }

    public void setUsable(boolean usable) {
        isUsable = usable;
        mFrame.setVisibility(usable ? VISIBLE : INVISIBLE);
        setClickable(usable);
    }
}
