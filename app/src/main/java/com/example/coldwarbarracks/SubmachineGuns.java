package com.example.coldwarbarracks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class SubmachineGuns extends AppCompatActivity {

    private ActionBar actionBar;

    private ViewPager viewPager;

    private ArrayList<MyModel> modelArrayList;
    private MyAdapter myAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submachine_guns);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        viewPager = findViewById(R.id.viewPager);
        loadCards();


    }

    //handle back button
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == android.R.id.home)
        {
            startActivity(new Intent(SubmachineGuns.this,PrimaryWeaponsActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadCards() {
        //init list

        modelArrayList = new ArrayList<>();

        //add items to list
        modelArrayList.add(new MyModel("MP5",
                getString(R.string.MP5),
                R.drawable.mp5,
                R.drawable.mp5_stats));
        modelArrayList.add(new MyModel("Milano 821",
                getString(R.string.Milano_821),
                R.drawable.milano,
                R.drawable.milano_stats));
        modelArrayList.add(new MyModel("AK-74u",
                getString(R.string.AK74u),
                R.drawable.ak74u,
                R.drawable.ak74u_stats));
        modelArrayList.add(new MyModel("KSP 45",
                getString(R.string.KSP_45),
                R.drawable.ksp,
                R.drawable.ksp_stats));

        //setup adapter
        myAdapter = new MyAdapter(this, modelArrayList);
        //set adapter to view pager
        viewPager.setAdapter(myAdapter);
        //set default padding from left/right
        viewPager.setPadding(100, 0, 100, 0);
    }
}