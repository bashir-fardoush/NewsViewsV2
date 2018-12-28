package com.fardoushlab.newsviews.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fardoushlab.newsviews.R;
import com.fardoushlab.newsviews.models.News;
import com.fardoushlab.newsviews.networks.ApiInterface;
import com.fardoushlab.newsviews.networks.RetrofitApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    private static final String TAG ="_"+ HomeFragment.class.getSimpleName() ;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ApiInterface apiInterface = RetrofitApiClient.getApiClient().create(ApiInterface.class);

        Call<News> newsCall = apiInterface.getNews();
       newsCall.enqueue(new Callback<News>() {
           @Override
           public void onResponse(Call<News> call, Response<News> response) {
               Log.d(TAG, "onResponse: code: "+response.code());
               Log.d(TAG, "onResponse: size: "+response.body().getTotalResults());
           }

           @Override
           public void onFailure(Call<News> call, Throwable t) {

               Log.d(TAG, "onFailure: "+t.getMessage());

           }
       });

    }
}
