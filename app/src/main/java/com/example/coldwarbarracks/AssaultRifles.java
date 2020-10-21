package com.example.coldwarbarracks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class AssaultRifles extends AppCompatActivity {

    private ActionBar actionBar;

    private ViewPager viewPager;
    private ViewPager viewPager2;

    private ArrayList<MyModel> modelArrayList;
    private ArrayList<MyModel> modelArrayList2;

    private MyAdapter myAdapter;
    private MyAdapter myAdapter2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assault_rifles);

        actionBar = getSupportActionBar();

        viewPager = findViewById(R.id.viewPager);

        loadCards();

        actionBar.setTitle("Assault Rifles");
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
                getString(R.string.XM4),
                R.drawable.xm4,
                R.drawable.xm4_stats));
        modelArrayList.add(new MyModel(
                getString(R.string.AK47),
                R.drawable.ak47,
                R.drawable.ak47_stats));
        modelArrayList.add(new MyModel(
                getString(R.string.Krig6),
                R.drawable.krig6,
                R.drawable.krig6_stats));
        modelArrayList.add(new MyModel(
                getString(R.string.QBZ83),
                R.drawable.qbz83,
                R.drawable.qbz83_stats));


        //setup adapter
        myAdapter = new MyAdapter(this, modelArrayList);
        //set adapter to view pager
        viewPager.setAdapter(myAdapter);
        //set default padding from left/right
        viewPager.setPadding(100, 0, 100, 0);

    }
}