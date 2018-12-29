package com.fardoushlab.newsviews.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.fardoushlab.newsviews.R;

public class NewsWebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_news_web_view);
        WebView webView = new WebView(this);
        setContentView(webView);

       String url =  getIntent().getStringExtra("news_url");
        webView.loadUrl(url);

    }
}
