package com.infoshareacademy;


import com.infoshareacademy.model.User;
import com.infoshareacademy.service.Opinion;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        User user = new User("ALAN", "Albert", "Komoda");
        Opinion opinion = new Opinion(user);

        for (int i = 0; i < 3; i++) {
            opinion.setUserOpinion();
        }


        System.out.println(opinion.getUserOpinion());

    }
}
