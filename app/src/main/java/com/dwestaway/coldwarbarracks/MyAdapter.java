package com.dwestaway.coldwarbarracks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class MyAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<MyModel> modelArrayList;

    //constructor
    public MyAdapter(Context context, ArrayList<MyModel> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }



    @Override
    public int getCount() {

        return modelArrayList.size(); //size of items in list
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        //inflate layout card.xml
        View view = LayoutInflater.from(context).inflate(R.layout.card, container, false);

        //init uid views from card.xml
        TextView cardTitle = view.findViewById(R.id.cardTitle);
        TextView cardDesc = view.findViewById(R.id.cardDesc);
        TextView cardDamage = view.findViewById(R.id.cardDamage);

        ImageView cardIv = view.findViewById(R.id.cardIv);
        ImageView statsIv = view.findViewById(R.id.statsIv);

        //get data
        MyModel model = modelArrayList.get(position);
        String title = model.getTitle();
        String description = model.getDescription();
        String damage = model.getDamage();

        int image = model.getImage();
        int stats = model.getStats();

        //set data
        cardTitle.setText(title);
        cardDesc.setText(description);
        cardDamage.setText(damage);

        cardIv.setImageResource(image);
        statsIv.setImageResource(stats);

        //add view to container
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
