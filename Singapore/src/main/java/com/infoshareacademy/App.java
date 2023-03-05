package com.infoshareacademy;
import com.infoshareacademy.model.User;
import com.infoshareacademy.service.LoginUser;
import com.infoshareacademy.service.Menu;
import com.infoshareacademy.service.OpinionService;



public class App {
    public static void main(String[] args) {
        LoginUser loginUser = new LoginUser();
        loginUser.doLogin();

        User user = new User();
        user.setLogin("Bolesław");

        Menu menu = new Menu();
        menu.OpenMenuMethod();



    }
}
