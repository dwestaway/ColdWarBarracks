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

        viewPager = findViewById(R.id.viewPager);
        loadCards();


        ImageButton backButton = findViewById(R.id.buttonBack);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondaryWeapons.this,MainActivity.class));
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
        modelArrayList.add(new MyModel("1911",
                getString(R.string.pistol1911),
                "Damage: 50 \t TTK: 300ms \nFire rate: 400rpm \t Range: 19m",
                R.drawable.pistol1911,
                R.drawable.pistol1911_stats));
        modelArrayList.add(new MyModel("Diamatti",
                getString(R.string.Diamatti),
                "Damage: 30 \t TTK: 216ms \nFire rate: 1111rpm \t Range: 25m",
                R.drawable.diamatti,
                R.drawable.diamatti_stats));
        modelArrayList.add(new MyModel("Magnum",
                getString(R.string.Magnum),
                "Damage: 75 \t TTK: 350ms \nFire rate: 171rpm \t Range: 15m",
                R.drawable.magnum,
                R.drawable.magnum_stats));
        modelArrayList.add(new MyModel("Hauer 77",
                getString(R.string.Hauer77),
                "Damage: 159 \t TTK: 0ms \nFire rate: 66rpm \t Range: 6m",
                R.drawable.hauer,
                R.drawable.hauer_stats));
        modelArrayList.add(new MyModel("Gallo SA12",
                getString(R.string.GalloSA12),
                "Damage: 118 \t TTK: 250ms \nFire rate: 240rpm \t Range: 6m",
                R.drawable.gallo,
                R.drawable.gallo_stats));
        modelArrayList.add(new MyModel("Cigma 2",
                getString(R.string.Cigma2),
                "",
                R.drawable.cigma,
                R.drawable.cigma_stats));
        modelArrayList.add(new MyModel("RPG-7",
                getString(R.string.RPG7),
                "",
                R.drawable.rpg,
                R.drawable.rpg_stats));
        modelArrayList.add(new MyModel("Knife",
                getString(R.string.Knife),
                "",
                R.drawable.knife,
                R.drawable.knife_stats));


        //setup adapter
        myAdapter = new MyAdapter(this, modelArrayList);
        //set adapter to view pager
        viewPager.setAdapter(myAdapter);
        //set default padding from left/right
        viewPager.setPadding(100, 0, 100, 0);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(SecondaryWeapons.this, MainActivity.class));
    }
}