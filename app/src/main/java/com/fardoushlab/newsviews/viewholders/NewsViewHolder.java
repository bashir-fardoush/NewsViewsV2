package com.fardoushlab.newsviews.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fardoushlab.newsviews.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsViewHolder extends RecyclerView.ViewHolder {
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
    @BindView(R.id.iv_news)
    public ImageView newsIv;

    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
