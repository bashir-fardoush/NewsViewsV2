package com.fardoushlab.newsviews.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.fardoushlab.newsviews.R;
import com.fardoushlab.newsviews.adapters.NewsAdapter;
import com.fardoushlab.newsviews.models.News;
import com.fardoushlab.newsviews.networks.ApiInterface;
import com.fardoushlab.newsviews.networks.RetrofitApiClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsListActivity extends AppCompatActivity {
    private static final String TAG = "_"+ NewsListActivity.class.getSimpleName();
    private   NewsAdapter newsAdapter = null;
    private Context context;

    @BindView(R.id.rv_newsList)
    RecyclerView newsListRv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        ButterKnife.bind(this);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        newsListRv.setLayoutManager(manager);
        context = this;

        ApiInterface apiInterface = RetrofitApiClient.getApiClient().create(ApiInterface.class);

        Call<News> newsCall = apiInterface.getNews();
        newsCall.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                Log.d(TAG, "onResponse: "+response.code());

                if (response.code() == 200){
                    newsAdapter = new NewsAdapter(context, response.body().getArticles());
                    newsListRv.setAdapter(newsAdapter);
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());

            }
        });


    }
}
