package com.enigma.jeekay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.navigation.NavigationView;

public class Bookings extends AppCompatActivity implements OnMapReadyCallback, NavigationView.OnNavigationItemSelectedListener {


    private GoogleMap mMap;
    private Toolbar mToolbar;
    private DrawerLayout mdrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings);

        mToolbar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);

        mdrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mdrawerLayout, R.string.open, R.string.close);

        mdrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng dvg = new LatLng(12.9767, 77.5713);
        mMap.addMarker(new MarkerOptions().position(dvg).title("Marker in Bangalore"));
        float ZoomLevel = 16.0f;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(dvg, ZoomLevel));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_user_profile) {
            Intent i = new Intent(this, UserProfile.class);
            startActivity(i);
        } else if (id == R.id.nav_payments) {
            Intent j = new Intent(this, Payments.class);
            startActivity(j);
        } else if (id == R.id.nav_bookings) {
            Intent k = new Intent(this, Bookings.class);
            startActivity(k);
        } else if (id == R.id.nav_refer_and_earn) {
            Intent l = new Intent(this, ReferAndEarn.class);
            startActivity(l);
        } else if (id == R.id.nav_help) {
            Intent m = new Intent(this, Help.class);
            startActivity(m);
        } else if (id == R.id.nav_about_us) {
            Intent n = new Intent(this, AboutUs.class);
            startActivity(n);
        } else if (id == R.id.nav_terms_and_conditions) {
            Intent o = new Intent(this, TermsAndCondition.class);
            startActivity(o);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
