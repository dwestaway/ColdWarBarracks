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

public class TacticalRifles extends AppCompatActivity {

    private ActionBar actionBar;

    private ViewPager viewPager;

    private ArrayList<MyModel> modelArrayList;
    private MyAdapter myAdapter;

    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tactical_rifles);

        viewPager = findViewById(R.id.viewPager);
        loadCards();

        ImageButton backButton = findViewById(R.id.buttonBack);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TacticalRifles.this,PrimaryWeaponsActivity.class));
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
        modelArrayList.add(new MyModel("Type 63",
                getString(R.string.Type_63),
                "Damage: 68 \t TTK: 400ms \nFire rate: 300rpm \t Range: 51m",
                R.drawable.type63,
                R.drawable.type63_stats));
        modelArrayList.add(new MyModel("M16",
                getString(R.string.M16),
                "Damage: 50 \t TTK: 132ms \nFire rate: 909rpm \t Range: 24m",
                R.drawable.m16,
                R.drawable.m16_stats));
        modelArrayList.add(new MyModel("AUG",
                getString(R.string.AUG),
                "Damage: 54 \t TTK: 140ms \nFire rate: 857rpm \t Range: 38m",
                R.drawable.aug,
                R.drawable.aug_stats));
        modelArrayList.add(new MyModel("DMR 14",
                getString(R.string.DMR_14),
                "Damage: 58 \t TTK: 332ms \nFire rate: 361rpm \t Range: 51m",
                R.drawable.dmr14,
                R.drawable.dmr14_stats));

        //setup adapter
        myAdapter = new MyAdapter(this, modelArrayList);
        //set adapter to view pager
        viewPager.setAdapter(myAdapter);
        //set default padding from left/right
        viewPager.setPadding(100, 0, 100, 0);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(TacticalRifles.this, PrimaryWeaponsActivity.class));
    }
}