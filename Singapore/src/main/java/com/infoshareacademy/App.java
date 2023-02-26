package com.infoshareacademy;


import com.infoshareacademy.model.User;
import com.infoshareacademy.service.OpinionService;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        User user = new User("ALAN", "Albert", "Komoda");
        OpinionService opinionService = new OpinionService(user);

        for (int i = 0; i < 3; i++) {
            opinionService.setUserOpinion();
        }


        System.out.println(opinionService.getUserOpinion());

    }
}
