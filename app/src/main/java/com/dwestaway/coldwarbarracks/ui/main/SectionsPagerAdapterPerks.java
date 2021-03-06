package com.dwestaway.coldwarbarracks.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import com.dwestaway.coldwarbarracks.Perks_fragment1;
import com.dwestaway.coldwarbarracks.Perks_fragment2;
import com.dwestaway.coldwarbarracks.Perks_fragment3;
import com.dwestaway.coldwarbarracks.Perks_fragment4;
import com.dwestaway.coldwarbarracks.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapterPerks extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_perks1, R.string.tab_text_perks2, R.string.tab_text_perks3, R.string.tab_text_perks4};
    private final Context mContext;

    public SectionsPagerAdapterPerks(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case  0:
                fragment = new Perks_fragment1();
                break;
            case  1:
                fragment = new Perks_fragment2();
                break;
            case  2:
                fragment = new Perks_fragment3();
                break;
            case  3:
                fragment = new Perks_fragment4();
                break;
        }

        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {

        //number of tabs
        return 4;
    }
}