package com.jesperqvarfordt.tweetbeat.dagger;

import com.jesperqvarfordt.domain.interactor.AddTweetUseCase;
import com.jesperqvarfordt.domain.interactor.ListenToTweetsUseCase;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, FirebaseModule.class, ServiceModule.class, InteractorModule.class})
public interface AppComponent {

    ListenToTweetsUseCase listenToTweetsUseCase();

    AddTweetUseCase addTweetUseCase();

}
