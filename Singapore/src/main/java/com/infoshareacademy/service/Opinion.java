package com.infoshareacademy.service;

import com.infoshareacademy.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Opinion extends ReadFile {
    private String userOpinion;

    private String comment;
    private boolean isValidRate;
    private boolean isValidComment;
    private Double rating;
    private List<Integer> ratings = new ArrayList<>();
    private int rate;
    private User user;

    public Opinion(User user) {
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
        userOpinion = "Komentarz:\n" + comment + "\nod: " + user.getLogin() + "\nŚrednia ocena " + ratings.size() + " użytkowników to " + rating + ".";
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
                rate = scanner.nextInt();
                checkValidRate();

            } catch (Exception f) {
                System.out.println("Podaj liczbę z zakresu 1-10.");
            }
        }
        ratings.add(rate);
        getRating();
    }


    private Double getRating() {
        Double sum = 0d;
        for (int i = 0; i < ratings.size(); i++) {
            sum += (double) ratings.get(i);
        }
        return rating = (double) (sum / ratings.size());
    }


    private boolean checkValidRate() {
        if (rate < 1 || rate > 10) {
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


