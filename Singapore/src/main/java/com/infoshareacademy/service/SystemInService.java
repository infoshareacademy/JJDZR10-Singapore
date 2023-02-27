package com.infoshareacademy.service;

public abstract class SystemInService {
    private String userScanString;
    private Integer userScanInteger;

    private boolean isValidInteger;
    private boolean isValidString;

    public String getUserScanString() {
        return userScanString;
    }

    public Integer getUserScanInteger() {
        return userScanInteger;
    }

    public String scanUserString(String stringForUser) {
        System.out.println(stringForUser);
        isValidString = true;
        while (isValidString) {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            userScanString = scanner.nextLine();
            checkValidString();
        }
        return userScanString;
    }

    private boolean checkValidString() {
        if (userScanString.isEmpty()) {
            System.out.println("Napisz coś.");
            isValidString = true;
        } else {

            isValidString = false;
        }
        return isValidString;
    }

    public Integer userScanInteger(String stringForUser, Integer minInteger, Integer maxInteger) {
        System.out.println(stringForUser);
        isValidInteger = true;
        while (isValidInteger) {
            try {
                java.util.Scanner scanner = new java.util.Scanner(System.in);
                userScanInteger = scanner.nextInt();
                checkValidInteger(minInteger , maxInteger);

            } catch (Exception f) {
                System.out.println("Podaj prawidłową liczbę!");
            }
        }
        return  userScanInteger;
    }

        private boolean checkValidInteger (Integer a, Integer b) {
            if (userScanInteger < a || userScanInteger > b) {
                throw new IllegalArgumentException();
            } else {
                isValidInteger = false;
            }
            return isValidInteger;
        }
    }


