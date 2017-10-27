package com.jesperqvarfordt.tweetbeat.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jesperqvarfordt.domain.model.Tweet;
import com.jesperqvarfordt.tweetbeat.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.ViewHolder> {

    private List<Tweet> tweets = new ArrayList<>();
    private Context context;

    public TweetAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_tweet_row, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.onBind(tweets.get(position));
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    public void addAll(List<Tweet> tweets) {
        for(Tweet tweet : tweets) {
            boolean exists = false;
            for(Tweet tweet1 : this.tweets)  {
                if(tweet.getMessage().equals(tweet1.getMessage())) {
                   exists = true;
                }
            }
            if(!exists) {
                this.tweets.add(0, tweet);
            }
        }
        Collections.sort(this.tweets);
        Collections.reverse(this.tweets);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView handle;
        private ImageView image;
        private TextView message;
        private TextView date;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            handle = itemView.findViewById(R.id.handle);
            image = itemView.findViewById(R.id.image);
            message = itemView.findViewById(R.id.message);
            date = itemView.findViewById(R.id.date);
        }

        void onBind(Tweet tweet) {
            name.setText(tweet.getAuthor().getUserName());
            handle.setText(tweet.getAuthor().getUserHandle());
            message.setText(tweet.getMessage());

            Glide.with(context)
                    .load(tweet.getAuthor().getImageUrl())
                    .apply(RequestOptions.circleCropTransform())
                    .into(image);

            String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(tweet.getDate());
            date.setText(formattedDate);
        }
    }
}
