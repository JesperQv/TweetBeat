package com.jesperqvarfordt.tweetbeat.dagger;

import com.google.firebase.firestore.FirebaseFirestore;
import com.jesperqvarfordt.data.DummyUserService;
import com.jesperqvarfordt.data.FirebaseTweetService;
import com.jesperqvarfordt.domain.service.TweetService;
import com.jesperqvarfordt.domain.service.UserService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ServiceModule {

    @Provides
    @Singleton
    TweetService provideTweetService(FirebaseFirestore firestore) {
        return new FirebaseTweetService(firestore);
    }

    @Provides
    @Singleton
    UserService provideUserService() {
        return new DummyUserService();
    }

}
