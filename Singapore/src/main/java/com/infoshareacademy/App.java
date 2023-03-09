package com.infoshareacademy;

import com.infoshareacademy.model.User;
import com.infoshareacademy.service.CityService;
import com.infoshareacademy.service.PlaceService;
import com.infoshareacademy.service.Menu;


public class App {
    public static void main(String[] args) {

        CityService cityService = new CityService();
        cityService.findAllCities();
        PlaceService placeService = new PlaceService();
        placeService.findAllPlaces();
        placeService.findAllPlacesByCity(4);
        placeService.findAllPlacesByCityOnlyNames(2);
    
        User user = new User();
        user.setLogin("Bolesław");

        Menu menu = new Menu();
        menu.OpenMenuMethod();



    }
}
