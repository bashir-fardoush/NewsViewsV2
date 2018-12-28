package com.fardoushlab.newsviews.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.fardoushlab.newsviews.fragments.AboutFragment;
import com.fardoushlab.newsviews.fragments.HomeFragment;

public class HomePagerAdapter extends FragmentStatePagerAdapter {
    public HomePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        switch (i){
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new AboutFragment();
                default:


        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
