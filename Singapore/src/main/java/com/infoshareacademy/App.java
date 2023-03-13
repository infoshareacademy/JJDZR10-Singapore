package com.infoshareacademy;

import com.infoshareacademy.model.User;
import com.infoshareacademy.service.OpinionService;


public class App {
    public static void main(String[] args) {

        User user = new User();
        user.setLogin("Bolesław");
        OpinionService opinionService = new OpinionService();
        opinionService.setUserOpinion();
        opinionService.objectRate();

    }
}
