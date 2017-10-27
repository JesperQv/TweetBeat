package com.jesperqvarfordt.domain.service;

import com.jesperqvarfordt.domain.model.User;

import io.reactivex.Single;

public interface UserService {

    Single<User> getLoggedInUser();

}
