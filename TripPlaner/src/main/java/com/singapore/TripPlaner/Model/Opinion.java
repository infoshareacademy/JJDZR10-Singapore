package com.singapore.TripPlaner.Model;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Opinion extends PersistentAbstract {

    private String userOpinion;
    private Integer userRate;
    private String user = "Singapore";

    public Opinion() {
    }

    public Opinion(String userOpinion, Integer userRate, String user) {
        this.userOpinion = userOpinion;
        this.userRate = userRate;
        this.user = user;
    }

    public Opinion(Integer userRate) {
        this.userRate = userRate;
    }

    public String getUserOpinion() {
        return userOpinion;
    }

    public void setUserOpinion(String userOpinion) {
        this.userOpinion = userOpinion;
    }

    public Integer getUserRate() {
        return userRate;
    }

    public void setUserRate(Integer userRate) {
        this.userRate = userRate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Opinion{" +
                "userOpinion='" + userOpinion + '\'' +
                ", userRate=" + userRate +
                ", user=" + user +
                '}';
    }
}