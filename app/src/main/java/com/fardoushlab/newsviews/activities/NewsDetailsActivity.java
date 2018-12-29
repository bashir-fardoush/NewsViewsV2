package com.fardoushlab.newsviews.activities;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fardoushlab.newsviews.R;
import com.fardoushlab.newsviews.models.Article;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsDetailsActivity extends AppCompatActivity {
    @BindView(R.id.tv_title)
    public TextView titleTv;
    @BindView(R.id.tv_url)
    public TextView urlTv;
    @BindView(R.id.tv_article)
    public TextView articleTv;
    @BindView(R.id.tv_desc)
    public TextView descTv;
    @BindView(R.id.tv_author)
    public TextView authorTv;
    @BindView(R.id.tv_time)
    public TextView timeTv;
    @BindView(R.id.tv_content)
    public TextView contentTv;
    @BindView(R.id.iv_news)
    public ImageView newsIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        ButterKnife.bind(this);
        Article article = getIntent().getParcelableExtra("news_article");
        if (article != null){
            titleTv.setText(article.getTitle());
            urlTv.setText(article.getUrl());
            descTv.setText(article.getDescription());
            authorTv.setText(article.getAuthor());
            timeTv.setText(article.getPublishedAt());
            contentTv.setText(article.getContent());

            Picasso.get().load(article.getUrlToImage()).into(newsIv);

        }else {
            Toast.makeText(this, "Something wrong...", Toast.LENGTH_LONG).show();
        }
    }
}
