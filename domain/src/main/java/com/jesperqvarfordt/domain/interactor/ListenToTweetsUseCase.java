package com.jesperqvarfordt.domain.interactor;

import com.jesperqvarfordt.domain.model.Tweet;
import com.jesperqvarfordt.domain.service.TweetService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

public class ListenToTweetsUseCase {

    private TweetService service;
    private final Scheduler executionScheduler;
    private final Scheduler uiScheduler;

    public ListenToTweetsUseCase(TweetService service,
                                 Scheduler executionScheduler,
                                 Scheduler uiScheduler) {
        this.service = service;
        this.executionScheduler = executionScheduler;
        this.uiScheduler = uiScheduler;
    }

    public Observable<List<Tweet>> execute() {
        return service.listenToTweets()
                .subscribeOn(executionScheduler)
                .observeOn(uiScheduler);
    }

}
