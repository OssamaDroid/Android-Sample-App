package com.ossama.apps.androidsampleapp.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.ossama.apps.androidsampleapp.R;
import com.ossama.apps.androidsampleapp.listProducts.view.ListProductsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;
    @BindView(R.id.nav_view) NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Binding the views
        ButterKnife.bind(this);

        // Setting the toolbar
        setSupportActionBar(toolbar);

        // Setting the Drawer toggle in the Action Bar
        setDrawerToggle();

        // Setting the navigation view's items listener
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        toolbar.setTitle(R.string.welcome_screen);
    }

    private void setDrawerToggle() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        // Back button clicked
        // If the drawer layout is open, we close it
        // Otherwise, the default behavior of the back button is
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_list) {
            startListItemsActivity();
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    // Starts the Activity that shows the list of Items
    private void startListItemsActivity() {
        Intent intent = new Intent(this, ListProductsActivity.class);
        startActivity(intent);
    }
}
