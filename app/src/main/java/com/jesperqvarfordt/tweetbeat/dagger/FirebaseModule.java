package com.jesperqvarfordt.tweetbeat.dagger;

import com.google.firebase.firestore.FirebaseFirestore;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class FirebaseModule {

    @Provides
    @Singleton
    FirebaseFirestore firebaseFirestore() {
        return FirebaseFirestore.getInstance();
    }

}
