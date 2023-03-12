package com.infoshareacademy.service;

import com.infoshareacademy.model.Persistent;
import com.infoshareacademy.model.User;

import java.util.Scanner;

public class CreateUser extends User implements Persistent {

    Scanner inputUser = new Scanner(System.in);

    public void createUsers() {

        setId(getId());
        System.out.println("Wprowadź swoje imię: ");
        setFirstName(inputUser.nextLine());
        System.out.println("Wprowadź swoje nazwisko: ");
        setLastName(inputUser.nextLine());
        System.out.println("Wprowadź swój login: ");
        setLogin(inputUser.nextLine());

    }
}
