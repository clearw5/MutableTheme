package com.stardust.theme.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import android.widget.HorizontalScrollView;

import com.stardust.theme.ThemeColorManager;
import com.stardust.theme.ThemeColorMutable;
import com.stardust.tool.BuildTool;

import java.lang.reflect.Field;

/**
 * Created by Stardust on 2016/8/14.
 */
public class ThemeColorHorizontalScrollView extends HorizontalScrollView implements ThemeColorMutable {
    private int mFadingEdgeColor;
    private EdgeEffect mEdgeGlowLeft;
    private EdgeEffect mEdgeGlowRight;

    public ThemeColorHorizontalScrollView(Context context) {
        super(context);
        init();
    }

    public ThemeColorHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ThemeColorHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ThemeColorHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            mEdgeGlowLeft = new EdgeEffect(getContext());
            mEdgeGlowRight = new EdgeEffect(getContext());
        }
        ThemeColorManager.add(this);
    }

    public int getSolidColor() {
        return mFadingEdgeColor;
    }

    @Override
    public void setColorPrimary(int color) {
        if (Build.VERSION.SDK_INT >= BuildTool.Android5) {
            mFadingEdgeColor = color;
            if (mEdgeGlowLeft != null && mEdgeGlowRight != null) {
                mEdgeGlowLeft.setColor(color);
                mEdgeGlowRight.setColor(color);
                syncEdgeEffect();
            }
            invalidate();
        }
    }

    private void syncEdgeEffect() {
        try {
            Field f1 = HorizontalScrollView.class.getDeclaredField("mEdgeGlowLeft");
            f1.setAccessible(true);
            f1.set(this, mEdgeGlowLeft);

            Field f2 = HorizontalScrollView.class.getDeclaredField("mEdgeGlowRight");
            f2.setAccessible(true);
            f2.set(this, mEdgeGlowRight);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
