package com.stardust.theme;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;

import com.stardust.theme.internal.ScrollingViewEdgeGlowColorHelper;
import com.stardust.tool.ColorTool;


/**
 * Created by Stardust on 2016/10/24.
 */

public class ThemeColorHelper {

    private static final String TAG = "ThemeColorHelper";

    private static void setColorPrimary(View v, int themeColor) {
        if (v instanceof ThemeColorMutable) {
            ((ThemeColorMutable) v).setColorPrimary(themeColor);
            return;
        }
        if (v instanceof AbsListView) {
            ScrollingViewEdgeGlowColorHelper.setEdgeGlowColor((AbsListView) v, themeColor);
            return;
        }
        Log.e(TAG, "Unsupported view: " + v);
    }

    private static void setColorPrimary(ViewGroup viewGroup, int themeColor) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            setColorPrimary(viewGroup.getChildAt(i), themeColor);
        }
    }

    public static void setColorPrimary(SwitchCompat switchCompat, int color) {
        int[][] states = new int[][]{
                new int[]{-android.R.attr.state_checked},
                new int[]{android.R.attr.state_checked},
        };
        int[] thumbColors = new int[]{
                Color.DKGRAY,
                color,
        };
        int[] trackColors = new int[]{
                Color.GRAY,
                ColorTool.makeAlpha(0x66, color)
        };
        DrawableCompat.setTintList(DrawableCompat.wrap(switchCompat.getThumbDrawable()), new ColorStateList(states, thumbColors));
        DrawableCompat.setTintList(DrawableCompat.wrap(switchCompat.getTrackDrawable()), new ColorStateList(states, trackColors));
    }


    @TargetApi(21)
    public static void setStatusBarColor(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
        }
    }
}
