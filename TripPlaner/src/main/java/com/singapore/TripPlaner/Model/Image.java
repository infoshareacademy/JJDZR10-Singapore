package com.singapore.TripPlaner.Model;


public class Image extends PersistentAbstract {
    private String url;
    private User user;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}