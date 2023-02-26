package com.infoshareacademy;
import com.infoshareacademy.model.User;
import com.infoshareacademy.service.OpinionService;
import com.infoshareacademy.service.ReadFile;
import static com.infoshareacademy.service.Menu.OpenMenuMethod;


public class App {
    public static void main(String[] args) {

        User user = new User("ALAN", "Albert", "Komoda");
        OpinionService opinionService = new OpinionService(user);


        OpenMenuMethod();


        for (int i = 0; i < 3; i++) {
            opinionService.setUserOpinion();
        }

        System.out.println(opinionService.getUserOpinion());

    }
}
    

