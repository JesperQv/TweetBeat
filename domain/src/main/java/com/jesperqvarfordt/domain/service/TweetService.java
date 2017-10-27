package com.jesperqvarfordt.domain.service;

import com.jesperqvarfordt.domain.model.Tweet;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface TweetService {

    Observable<List<Tweet>> listenToTweets();

    Completable addTweet(Tweet tweet);

}
