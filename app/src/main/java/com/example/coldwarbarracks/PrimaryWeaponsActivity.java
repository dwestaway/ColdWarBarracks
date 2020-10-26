package com.example.coldwarbarracks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.res.Resources;
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

        final TextView tv_countdown = findViewById(R.id.countdownText);


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

        //get display height
        int height = Resources.getSystem().getDisplayMetrics().heightPixels;
        //calculate suitable top margin size for buttons
        int margin = (height - 600) / 30;

        //set button top margins, this is so buttons are spaced out more depending on size of screen
        ((ConstraintLayout.LayoutParams) submachineGunsButton.getLayoutParams()).topMargin = margin;
        ((ConstraintLayout.LayoutParams) tacticalRiflesButton.getLayoutParams()).topMargin = margin;
        ((ConstraintLayout.LayoutParams) lightMachineGunsButton.getLayoutParams()).topMargin = margin;
        ((ConstraintLayout.LayoutParams) sniperRiflesButton.getLayoutParams()).topMargin = margin;
        ((ConstraintLayout.LayoutParams) backButton.getLayoutParams()).topMargin = margin;


        //initialize banner ad
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        Calendar start_calendar = Calendar.getInstance();
        Calendar end_calendar = Calendar.getInstance();

        end_calendar.set(2020, 10, 13); // 10 = November, month start at 0 = January

        long start_millis = start_calendar.getTimeInMillis(); //get the start time in milliseconds
        long end_millis = end_calendar.getTimeInMillis(); //get the end time in milliseconds
        long total_millis = (end_millis - start_millis); //total time in milliseconds


        //1000 = 1 second interval
        CountDownTimer cdt = new CountDownTimer(total_millis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long days = TimeUnit.MILLISECONDS.toDays(millisUntilFinished);
                millisUntilFinished -= TimeUnit.DAYS.toMillis(days);

                long hours = TimeUnit.MILLISECONDS.toHours(millisUntilFinished);
                millisUntilFinished -= TimeUnit.HOURS.toMillis(hours);

                long minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished);
                millisUntilFinished -= TimeUnit.MINUTES.toMillis(minutes);

                long seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished);

                tv_countdown.setText(days + " days " + hours + " hours\n" + minutes + " minutes " + seconds + " seconds"); //You can compute the millisUntilFinished on hours/minutes/seconds
            }

            @Override
            public void onFinish() {
                tv_countdown.setText("Finish!");
            }
        };
        cdt.start();
    }




}