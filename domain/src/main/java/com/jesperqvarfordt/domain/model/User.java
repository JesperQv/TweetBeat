package com.jesperqvarfordt.domain.model;

public class User {

    private String userName;
    private String userHandle;
    private String imageUrl;

    public User() {
    }

    public User(String userName, String userHandle, String imageUrl) {
        this.userName = userName;
        this.userHandle = userHandle;
        this.imageUrl = imageUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserHandle() {
        return userHandle;
    }

    public void setUserHandle(String userHandle) {
        this.userHandle = userHandle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userHandle='" + userHandle + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
