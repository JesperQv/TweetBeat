package com.jesperqvarfordt.tweetbeat.dagger;

import com.jesperqvarfordt.tweetbeat.TweetBeatApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private TweetBeatApplication app;

    public AppModule(TweetBeatApplication app) {
        this.app = app;
    }

    @Provides
    @Singleton
    TweetBeatApplication provideApp() {
        return app;
    }
}
