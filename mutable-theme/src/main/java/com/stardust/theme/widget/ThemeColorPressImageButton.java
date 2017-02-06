package com.stardust.theme.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.stardust.theme.ThemeColorManager;
import com.stardust.theme.ThemeColorMutable;
import com.stardust.widgets.PressImageButton;

/**
 * Created by Stardust on 2016/8/12.
 */
public class ThemeColorPressImageButton extends PressImageButton implements ThemeColorMutable {
    public ThemeColorPressImageButton(Context context) {
        super(context);
        init();
    }

    public ThemeColorPressImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ThemeColorPressImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ThemeColorPressImageButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    public void setColorPrimary(int color) {
        setPressedColor(color);
    }

    private void init() {
        ThemeColorManager.add(this);
    }
}
