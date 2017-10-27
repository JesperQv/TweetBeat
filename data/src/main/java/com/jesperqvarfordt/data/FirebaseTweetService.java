package com.jesperqvarfordt.data;

import com.google.firebase.firestore.FirebaseFirestore;
import com.jesperqvarfordt.domain.model.Tweet;
import com.jesperqvarfordt.domain.service.TweetService;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public class FirebaseTweetService implements TweetService {

    private FirebaseFirestore db;

    public FirebaseTweetService(FirebaseFirestore db) {
        this.db = db;
    }

    @Override
    public Observable<List<Tweet>> listenToTweets() {
        return Observable.create(emitter -> db.collection("tweets")
                .addSnapshotListener((documentSnapshots, e) -> {
            List<Tweet> tweets = documentSnapshots.toObjects(Tweet.class);
            emitter.onNext(tweets);
        }));
    }

    @Override
    public Completable addTweet(final Tweet tweet) {
        return Completable.create(emitter -> db.collection("tweets").add(tweet)
                .addOnSuccessListener(documentReference -> emitter.onComplete())
                .addOnFailureListener(e -> emitter.onError(new Throwable(e))));
    }
}
