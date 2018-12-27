package com.fardoushlab.newsviews.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.fardoushlab.newsviews.fragments.FirstPageFragment;
import com.fardoushlab.newsviews.fragments.SecondPageFragment;
import com.fardoushlab.newsviews.fragments.ThirdPageFragment;

public class IntroPagerAdapter extends FragmentStatePagerAdapter {
    public IntroPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        switch (i){
            case  0:
                fragment = new FirstPageFragment();
                break;
            case 1:
                fragment = new SecondPageFragment();
                break;
            case 2:
                fragment = new ThirdPageFragment();
                break;
            default:


        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
