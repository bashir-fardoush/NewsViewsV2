package com.fardoushlab.newsviews.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fardoushlab.newsviews.R;
import com.fardoushlab.newsviews.activities.NewsDetailsActivity;
import com.fardoushlab.newsviews.activities.NewsWebViewActivity;
import com.fardoushlab.newsviews.models.Article;
import com.fardoushlab.newsviews.viewholders.NewsViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {
    private Context context;
    private List<Article> mArticles;

    public NewsAdapter(Context context, List<Article> mArticles) {
        this.context = context;
        this.mArticles = mArticles;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_news_headline,viewGroup,false);
        return new NewsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, final int i) {
        holder.titleTv.setText(mArticles.get(i).getTitle());
        holder.urlTv.setText(mArticles.get(i).getUrl());
        holder.descTv.setText(mArticles.get(i).getDescription());
        holder.authorTv.setText(mArticles.get(i).getAuthor());
        holder.timeTv.setText(mArticles.get(i).getPublishedAt());
        // need image caching, temporarily image showing off
        //Picasso.get().load(mArticles.get(i).getUrlToImage()).into(holder.newsIv);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(context)
                        .setTitle("news title")
                        .setMessage("Would you like to see this news in browser mode?")
                        .setCancelable(false)
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Intent intent = new Intent(context,NewsWebViewActivity.class);
                                intent.putExtra("news_url",mArticles.get(i).getUrl());
                                context.startActivity(intent);


                            }
                        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Intent intent = new Intent(context,NewsDetailsActivity.class);
                                intent.putExtra("news_article",mArticles.get(i));
                                context.startActivity(intent);
                            }
                        }).create();

                dialog.show();


            }
        });


    }

    @Override
    public int getItemCount() {
        //return mArticles.size();
        return 12; // showing minimal cards
    }
}
