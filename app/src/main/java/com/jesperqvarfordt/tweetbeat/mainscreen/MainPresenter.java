package com.jesperqvarfordt.tweetbeat.mainscreen;

import com.jesperqvarfordt.domain.interactor.AddTweetUseCase;
import com.jesperqvarfordt.domain.interactor.ListenToTweetsUseCase;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class MainPresenter implements MainContract.Presenter {

    private final MainContract.View view;
    private final ListenToTweetsUseCase listenToTweetsUseCase;
    private final AddTweetUseCase addTweetUseCase;
    private CompositeDisposable disposables;

    @Inject
    public MainPresenter(MainContract.View view,
                         ListenToTweetsUseCase listenToTweetsUseCase,
                         AddTweetUseCase addTweetUseCase) {
        this.view = view;
        this.listenToTweetsUseCase = listenToTweetsUseCase;
        this.addTweetUseCase = addTweetUseCase;
        disposables = new CompositeDisposable();
    }

    @Override
    public void subscribe() {
        listenToTweets();
    }

    @Override
    public void unsubscribe() {
        disposables.clear();
    }

    @Override
    public void addTweet(String tweet) {
        disposables.add(addTweetUseCase.execute(tweet).subscribe());
    }

    private void listenToTweets() {
        listenToTweetsUseCase.execute()
                .subscribe(view::addTweetsToList);
    }
}
