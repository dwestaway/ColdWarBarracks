package com.dwestaway.coldwarbarracks;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.dwestaway.coldwarbarracks.ui.main.SectionsPagerAdapterPerks;
import com.google.android.material.tabs.TabLayout;

public class Perks extends AppCompatActivity {

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment);
        SectionsPagerAdapterPerks sectionsPagerAdapter = new SectionsPagerAdapterPerks(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);



    }
    //handle back button
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == android.R.id.home)
        {
            startActivity(new Intent(Perks.this,MainActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Perks.this, MainActivity.class));
    }
}