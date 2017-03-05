package com.stardust.theme.sample;

import android.app.Application;

import com.stardust.theme.ThemeColorManager;

/**
 * Created by Stardust on 2017/3/5.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ThemeColorManager.init(this);
    }
}
