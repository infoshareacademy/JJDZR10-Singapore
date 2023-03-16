package com.singapore.TripPlaner.Service;

import java.util.InputMismatchException;
import java.util.Scanner;


public abstract class ValidatorService {
    private String userScanString;
    private Integer userScanInteger;


    public String getUserScanString() {
        return userScanString;
    }

    public Integer getUserScanInteger() {
        return userScanInteger;
    }

    public String scanUserString(String stringForUser, String stringIfWrong) {
        System.out.println(stringForUser);
        while (true) {
            Scanner scanner = new Scanner(System.in);
            userScanString = scanner.nextLine();
            if (checkValidString(stringIfWrong)) {
                break;
            }
        }
        return userScanString;
    }

    private boolean checkValidString(String stringIfWrong) {
        boolean isValidString;
        if (userScanString.isEmpty()) {
            System.out.println(stringIfWrong);
            isValidString = false;
        } else {

            isValidString = true;
        }
        return isValidString;
    }

    public Integer userScanInteger(String stringForUser, String stringIfWrong, Integer minInteger, Integer maxInteger) {
        System.out.println(stringForUser);
        while (true) {
            try {
                java.util.Scanner scanner = new java.util.Scanner(System.in);
                userScanInteger = scanner.nextInt();
                if (checkValidInteger(stringIfWrong, userScanInteger, minInteger, maxInteger)) {
                    return userScanInteger;
                }
                System.out.println(stringIfWrong);
            } catch (InputMismatchException e) {
                System.out.println(stringIfWrong);
            }
        }
    }

    private boolean checkValidInteger(String stringIfWrong, Integer userScanInteger, Integer minInteger, Integer maxInteger) {
        if (userScanInteger < minInteger || userScanInteger > maxInteger) {
            System.out.println(stringIfWrong);
            return false;
        } else {
            return true;
        }
    }
}


