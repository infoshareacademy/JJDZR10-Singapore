package com.infoshareacademy.service;

import com.infoshareacademy.model.User;

import java.util.ArrayList;
import java.util.List;


public class OpinionService extends ValidatorService {
    private String userOpinion;
    private Double objectRate;
    private List<Integer> ratingsList = new ArrayList<>();
    private User user;

    public OpinionService(User user) {
        this.user = user;
    }

    public String setUserOpinion() {
        scanUserString("Napisz komentarz.", "Nic nie napisałeś, podaj swoją opinię");
        setRate();
        System.out.println("Komentarz dodano. ");
        userOpinion = "Komentarz:\n" + getUserScanString() + "\nod: " + user.getLogin() + "\nŚrednia ocena " + ratingsList.size() + " użytkowników to " + objectRate + ".";
        System.out.println(userOpinion);  //FIXME usunąć po scaleniu z zapisywaniem w json
        return userOpinion;

    }

    private void setRate() {
        userScanInteger("Podaj swoją ocenę w skali 1-10", "Podałeś liczbę spoza zakresu", 1, 10);
        ratingsList.add(getUserScanInteger());
        getObjectRate();
    }

    private Double getObjectRate() {
        Double sum = 0d;
        for (int i = 0; i < ratingsList.size(); i++) {
            sum += (double) ratingsList.get(i);
        }
        return objectRate = (double) (sum / ratingsList.size());
    }
}


