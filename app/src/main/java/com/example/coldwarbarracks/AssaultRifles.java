package com.example.coldwarbarracks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class AssaultRifles extends AppCompatActivity {

    private ActionBar actionBar;

    private ViewPager viewPager;

    private ArrayList<MyModel> modelArrayList;

    private MyAdapter myAdapter;

    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assault_rifles);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        viewPager = findViewById(R.id.viewPager);

        loadCards();


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

        switch (item.getItemId()) {case android.R.id.home:onBackPressed();break;}

        return super.onOptionsItemSelected(item);
    }

    private void loadCards() {
        //init list

        modelArrayList = new ArrayList<>();

        //add items to list
        modelArrayList.add(new MyModel("XM4",
                getString(R.string.XM4),
                R.drawable.xm4,
                R.drawable.xm4_stats));
        modelArrayList.add(new MyModel("AK47",
                getString(R.string.AK47),
                R.drawable.ak47,
                R.drawable.ak47_stats));
        modelArrayList.add(new MyModel("Krig 6",
                getString(R.string.Krig6),
                R.drawable.krig6,
                R.drawable.krig6_stats));
        modelArrayList.add(new MyModel("QBZ-83",
                getString(R.string.QBZ83),
                R.drawable.qbz83,
                R.drawable.qbz83_stats));


        //setup adapter
        myAdapter = new MyAdapter(this, modelArrayList);
        //set adapter to view pager
        viewPager.setAdapter(myAdapter);
        //set default padding from left/right
        viewPager.setPadding(100, 0, 100, 0);

    }
}