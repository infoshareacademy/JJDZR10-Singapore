package com.singapore.TripPlaner.Model;


import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Opinion extends PersistentAbstract {

    private String userOpinion;
    private Integer userRate;
    private Double objectRate;
    private List<Integer> ratingsList;

    private Integer id_user;
    private User user;
    public User getUser() {
        return user;
    }

    public String getUserOpinion() {
        return userOpinion;
    }


    public Integer getUserRate() {
        return userRate;
    }

    public void setUserRate(Integer userRate) {
        this.userRate = userRate;
    }

    public Double getObjectRate() {
        return objectRate;
    }

    public void setObjectRate(Double objectRate) {
        this.objectRate = objectRate;
    }

    public List<Integer> getRatingsList() {
        return ratingsList;
    }

    public void setRatingsList(List<Integer> ratingsList) {
        this.ratingsList = ratingsList;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserOpinion(String userOpinion) {
        this.userOpinion = userOpinion;
    }

    @Override
    public String toString() {
        return "Opinion{" +
                "userOpinion='" + userOpinion + '\'' +
                ", userRate=" + userRate +
                ", objectRate=" + objectRate +
                ", ratingsList=" + ratingsList +
                ", id_user=" + id_user +
                ", user=" + user +
                '}';
    }
}
