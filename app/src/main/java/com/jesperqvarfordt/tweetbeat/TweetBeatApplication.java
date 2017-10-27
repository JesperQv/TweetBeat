package com.jesperqvarfordt.tweetbeat;

import android.app.Application;

import com.jesperqvarfordt.tweetbeat.dagger.AppComponent;
import com.jesperqvarfordt.tweetbeat.dagger.AppModule;
import com.jesperqvarfordt.tweetbeat.dagger.DaggerAppComponent;
import com.jesperqvarfordt.tweetbeat.dagger.FirebaseModule;
import com.jesperqvarfordt.tweetbeat.dagger.InteractorModule;
import com.jesperqvarfordt.tweetbeat.dagger.ServiceModule;

public class TweetBeatApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .firebaseModule(new FirebaseModule())
                .interactorModule(new InteractorModule()).
                serviceModule(new ServiceModule())
                .build();
    }

    public AppComponent appComponent() {
        return appComponent;
    }
}
