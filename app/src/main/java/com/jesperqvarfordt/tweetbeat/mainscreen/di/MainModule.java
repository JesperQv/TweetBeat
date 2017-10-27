package com.jesperqvarfordt.tweetbeat.mainscreen.di;

import com.jesperqvarfordt.domain.interactor.AddTweetUseCase;
import com.jesperqvarfordt.domain.interactor.ListenToTweetsUseCase;
import com.jesperqvarfordt.tweetbeat.dagger.ViewScope;
import com.jesperqvarfordt.tweetbeat.mainscreen.MainContract;
import com.jesperqvarfordt.tweetbeat.mainscreen.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private MainContract.View view;

    public MainModule(MainContract.View view) {
        this.view = view;
    }

    @Provides
    @ViewScope
    public MainContract.View provideView() {
        return view;
    }

    @Provides
    @ViewScope
    public MainContract.Presenter providePresenter(ListenToTweetsUseCase listenToTweetsUseCase,
                                                   AddTweetUseCase addTweetUseCase) {
        return new MainPresenter(view, listenToTweetsUseCase, addTweetUseCase);
    }
}
