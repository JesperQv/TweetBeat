package com.jesperqvarfordt.tweetbeat.mainscreen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.jesperqvarfordt.domain.model.Tweet;
import com.jesperqvarfordt.tweetbeat.R;
import com.jesperqvarfordt.tweetbeat.adapter.TweetAdapter;
import com.jesperqvarfordt.tweetbeat.base.BaseActivity;
import com.jesperqvarfordt.tweetbeat.mainscreen.di.DaggerMainComponent;
import com.jesperqvarfordt.tweetbeat.mainscreen.di.MainModule;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainContract.View {

    private TweetAdapter adapter;

    @Inject
    MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton newTweetButton = findViewById(R.id.fab);
        RecyclerView recyclerView = findViewById(R.id.list);
        adapter = new TweetAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        DaggerMainComponent.builder()
                .appComponent(appComponent())
                .mainModule(new MainModule(this))
                .build()
                .inject(this);

        newTweetButton.setOnClickListener(view -> showNewTweetDialog());
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.subscribe();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.unsubscribe();
    }

    private void showNewTweetDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.alert_label_editor, null);
        dialogBuilder.setView(dialogView);

        EditText editText =  dialogView.findViewById(R.id.label_field);
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Tweet",
                (dialogInterface, i) -> presenter.addTweet(editText.getText().toString()));
        alertDialog.show();
    }

    @Override
    public void addTweetsToList(List<Tweet> tweets) {
        adapter.addAll(tweets);
    }
}
