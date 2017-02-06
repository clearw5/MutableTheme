package com.stardust.theme.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;

import com.stardust.theme.ThemeColorManager;
import com.stardust.theme.ThemeColorMutable;
import com.stardust.widgets.PressButton;

/**
 * Created by Stardust on 2016/8/14.
 */
public class ThemeColorPressButton extends PressButton implements ThemeColorMutable {

    public ThemeColorPressButton(Context context) {
        super(context);
        init();
    }

    public ThemeColorPressButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ThemeColorPressButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ThemeColorPressButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        ThemeColorManager.add(this);
    }

    @Override
    public void setColorPrimary(int color) {
        setPressedColor(color);
    }
}
