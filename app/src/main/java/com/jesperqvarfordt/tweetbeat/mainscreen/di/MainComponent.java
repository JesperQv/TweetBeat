package com.jesperqvarfordt.tweetbeat.mainscreen.di;

import com.jesperqvarfordt.tweetbeat.dagger.AppComponent;
import com.jesperqvarfordt.tweetbeat.dagger.ViewScope;
import com.jesperqvarfordt.tweetbeat.mainscreen.MainActivity;

import dagger.Component;

@ViewScope
@Component(dependencies = AppComponent.class, modules = MainModule.class)
public interface MainComponent {

    void inject(MainActivity activity);

}
