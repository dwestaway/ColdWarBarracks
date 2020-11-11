package com.dwestaway.coldwarbarracks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    AdView mAdView;

    Animation scaleUp, scaleDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //disable colour changes when night mode is enabled on device
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);


        final Button primaryWeaponsButton = findViewById(R.id.primaryWeaponsButton);
        final Button secondaryWeaponsButton = findViewById(R.id.secondaryWeaponsButton);
        final Button equipmentButton = findViewById(R.id.equipmentButton);
        final Button perksButton = findViewById(R.id.perksButton);
        final Button scorestreaksButton = findViewById(R.id.scorestreaksButton);

        //load animations
        scaleUp = AnimationUtils.loadAnimation(this,R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this,R.anim.scale_down);


        //initialize buttons and set animations
        primaryWeaponsButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    primaryWeaponsButton.startAnimation(scaleUp);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    primaryWeaponsButton.startAnimation(scaleDown);
                }

                startActivity(new Intent(MainActivity.this, PrimaryWeaponsActivity.class));

                return true;
            }
        });
        secondaryWeaponsButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    secondaryWeaponsButton.startAnimation(scaleUp);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    secondaryWeaponsButton.startAnimation(scaleDown);
                }

                startActivity(new Intent(MainActivity.this, SecondaryWeapons.class));

                return true;
            }
        });
        equipmentButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    equipmentButton.startAnimation(scaleUp);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    equipmentButton.startAnimation(scaleDown);
                }

                startActivity(new Intent(MainActivity.this, Equipment.class));

                return true;
            }
        });
        perksButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    perksButton.startAnimation(scaleUp);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    perksButton.startAnimation(scaleDown);
                }

                startActivity(new Intent(MainActivity.this, Perks.class));

                return true;
            }
        });
        scorestreaksButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    scorestreaksButton.startAnimation(scaleUp);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    scorestreaksButton.startAnimation(scaleDown);
                }

                startActivity(new Intent(MainActivity.this, Scorestreaks.class));

                return true;
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




}