package com.fardoushlab.newsviews.activities;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fardoushlab.newsviews.R;
import com.fardoushlab.newsviews.adapters.IntroPagerAdapter;


public class IntroActivity extends AppCompatActivity {

    private ViewPager mImageViewPager;
    private TabLayout mTablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        mImageViewPager = findViewById(R.id.pager);
        mTablayout =  findViewById(R.id.tabDots);

        mTablayout.setupWithViewPager(mImageViewPager, true);

       // FragmentManager manager = getSupportFragmentManager();
        IntroPagerAdapter pagerAdapter = new IntroPagerAdapter(getSupportFragmentManager());
        mImageViewPager.setAdapter(pagerAdapter);


        pagerAdapter.getItem(2);
    }
}
