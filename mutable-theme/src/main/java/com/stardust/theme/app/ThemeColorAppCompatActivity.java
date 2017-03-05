package com.stardust.theme.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.stardust.theme.ThemeColorManager;

/**
 * Created by Stardust on 2017/3/5.
 */

public class ThemeColorAppCompatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeColorManager.addActivityStatusBar(this);
    }
}
