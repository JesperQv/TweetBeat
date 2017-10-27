package com.jesperqvarfordt.domain.interactor;

import com.jesperqvarfordt.domain.model.Tweet;
import com.jesperqvarfordt.domain.service.TweetService;
import com.jesperqvarfordt.domain.service.UserService;

import java.util.Date;

import io.reactivex.Completable;
import io.reactivex.Scheduler;

public class AddTweetUseCase {

    private final TweetService tweetService;
    private final UserService userService;
    private final Scheduler executionScheduler;
    private final Scheduler uiScheduler;

    public AddTweetUseCase(TweetService tweetService,
                           UserService userService,
                           Scheduler executionScheduler,
                           Scheduler uiScheduler) {
        this.tweetService = tweetService;
        this.userService = userService;
        this.executionScheduler = executionScheduler;
        this.uiScheduler = uiScheduler;
    }

    public Completable execute(final String message) {
        return userService.getLoggedInUser()
                .map(user -> new Tweet(user, message, new Date()))
                .flatMapCompletable(tweetService::addTweet)
                .subscribeOn(executionScheduler)
                .observeOn(uiScheduler);
    }
}
