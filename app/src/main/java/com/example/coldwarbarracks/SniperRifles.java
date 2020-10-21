package com.example.coldwarbarracks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class SniperRifles extends AppCompatActivity {

    private ActionBar actionBar;

    private ViewPager viewPager;

    private ArrayList<MyModel> modelArrayList;
    private MyAdapter myAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sniper_rifles);

        actionBar = getSupportActionBar();

        viewPager = findViewById(R.id.viewPager);
        loadCards();

        actionBar.setTitle("Sniper Rifles");
        actionBar.setDisplayHomeAsUpEnabled(true);

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
        modelArrayList.add(new MyModel(
                getString(R.string.Pelingtong703),
                R.drawable.pelington703,
                R.drawable.pelington703_stats));
        modelArrayList.add(new MyModel(
                getString(R.string.LW3_Tundra),
                R.drawable.lw3_tundra,
                R.drawable.lw3_tundra_stats));

        //setup adapter
        myAdapter = new MyAdapter(this, modelArrayList);
        //set adapter to view pager
        viewPager.setAdapter(myAdapter);
        //set default padding from left/right
        viewPager.setPadding(100, 0, 100, 0);
    }
}