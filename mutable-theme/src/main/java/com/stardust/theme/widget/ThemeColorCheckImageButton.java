package com.stardust.theme.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.stardust.theme.ThemeColorManager;
import com.stardust.theme.ThemeColorMutable;
import com.stardust.widgets.CheckImageButton;

/**
 * Created by Stardust on 2016/8/12.
 */
public class ThemeColorCheckImageButton extends CheckImageButton implements ThemeColorMutable {

    public ThemeColorCheckImageButton(Context context) {
        super(context);
        init();
    }

    public ThemeColorCheckImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ThemeColorCheckImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ThemeColorCheckImageButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        ThemeColorManager.add(this);
    }

    @Override
    public void setColorPrimary(int color) {
        setCheckedColor(color);
    }
}

