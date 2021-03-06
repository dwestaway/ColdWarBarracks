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

public class SubmachineGuns extends AppCompatActivity {

    private ActionBar actionBar;

    private ViewPager viewPager;

    private ArrayList<MyModel> modelArrayList;
    private MyAdapter myAdapter;

    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submachine_guns);

        viewPager = findViewById(R.id.viewPager);
        loadCards();

        ImageButton backButton = findViewById(R.id.buttonBack);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SubmachineGuns.this,PrimaryWeaponsActivity.class));
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
        modelArrayList.add(new MyModel("MP5",
                getString(R.string.MP5),
                "Damage: 32 \t TTK: 281ms \nFire rate: 857rpm \t Range: 15m",
                R.drawable.mp5,
                R.drawable.mp5_stats));
        modelArrayList.add(new MyModel("Milano 821",
                getString(R.string.Milano_821),
                "Damage: 42 \t TTK: 312ms \nFire rate: 576rpm \t Range: 13m",
                R.drawable.milano,
                R.drawable.milano_stats));
        modelArrayList.add(new MyModel("AK-74u",
                getString(R.string.AK74u),
                "Damage: 38 \t TTK: 259ms \nFire rate: 697rpm \t Range: 8m",
                R.drawable.ak74u,
                R.drawable.ak74u_stats));
        modelArrayList.add(new MyModel("KSP 45",
                getString(R.string.KSP_45),
                "Damage: 50 \t TTK: 166ms \nFire rate: 722rpm \t Range: 11m",
                R.drawable.ksp,
                R.drawable.ksp_stats));
        modelArrayList.add(new MyModel("Bullfrog",
                getString(R.string.Bullfrog),
                "Damage: 34 \t TTK: 320ms \nFire rate: 750rpm \t Range: 19m",
                R.drawable.bullfrog,
                R.drawable.bullfrog_stats));

        //setup adapter
        myAdapter = new MyAdapter(this, modelArrayList);
        //set adapter to view pager
        viewPager.setAdapter(myAdapter);
        //set default padding from left/right
        viewPager.setPadding(100, 0, 100, 0);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(SubmachineGuns.this, PrimaryWeaponsActivity.class));
    }
}