package com.infoshareacademy.model;

import com.infoshareacademy.service.OpinionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Opinion {
    private long id;
    private String userOpinion;
    private Double objectRate;
    private List<Integer> ratingsList;
    private Integer id_user;

    public Opinion(Integer id_user) {
        this.id_user = id_user;
    }
    OpinionService opinionService = new OpinionService();
    public long getId() {
        return opinionService.getId();
    }


    public OpinionService getOpinionService() {
        return opinionService;
    }

    public void setUserOpinion(String userOpinion) {
        this.userOpinion=opinionService.setUserOpinion();
    }

    public Double getObjectRate() {
        return objectRate;
    }

    public void setObjectRate(Double objectRate) {
        this.objectRate=opinionService.objectRate();
    }

    public List<Integer> getRatingsList() {
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
