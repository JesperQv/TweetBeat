package com.jesperqvarfordt.data;

import com.jesperqvarfordt.domain.model.User;
import com.jesperqvarfordt.domain.service.UserService;

import io.reactivex.Single;

public class DummyUserService implements UserService {

    private User currentUser;

    public DummyUserService() {
        currentUser = new User("Test Testson",
                "@test",
                "https://lh3.googleusercontent.com/WccIkHxKBWqiFWJKINUbIgWztlAxY2nCzO3w208a6ho9iG03JVQejrsJDCMVu0JPCA=w300");
    }

    @Override
    public Single<User> getLoggedInUser() {
        return Single.fromCallable(() -> currentUser);
    }
}
