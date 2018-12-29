package com.fardoushlab.newsviews.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.fardoushlab.newsviews.R;
import com.fardoushlab.newsviews.activities.NewsListActivity;
import com.fardoushlab.newsviews.adapters.NewsAdapter;
import com.fardoushlab.newsviews.models.News;
import com.fardoushlab.newsviews.networks.ApiInterface;
import com.fardoushlab.newsviews.networks.RetrofitApiClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    private static final String TAG ="_"+ HomeFragment.class.getSimpleName() ;
    private Unbinder bind = null;

    @BindView(R.id.rv_home)
    public RecyclerView homeRv;
    @BindView(R.id.btn_show_more)
    public Button showMoreBtn;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
         bind = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ApiInterface apiInterface = RetrofitApiClient.getApiClient().create(ApiInterface.class);



        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
         manager.setOrientation(LinearLayoutManager.VERTICAL);
        homeRv.setLayoutManager(manager);


        Call<News> newsCall = apiInterface.getNews();
       newsCall.enqueue(new Callback<News>() {
           @Override
           public void onResponse(Call<News> call, Response<News> response) {
               Log.d(TAG, "onResponse: code: "+response.code());
               Log.d(TAG, "onResponse: size: "+response.body().getTotalResults());

               NewsAdapter newsAdapter = new NewsAdapter(getActivity(),response.body().getArticles());
               //
               homeRv.setAdapter(newsAdapter);
               response.body().getArticles();
           }

           @Override
           public void onFailure(Call<News> call, Throwable t) {

               Log.d(TAG, "onFailure: "+t.getMessage());

           }
       });




    }
    @OnClick(R.id.btn_show_more)
    void onShowMoreClicked(View view){
        startActivity(new Intent(getActivity(), NewsListActivity.class));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
