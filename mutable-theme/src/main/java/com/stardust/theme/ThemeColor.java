package com.stardust.theme;

import android.content.SharedPreferences;

/**
 * Created by Stardust on 2017/3/5.
 */

public class ThemeColor {

    private static final String KEY_COLOR_PRIMARY = "com.stardust.theme.ThemeColor.KEY_COLOR_PRIMARY";
    private static final String KEY_COLOR_PRIMARY_DARK = "com.stardust.theme.ThemeColor.KEY_COLOR_PRIMARY_DARK";
    private static final String KEY_COLOR_ACCENT = "com.stardust.theme.ThemeColor.KEY_COLOR_ACCENT";

    private static final ThemeColor TRANSPARENT = new ThemeColor();

    public int colorPrimary, colorAccent, colorPrimaryDark;

    public ThemeColor() {
    }


    public ThemeColor(int color) {
        this(color, color, color);
    }

    public ThemeColor(int colorPrimary, int colorAccent) {
        this(colorPrimary, colorPrimary, colorAccent);
    }

    public ThemeColor(int colorPrimary, int colorPrimaryDark, int colorAccent) {
        this.colorAccent = colorAccent;
        this.colorPrimary = colorPrimary;
        this.colorPrimaryDark = colorPrimaryDark;
    }

    public ThemeColor colorPrimary(int colorPrimary) {
        this.colorPrimary = colorPrimary;
        return this;
    }

    public ThemeColor colorPrimaryDark(int colorPrimaryDark) {
        this.colorPrimaryDark = colorPrimary;
        return this;
    }

    public ThemeColor colorAccent(int colorAccent) {
        this.colorAccent = colorPrimary;
        return this;
    }

    public void saveIn(SharedPreferences preferences) {
        preferences.edit()
                .putInt(KEY_COLOR_PRIMARY, colorPrimary)
                .putInt(KEY_COLOR_PRIMARY_DARK, colorPrimaryDark)
                .putInt(KEY_COLOR_ACCENT, colorAccent)
                .apply();

    }

    public ThemeColor readFrom(SharedPreferences preferences, ThemeColor defaultThemeColor) {
        colorPrimary = preferences.getInt(KEY_COLOR_PRIMARY, defaultThemeColor.colorPrimary);
        colorAccent = preferences.getInt(KEY_COLOR_ACCENT, defaultThemeColor.colorAccent);
        colorPrimaryDark = preferences.getInt(KEY_COLOR_PRIMARY_DARK, defaultThemeColor.colorPrimaryDark);
        return this;
    }

    public static ThemeColor fromPreferences(SharedPreferences preferences, ThemeColor defaultThemeColor) {
        if (preferences.contains(KEY_COLOR_PRIMARY) && preferences.contains(KEY_COLOR_PRIMARY_DARK) && preferences.contains(KEY_COLOR_ACCENT)) {
            return new ThemeColor().readFrom(preferences, TRANSPARENT);
        } else if (defaultThemeColor == null) {
            return null;
        } else {
            return new ThemeColor().readFrom(preferences, defaultThemeColor);
        }
    }
}
