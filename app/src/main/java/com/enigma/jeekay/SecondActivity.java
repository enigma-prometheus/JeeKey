package com.enigma.jeekay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class SecondActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mToolbar = (Toolbar)findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open,R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
     }

     @Override
     public boolean onOptionsItemSelected(MenuItem item){
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
     }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_user_profile){
//            Toast.makeText(this, "User Profile", Toast.LENGTH_LONG).show();
            Intent i = new Intent(this, UserProfile.class);
            startActivity(i);
        } else if (id == R.id.nav_payments){
//            Toast.makeText(this, "Payments", Toast.LENGTH_LONG).show();
            Intent j = new Intent(this, Payments.class);
            startActivity(j);
        } else if (id == R.id.nav_bookings){
            Intent k = new Intent(this, Bookings.class);
            startActivity(k);
        } else if (id == R.id.nav_refer_and_earn){
            Intent l = new Intent(this, ReferAndEarn.class);
            startActivity(l);
        } else if(id == R.id.nav_help){
            Intent m = new Intent(this , Help.class);
            startActivity(m);
        }else if (id == R.id.nav_about_us){
            Intent n = new Intent(this, AboutUs.class);
            startActivity(n);
        } else if (id == R.id.nav_terms_and_conditions){
            Intent o = new Intent(this, TermsAndCondition.class);
            startActivity(o);
        }

        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawerLayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
