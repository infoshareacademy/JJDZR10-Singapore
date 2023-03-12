package com.infoshareacademy.service;

import com.infoshareacademy.model.User;

import java.util.Scanner;

public class LoginUser extends User {
    Scanner input = new Scanner(System.in);

    // Set  user: login, first name, last name and password

    String login = "1";
    String password = "1";


    // Ask user to enter: login and password

//    @Override
//    public User createUser() {
//        return super.createUser();
//    }

    public void doLogin() {
        System.out.println("\n");
        System.out.println("\nWitaj Włóczykiju! Zaplanuj swoją wycieczkę razem ze mną!");
        System.out.println("\n");
        System.out.println("Zaloguj się!");
        System.out.println("Podaj login: ");
        String inputLogin = input.nextLine();
        System.out.println("Wprowadź hasło: ");
        String inputPassword = input.nextLine();
        // Check if login and Password match
        if (inputLogin.equals(login) && inputPassword.equals((password))) {
            System.out.println("Logowanie poprawne!");
        } else {
            System.out.println("Nieprawidłowy login lub hasło. Zarejestruj się!");
        CreateUser createUser = new CreateUser();
        createUser.createUsers();
            System.out.println("Dziękujemy za rejestrację!");
        }

    }
}















