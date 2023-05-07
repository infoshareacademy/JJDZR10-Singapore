package com.singapore.TripPlaner.Model;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Opinion extends PersistentAbstract {

    private String userOpinion;
    private Integer userRate;
    private User user = new User();

    public Opinion() {
    }

    public Opinion(String userOpinion, Integer userRate, User user) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Opinion opinion = (Opinion) o;
        return Objects.equals(userOpinion, opinion.userOpinion) && Objects.equals(userRate, opinion.userRate) && Objects.equals(user, opinion.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userOpinion, userRate, user);
    }
}
