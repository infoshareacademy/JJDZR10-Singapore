package com.singapore.TripPlaner.Model;

public class Opinion extends PersistentAbstract {

    private String userOpinion;
    private int userRate;
    private String user = "Singapore";

    public Opinion() {
    }
    public Opinion(String userOpinion, Integer userRate, String user) {
        this.userOpinion = userOpinion;
        this.userRate = userRate;
        this.user = user;
    }

    public String getUserOpinion() {
        return userOpinion;
    }

    public void setUserOpinion(String userOpinion) {
        this.userOpinion = userOpinion;
    }

    public int getUserRate() {
        return userRate;
    }

    public void setUserRate(int userRate) {
        this.userRate = userRate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}