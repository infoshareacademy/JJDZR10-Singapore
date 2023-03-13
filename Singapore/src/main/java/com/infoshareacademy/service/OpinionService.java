package com.infoshareacademy.service;

import com.infoshareacademy.model.User;

import java.util.ArrayList;
import java.util.List;


public class OpinionService extends ValidatorService {
    private long id;
    private String userOpinion;
    private Double objectRate;
    private List<Integer> ratingsList = new ArrayList<>();
    private User user;

    public String getUserOpinion() {
        return userOpinion;
    }

    public long getId() {
        return id;
    }

    public List<Integer> getRatingsList() {
        return ratingsList;
    }

    public String setUserOpinion() {
        scanUserString("Napisz komentarz.", "Nic nie napisałeś, podaj swoją opinię");
        System.out.println("Komentarz dodano. ");
        userOpinion = "Komentarz:\n" + getUserScanString() + "\nod: " + user.getLogin() + "\nŚrednia ocena " + ratingsList.size() + " użytkowników to " + objectRate + ".";
        return userOpinion;
    }

    public void setRate() {
        userScanInteger("Podaj swoją ocenę w skali 1-10", "Podałeś liczbę spoza zakresu", 1, 10);
        ratingsList.add(getUserScanInteger());
        objectRate();
    }

    public Double objectRate() {
        Double sum = 0d;
        for (int i = 0; i < ratingsList.size(); i++) {
            sum += (double) ratingsList.get(i);
        }
        return objectRate = (double) (sum / ratingsList.size());
    }


}


