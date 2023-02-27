package com.infoshareacademy.service;

import com.infoshareacademy.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class OpinionService extends ReadFile {
    private String userOpinion;

    private String comment;
    private boolean isValidRate;
    private boolean isValidComment;
    private Double objectRate;
    private List<Integer> ratingsList = new ArrayList<>();
    private int userRate;
    private User user;

    public OpinionService(User user) {
        this.user = user;
    }

    public String setUserOpinion() {
        System.out.println("Napisz komentarz!");
        isValidComment = true;
        while (isValidComment) {
            Scanner scanner = new Scanner(System.in);
            comment = scanner.nextLine();
            checkValidComment();
        }

        setRate();
        System.out.println("Komentarz dodano. ");
        userOpinion = "Komentarz:\n" + comment + "\nod: " + user.getLogin() + "\nŚrednia ocena " + ratingsList.size() + " użytkowników to " + objectRate + ".";
        return userOpinion;
    }

    public String getUserOpinion() {
        return userOpinion;
    }

    private void setRate() {

        System.out.println("Podaj swoją ocenę w skali 1-10");
        isValidRate = true;
        while (isValidRate) {
            try {

                Scanner scanner = new Scanner(System.in);
                userRate = scanner.nextInt();
                checkValidRate();

            } catch (Exception f) {
                System.out.println("Podaj liczbę z zakresu 1-10.");
            }
        }
        ratingsList.add(userRate);
        getObjectRate();
    }


    private Double getObjectRate() {
        Double sum = 0d;
        for (int i = 0; i < ratingsList.size(); i++) {
            sum += (double) ratingsList.get(i);
        }
        return objectRate = (double) (sum / ratingsList.size());
    }


    private boolean checkValidRate() {
        if (userRate < 1 || userRate > 10) {
            throw new IllegalArgumentException();
        } else {
            isValidRate = false;
        }
        return isValidRate;
    }

    private boolean checkValidComment() {
        if (comment.isEmpty()) {
            System.out.println("Napisz coś.");
            isValidComment = true;
        } else {
            isValidComment = false;
        }
        return isValidComment;
    }
}


