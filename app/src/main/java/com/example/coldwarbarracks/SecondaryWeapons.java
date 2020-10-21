package com.example.coldwarbarracks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class SecondaryWeapons extends AppCompatActivity {

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

        actionBar.setTitle("Secondary Weapons");
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
                getString(R.string.pistol1911),
                R.drawable.pistol1911,
                R.drawable.pistol1911_stats));
        modelArrayList.add(new MyModel(
                getString(R.string.Diamatti),
                R.drawable.diamatti,
                R.drawable.diamatti_stats));
        modelArrayList.add(new MyModel(
                getString(R.string.Magnum),
                R.drawable.magnum,
                R.drawable.magnum_stats));
        modelArrayList.add(new MyModel(
                getString(R.string.Hauer77),
                R.drawable.hauer,
                R.drawable.hauer_stats));
        modelArrayList.add(new MyModel(
                getString(R.string.GalloSA12),
                R.drawable.gallo,
                R.drawable.gallo_stats));
        modelArrayList.add(new MyModel(
                getString(R.string.Cigma2),
                R.drawable.cigma,
                R.drawable.cigma_stats));
        modelArrayList.add(new MyModel(
                getString(R.string.RPG7),
                R.drawable.rpg,
                R.drawable.rpg_stats));
        modelArrayList.add(new MyModel(
                getString(R.string.Knife),
                R.drawable.knife,
                R.drawable.rpg_stats));


        //setup adapter
        myAdapter = new MyAdapter(this, modelArrayList);
        //set adapter to view pager
        viewPager.setAdapter(myAdapter);
        //set default padding from left/right
        viewPager.setPadding(100, 0, 100, 0);
    }
}