package com.stardust.theme.sample;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import android.view.View;

import com.stardust.theme.app.ThemeColorAppCompatActivity;
import com.stardust.theme.preference.ThemeColorPreferenceFragment;

/**
 * Created by Stardust on 2017/3/5.
 */

public class SettingActivity extends ThemeColorAppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mt_activity_settings);
        setUpToolbar();
        getFragmentManager().beginTransaction().replace(R.id.fragment_setting, new PreferenceFragment()).commit();
    }

    private void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Setting");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public static class PreferenceFragment extends ThemeColorPreferenceFragment {

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.mt_prefs);
        }
    }
}
