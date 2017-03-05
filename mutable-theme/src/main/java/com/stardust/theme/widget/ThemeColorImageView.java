package com.stardust.theme.widget;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.stardust.theme.ThemeColor;
import com.stardust.theme.ThemeColorManager;
import com.stardust.theme.ThemeColorMutable;
import com.stardust.theme.internal.DrawableTool;

/**
 * Created by Stardust on 2017/2/12.
 */

public class ThemeColorImageView extends ImageView implements ThemeColorMutable {

    private int mColor = Color.TRANSPARENT;

    public ThemeColorImageView(Context context) {
        super(context);
        init();
    }

    public ThemeColorImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ThemeColorImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ThemeColorImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        ThemeColorManager.add(this);
    }

    @Override
    public void setThemeColor(ThemeColor color) {
        if (mColor == color.colorPrimary)
            return;
        setColor(color.colorPrimary);
    }

    @Override
    public void setImageResource(int resId) {
        super.setImageResource(resId);
        if (mColor != Color.TRANSPARENT)
            setColor(mColor);
    }

    private void setColor(int color) {
        setImageDrawable(DrawableTool.filterDrawableColor(getDrawable(), color));
    }
}
