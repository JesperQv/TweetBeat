package com.jesperqvarfordt.tweetbeat.mainscreen;

import com.jesperqvarfordt.domain.model.Tweet;

import java.util.List;

public interface MainContract {

    interface View {

        void addTweetsToList(List<Tweet> tweets);

    }

    interface Presenter {

        void subscribe();

        void unsubscribe();

        void addTweet(String tweet);

    }

}
