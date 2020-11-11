package com.dwestaway.coldwarbarracks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class PrimaryWeaponsActivity extends AppCompatActivity {

    AdView mAdView;

    Animation scaleUp, scaleDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary_weapons);


        //initialize buttons
        final Button assaultRiflesButton = findViewById(R.id.assaultRiflesButton);
        final Button submachineGunsButton = findViewById(R.id.submachineGunsButton);
        final Button tacticalRiflesButton = findViewById(R.id.tacticalRiflesButton);
        final Button lightMachineGunsButton = findViewById(R.id.lightMachineGunsButton);
        final Button sniperRiflesButton = findViewById(R.id.sniperRiflesButton);
        final ImageButton backButton = findViewById(R.id.backButton);

        //load animations
        scaleUp = AnimationUtils.loadAnimation(this,R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this,R.anim.scale_down);

        //initialize buttons and set animations
        assaultRiflesButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    assaultRiflesButton.startAnimation(scaleUp);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    assaultRiflesButton.startAnimation(scaleDown);
                }

                startActivity(new Intent(PrimaryWeaponsActivity.this, AssaultRifles.class));

                return true;
            }
        });
        submachineGunsButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    submachineGunsButton.startAnimation(scaleUp);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    submachineGunsButton.startAnimation(scaleDown);
                }

                startActivity(new Intent(PrimaryWeaponsActivity.this, SubmachineGuns.class));

                return true;
            }
        });
        tacticalRiflesButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    tacticalRiflesButton.startAnimation(scaleUp);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    tacticalRiflesButton.startAnimation(scaleDown);
                }

                startActivity(new Intent(PrimaryWeaponsActivity.this, TacticalRifles.class));

                return true;
            }
        });
        lightMachineGunsButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    lightMachineGunsButton.startAnimation(scaleUp);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    lightMachineGunsButton.startAnimation(scaleDown);
                }

                startActivity(new Intent(PrimaryWeaponsActivity.this, LightMachineGuns.class));

                return true;
            }
        });
        sniperRiflesButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    sniperRiflesButton.startAnimation(scaleUp);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    sniperRiflesButton.startAnimation(scaleDown);
                }

                startActivity(new Intent(PrimaryWeaponsActivity.this, SniperRifles.class));

                return true;
            }
        });
        backButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    backButton.startAnimation(scaleUp);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    backButton.startAnimation(scaleDown);
                }

                startActivity(new Intent(PrimaryWeaponsActivity.this, MainActivity.class));

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

    @Override
    public void onBackPressed() {
        startActivity(new Intent(PrimaryWeaponsActivity.this, MainActivity.class));
    }




}