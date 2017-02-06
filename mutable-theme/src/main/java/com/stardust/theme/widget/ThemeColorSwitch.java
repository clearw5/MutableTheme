package com.stardust.theme.widget;

import android.content.Context;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;

import com.stardust.theme.ThemeColorHelper;
import com.stardust.theme.ThemeColorManager;
import com.stardust.theme.ThemeColorMutable;


/**
 * Created by Stardust on 2016/8/7.
 */
public class ThemeColorSwitch extends SwitchCompat implements ThemeColorMutable {
    public ThemeColorSwitch(Context context) {
        super(context);
        init();
    }

    public ThemeColorSwitch(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ThemeColorSwitch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        ThemeColorManager.add(this);
    }

    @Override
    public void setColorPrimary(int color) {
        ThemeColorHelper.setColorPrimary(this, color);
    }
}
