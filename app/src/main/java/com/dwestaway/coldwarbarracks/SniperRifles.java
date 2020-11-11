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

public class SniperRifles extends AppCompatActivity {

    private ActionBar actionBar;

    private ViewPager viewPager;

    private ArrayList<MyModel> modelArrayList;
    private MyAdapter myAdapter;

    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sniper_rifles);

        viewPager = findViewById(R.id.viewPager);
        loadCards();

        ImageButton backButton = findViewById(R.id.buttonBack);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SniperRifles.this,PrimaryWeaponsActivity.class));
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
        modelArrayList.add(new MyModel("Pelington 703",
                getString(R.string.Pelingtong703),
                "Damage: 110 \nFire rate: 54rpm \t Range: 127m",
                R.drawable.pelington703,
                R.drawable.pelington703_stats));
        modelArrayList.add(new MyModel("LW3 - Tundra",
                getString(R.string.LW3_Tundra),
                "Damage: 110 \nFire rate: 47rpm \t Range: 127m",
                R.drawable.lw3_tundra,
                R.drawable.lw3_tundra_stats));

        //setup adapter
        myAdapter = new MyAdapter(this, modelArrayList);
        //set adapter to view pager
        viewPager.setAdapter(myAdapter);
        //set default padding from left/right
        viewPager.setPadding(100, 0, 100, 0);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(SniperRifles.this, PrimaryWeaponsActivity.class));
    }
}