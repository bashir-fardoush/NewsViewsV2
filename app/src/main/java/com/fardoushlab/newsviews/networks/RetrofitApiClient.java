package com.fardoushlab.newsviews.networks;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApiClient  {
    private static Retrofit retrofit = null;
    private static Gson gson = new GsonBuilder().setLenient().create();
    public static final String BASE_URL = "https://newsapi.org/";

    private RetrofitApiClient() {
    }
    public static Retrofit getApiClient(){
        if (retrofit == null){
              synchronized (RetrofitApiClient.class){
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
            }

        }

        return retrofit;
    }
}
