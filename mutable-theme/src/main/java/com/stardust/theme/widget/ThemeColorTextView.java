package com.stardust.theme.widget;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

import com.stardust.theme.ThemeColor;
import com.stardust.theme.ThemeColorManager;
import com.stardust.theme.ThemeColorMutable;

/**
 * Created by Stardust on 2017/3/5.
 */

public class ThemeColorTextView extends AppCompatTextView implements ThemeColorMutable {

    public ThemeColorTextView(Context context) {
        super(context);
        init();
    }

    public ThemeColorTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ThemeColorTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        ThemeColorManager.add(this);
    }

    @Override
    public void setThemeColor(ThemeColor color) {
        setTextColor(color.colorPrimary);
    }
}
