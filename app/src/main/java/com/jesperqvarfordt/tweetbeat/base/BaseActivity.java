package com.jesperqvarfordt.tweetbeat.base;

import android.support.v7.app.AppCompatActivity;

import com.jesperqvarfordt.tweetbeat.TweetBeatApplication;
import com.jesperqvarfordt.tweetbeat.dagger.AppComponent;

public class BaseActivity extends AppCompatActivity {

    protected AppComponent appComponent() {
        return ((TweetBeatApplication)getApplication()).appComponent();
    }

}
