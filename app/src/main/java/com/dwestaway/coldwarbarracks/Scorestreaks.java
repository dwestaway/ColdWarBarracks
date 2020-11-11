package com.dwestaway.coldwarbarracks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class Scorestreaks extends AppCompatActivity {

    private ActionBar actionBar;

    private ViewPager viewPager;

    private ArrayList<MyModel> modelArrayList;

    private MyAdapter myAdapter;

    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assault_rifles);

        viewPager = findViewById(R.id.viewPager);
        loadCards();

        ImageButton backButton = findViewById(R.id.buttonBack);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Scorestreaks.this,MainActivity.class));
            }
        });

        //initialize banner ad
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    //handle back button
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == android.R.id.home)
        {
            startActivity(new Intent(Scorestreaks.this,MainActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadCards() {
        //init list

        modelArrayList = new ArrayList<>();

        //add items to list
        modelArrayList.add(new MyModel("RC-XD",
                getString(R.string.RCXD),
                "",
                R.drawable.rcxd,
                0));
        modelArrayList.add(new MyModel("Spy Plane",
                getString(R.string.SpyPlane),
                "",
                R.drawable.spyplane,
                0));
        modelArrayList.add(new MyModel("Counter Spy Plane",
                getString(R.string.CounterSpyPlane),
                "",
                R.drawable.counterspyplane,
                0));
        modelArrayList.add(new MyModel("Sentry Turret",
                getString(R.string.SentryTurret),
                "",
                R.drawable.sentry,
                0));
        modelArrayList.add(new MyModel("Napalm Strike",
                getString(R.string.NapalmStrike),
                "",
                R.drawable.napalm,
                0));
        modelArrayList.add(new MyModel("Artillery",
                getString(R.string.Artillery),
                "",
                R.drawable.artillery,
                0));
        modelArrayList.add(new MyModel("Air Patrol",
                getString(R.string.AirPatrol),
                "",
                R.drawable.airpatrol,
                0));
        modelArrayList.add(new MyModel("War Machine",
                getString(R.string.WarMachine),
                "",
                R.drawable.warmachine,
                0));
        modelArrayList.add(new MyModel("Attack Helicopter",
                getString(R.string.AttackHelicopter),
                "",
                R.drawable.attackhelicopter,
                0));
        modelArrayList.add(new MyModel("Chopper Gunner",
                getString(R.string.ChopperGunner),
                "",
                R.drawable.choppergunner,
                0));


        //setup adapter
        myAdapter = new MyAdapter(this, modelArrayList);
        //set adapter to view pager
        viewPager.setAdapter(myAdapter);
        //set default padding from left/right
        viewPager.setPadding(100, 0, 100, 0);

    }
}