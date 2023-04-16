package com.singapore.TripPlaner.Model;

import org.springframework.stereotype.Component;

@Component
public class Opinion extends PersistentAbstract {

    private String userOpinion;
    private Integer userRate;
    private User user = new User();

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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
