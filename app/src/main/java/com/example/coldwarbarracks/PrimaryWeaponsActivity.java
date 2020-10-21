package com.example.coldwarbarracks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class PrimaryWeaponsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary_weapons);

        final TextView tv_countdown = findViewById(R.id.countdownText);

        Button assaultRifles = findViewById(R.id.assaultRiflesButton);
        Button back = findViewById(R.id.backButton);

        assaultRifles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrimaryWeaponsActivity.this, AssaultRifles.class));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrimaryWeaponsActivity.this, MainActivity.class));
            }
        });

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