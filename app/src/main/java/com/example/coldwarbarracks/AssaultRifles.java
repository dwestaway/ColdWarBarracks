package com.example.coldwarbarracks;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Adapter;

import java.util.ArrayList;

public class AssaultRifles extends AppCompatActivity {

    private ActionBar actionBar;

    private ViewPager viewPager;

    private ArrayList<MyModel> modelArrayList;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assault_rifles);

        actionBar = getSupportActionBar();

        viewPager = findViewById(R.id.viewPager);
        loadCards();

    }

    private void loadCards() {
        //init list

        modelArrayList = new ArrayList<>();

        //add items to list
        modelArrayList.add(new MyModel(
                getString(R.string.XM4),
                R.drawable.xm4));
        modelArrayList.add(new MyModel(
                getString(R.string.AK47),
                R.drawable.ak47));
        modelArrayList.add(new MyModel(
                getString(R.string.Krig6),
                R.drawable.krig6));
        modelArrayList.add(new MyModel(
                getString(R.string.QBZ83),
                R.drawable.qbz83));

        //setup adapter
        myAdapter = new MyAdapter(this, modelArrayList);
        //set adapter to view pager
        viewPager.setAdapter(myAdapter);
        //set default padding from left/right
        viewPager.setPadding(100, 0, 100, 0);
    }
}