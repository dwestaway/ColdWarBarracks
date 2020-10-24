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

public class SecondaryWeapons extends AppCompatActivity {

    private ActionBar actionBar;

    private ViewPager viewPager;

    private ArrayList<MyModel> modelArrayList;
    private MyAdapter myAdapter;

    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary_weapons);

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
        modelArrayList.add(new MyModel("1911",
                getString(R.string.pistol1911),
                R.drawable.pistol1911,
                R.drawable.pistol1911_stats));
        modelArrayList.add(new MyModel("Diamatti",
                getString(R.string.Diamatti),
                R.drawable.diamatti,
                R.drawable.diamatti_stats));
        modelArrayList.add(new MyModel("Magnum",
                getString(R.string.Magnum),
                R.drawable.magnum,
                R.drawable.magnum_stats));
        modelArrayList.add(new MyModel("Hauer 77",
                getString(R.string.Hauer77),
                R.drawable.hauer,
                R.drawable.hauer_stats));
        modelArrayList.add(new MyModel("Gallo SA12",
                getString(R.string.GalloSA12),
                R.drawable.gallo,
                R.drawable.gallo_stats));
        modelArrayList.add(new MyModel("Cigma 2",
                getString(R.string.Cigma2),
                R.drawable.cigma,
                R.drawable.cigma_stats));
        modelArrayList.add(new MyModel("RPG-7",
                getString(R.string.RPG7),
                R.drawable.rpg,
                R.drawable.rpg_stats));
        modelArrayList.add(new MyModel("Knife",
                getString(R.string.Knife),
                R.drawable.knife,
                R.drawable.knife_stats));


        //setup adapter
        myAdapter = new MyAdapter(this, modelArrayList);
        //set adapter to view pager
        viewPager.setAdapter(myAdapter);
        //set default padding from left/right
        viewPager.setPadding(100, 0, 100, 0);
    }
}