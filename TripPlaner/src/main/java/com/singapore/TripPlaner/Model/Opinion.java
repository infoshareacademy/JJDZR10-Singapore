package com.singapore.TripPlaner.Model;


import com.singapore.TripPlaner.Service.OpinionService;

import java.util.List;
import java.util.Objects;

public class Opinion extends PersistentAbstract  {
    private long id;
    private String userOpinion;
    private Integer userRate;
    private Double objectRate;
    private List<Integer> ratingsList;

    private Integer id_user;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    OpinionService opinionService = new OpinionService();

    public void setUserOpinion(String userOpinion) {
        this.userOpinion = opinionService.setUserOpinion();
    }

    public void setUserRate(Integer userRate) {
        this.userRate = opinionService.setRate();
    }
    public Integer getUserRate() {
        return userRate;
    }



    private Double getObjectRate() {
        return objectRate;
    }

    public void setObjectRate(Double objectRate) {
        this.objectRate = opinionService.objectRate();
    }

    private List<Integer> getRatingsList() {
        return ratingsList;
    }

    public void setRatingsList(List<Integer> ratingsList) {
        this.ratingsList = opinionService.getRatingsList();
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Opinion{" +
                "userOpinion='" + userOpinion + '\'' +
                ", objectRate=" + objectRate +
                ", ratingsList=" + ratingsList +
                ", id_user=" + id_user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Opinion opinion = (Opinion) o;

        if (id != opinion.id) return false;
        if (!Objects.equals(userOpinion, opinion.userOpinion)) return false;
        if (!Objects.equals(objectRate, opinion.objectRate)) return false;
        if (!Objects.equals(ratingsList, opinion.ratingsList)) return false;
        return Objects.equals(id_user, opinion.id_user);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (userOpinion != null ? userOpinion.hashCode() : 0);
        result = 31 * result + (objectRate != null ? objectRate.hashCode() : 0);
        result = 31 * result + (ratingsList != null ? ratingsList.hashCode() : 0);
        result = 31 * result + (id_user != null ? id_user.hashCode() : 0);
        return result;
    }
}
