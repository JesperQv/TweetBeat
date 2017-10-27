package com.jesperqvarfordt.tweetbeat.dagger;

import com.jesperqvarfordt.domain.interactor.AddTweetUseCase;
import com.jesperqvarfordt.domain.interactor.ListenToTweetsUseCase;
import com.jesperqvarfordt.domain.service.TweetService;
import com.jesperqvarfordt.domain.service.UserService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module
public class InteractorModule {

    @Provides
    @Singleton
    AddTweetUseCase addTweetUseCase(TweetService tweetService, UserService userService) {
        return new AddTweetUseCase(tweetService, userService, Schedulers.io(), AndroidSchedulers.mainThread());
    }

    @Provides
    @Singleton
    ListenToTweetsUseCase listenToTweetsUseCase(TweetService tweetService) {
        return new ListenToTweetsUseCase(tweetService, Schedulers.io(), AndroidSchedulers.mainThread());
    }

}
