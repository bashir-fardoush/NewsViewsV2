package com.fardoushlab.newsviews.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.fardoushlab.newsviews.R;
import com.fardoushlab.newsviews.adapters.HomePagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.home_viewpager)
     ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        HomePagerAdapter pagerAdapter = new HomePagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(pagerAdapter);



    }
}
