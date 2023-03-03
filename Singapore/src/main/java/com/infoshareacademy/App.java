package com.infoshareacademy;
import com.infoshareacademy.model.User;
import com.infoshareacademy.service.Menu;
import com.infoshareacademy.service.OpinionService;



public class App {
    public static void main(String[] args) {

        User user = new User();
        user.setLogin("Bolesław");

        Menu menu = new Menu();
        menu.OpenMenuMethod();



    }
}
