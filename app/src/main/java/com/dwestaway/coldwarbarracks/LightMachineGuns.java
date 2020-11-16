package com.dwestaway.coldwarbarracks;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class LightMachineGuns extends AppCompatActivity {

    private ActionBar actionBar;

    private ViewPager viewPager;

    private ArrayList<MyModel> modelArrayList;
    private MyAdapter myAdapter;

    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_machine_guns);

        viewPager = findViewById(R.id.viewPager);
        loadCards();

        ImageButton backButton = findViewById(R.id.buttonBack);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LightMachineGuns.this,PrimaryWeaponsActivity.class));
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

    private void loadCards() {
        //init list

        modelArrayList = new ArrayList<>();

        //add items to list
        modelArrayList.add(new MyModel("Stoner 63",
                getString(R.string.Stoner_63),
                "Damage: 32 \t TTK: 332ms \nFire rate: 722rpm \t Range: 51m",
                R.drawable.stoner63,
                R.drawable.stoner63_stats));
        modelArrayList.add(new MyModel("RPD",
                getString(R.string.RPD),
                "Damage: 35 \t TTK: 368ms \nFire rate: 652rpm \t Range: 51m",
                R.drawable.rpd,
                R.drawable.rpd_stats));
        modelArrayList.add(new MyModel("M60",
                getString(R.string.M60),
                "Damage: 50 \t TTK: 232ms \nFire rate: 517rpm \t Range: 51m",
                R.drawable.m60,
                R.drawable.m60_stats));

        //setup adapter
        myAdapter = new MyAdapter(this, modelArrayList);
        //set adapter to view pager
        viewPager.setAdapter(myAdapter);
        //set default padding from left/right
        viewPager.setPadding(100, 0, 100, 0);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(LightMachineGuns.this, PrimaryWeaponsActivity.class));
    }
}