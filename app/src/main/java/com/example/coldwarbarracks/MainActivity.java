package com.example.coldwarbarracks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
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
import android.widget.TextView;
import android.widget.Toast;

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

        final TextView tv_countdown = findViewById(R.id.countdownText);

        final Button primaryWeaponsButton = findViewById(R.id.primaryWeaponsButton);
        final Button secondaryWeaponsButton = findViewById(R.id.secondaryWeaponsButton);
        final Button equipmentButton = findViewById(R.id.equipmentButton);
        final Button perksButton = findViewById(R.id.perksButton);
        final Button wildcardsButton = findViewById(R.id.wildcardsButton);
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
        wildcardsButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    wildcardsButton.startAnimation(scaleUp);
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    wildcardsButton.startAnimation(scaleDown);
                }

                startActivity(new Intent(MainActivity.this, Wildcards.class));

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

        //get display height
        int height = Resources.getSystem().getDisplayMetrics().heightPixels;
        //calculate suitable top margin size for buttons
        int margin = (height - 600) / 30;

        //Toast.makeText(getApplicationContext(), Integer.toString(margin),Toast.LENGTH_LONG).show();

        //set button top margins, this is so buttons are spaced out more depending on size of screen
        ((ConstraintLayout.LayoutParams) secondaryWeaponsButton.getLayoutParams()).topMargin = margin;
        ((ConstraintLayout.LayoutParams) equipmentButton.getLayoutParams()).topMargin = margin;
        ((ConstraintLayout.LayoutParams) perksButton.getLayoutParams()).topMargin = margin;
        ((ConstraintLayout.LayoutParams) wildcardsButton.getLayoutParams()).topMargin = margin;
        ((ConstraintLayout.LayoutParams) scorestreaksButton.getLayoutParams()).topMargin = margin;


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