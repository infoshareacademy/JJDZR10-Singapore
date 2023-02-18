package com.infoshareacademy.model;

import com.infoshareacademy.service.ReadFile;

import java.util.Scanner;


public class Opinion extends ReadFile {

    private String comment;
    private boolean isValidRate;
    private int rate;

    private User user;
    private ReadFile readFile;

    public Opinion(ReadFile readFile) {
        this.readFile = readFile;
    }

    public void userOpinion() {
        System.out.println("Napisz komentarz!");
        Scanner scanner = new Scanner(System.in);
        comment = scanner.nextLine();
        setRate();
        writeFile("Komentarz:\n" + comment);
        writeFile("Ocena: " + rate);
        writeFile("Login: ");
        writeFile("\n");
    }

    private void setRate() {
        System.out.println("Podaj swoją ocenę w skali 1-10");
        Scanner scannerRate = new Scanner(System.in);
        boolean isValidRate = true;
        try {
            rate = scannerRate.nextInt();
            checkValidRate();
        } catch (Exception e) {
            System.out.println("Podaj liczbę z zakresu 1-10.");
            while (isValidRate) {
                try {
                    Scanner scannerRateNext = new Scanner(System.in);
                    rate = scannerRateNext.nextInt();
                    checkValidRate();
                } catch (Exception f) {
                    System.out.println("Podaj liczbę z zakresu 1-10.");
                }
            }
        }
    }

    private void checkValidRate() {
        if (rate < 1 || rate > 10) {
            throw new IllegalArgumentException();
        } else {
            isValidRate = false;
        }

    }
}
