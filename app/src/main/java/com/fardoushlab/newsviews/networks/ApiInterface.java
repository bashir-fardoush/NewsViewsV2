package com.fardoushlab.newsviews.networks;

import com.fardoushlab.newsviews.models.News;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("v2/top-headlines?sources=abc-news,bbc-news,hacker-news," +
            "ign,mirror,techcrunch,time,reuters,rt,espn&pageSize=40&apiKey=4a581db2698f4757978ae30cede9e527")
    Call<News> getNews();

}
