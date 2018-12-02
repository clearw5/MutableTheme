package com.stardust.theme.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.stardust.theme.app.ColorSelectActivity;
import com.stardust.theme.app.ThemeColorAppCompatActivity;
import com.stardust.theme.util.ListBuilder;

import java.util.List;

public class MainActivity extends ThemeColorAppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final List<ColorSelectActivity.ColorItem> colorItems;

    static {
        colorItems = new ListBuilder<ColorSelectActivity.ColorItem>()
                .add(new ColorSelectActivity.ColorItem("基佬红", 0xFFF44336))
                .add(new ColorSelectActivity.ColorItem("基佬粉", 0xFFE91E63))
                .add(new ColorSelectActivity.ColorItem("基佬紫", 0xFF9C27B0))
                .add(new ColorSelectActivity.ColorItem("基深紫", 0xFF673AB7))
                .add(new ColorSelectActivity.ColorItem("基靛蓝", 0xFF3F51B5))
                .add(new ColorSelectActivity.ColorItem("基佬蓝", 0xFF2196F3))
                .add(new ColorSelectActivity.ColorItem("基亮蓝", 0xFF03A9F4))
                .add(new ColorSelectActivity.ColorItem("基蓝绿", 0xFF00BCD4))
                .add(new ColorSelectActivity.ColorItem("基佬青", 0xFF009688))
                .add(new ColorSelectActivity.ColorItem("基佬绿", 0xFF4CAF50))
                .add(new ColorSelectActivity.ColorItem("基亮绿", 0xFF8BC34A))
                .add(new ColorSelectActivity.ColorItem("基黄绿", 0xFFCDDC39))
                .add(new ColorSelectActivity.ColorItem("基佬黄", 0xFFFFEB3B))
                .add(new ColorSelectActivity.ColorItem("基琥珀", 0xFFFFC107))
                .add(new ColorSelectActivity.ColorItem("基佬橙", 0xFFFF9800))
                .add(new ColorSelectActivity.ColorItem("基深橙", 0xFFFF5722))
                .add(new ColorSelectActivity.ColorItem("基佬棕", 0xFF795548))
                .add(new ColorSelectActivity.ColorItem("基佬灰", 0xFF9E9E9E))
                .add(new ColorSelectActivity.ColorItem("基南灰", 0xFF607D8B))
                .list();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mt_activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mt_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_setting) {
            startActivity(new Intent(this, SettingActivity.class));
        } else if (id == R.id.nav_color_setting) {
            ColorSelectActivity.startColorSelect(this, "选择颜色", colorItems);
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
