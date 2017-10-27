package com.jesperqvarfordt.domain.model;

import java.util.Date;

public class Tweet implements Comparable<Tweet> {

    private User author;
    private String message;
    private Date date;

    public Tweet() {}

    public Tweet(User author, String message, Date date) {
        this.author = author;
        this.message = message;
        this.date = date;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "author=" + author +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public int compareTo(Tweet tweet) {
        return getDate().compareTo(tweet.getDate());
    }
}
