package com.infoshareacademy;

import com.infoshareacademy.model.City;
import com.infoshareacademy.model.User;
import com.infoshareacademy.service.CityViewer;
import com.infoshareacademy.service.PlaceViewer;
import com.infoshareacademy.service.ReadFile;
import static com.infoshareacademy.service.Menu.OpenMenuMethod;
import com.infoshareacademy.model.User;
import com.infoshareacademy.service.Menu;
import com.infoshareacademy.service.OpinionService;




public class App {
    public static void main(String[] args) {

        CityViewer cityViewer = new CityViewer();
        cityViewer.cityView();
        PlaceViewer placeViewer = new PlaceViewer();
        placeViewer.placesViewForCity(4);
        placeViewer.placesViewForCityOnlyNames(2);
    
        User user = new User();
        user.setLogin("Bolesław");

        Menu menu = new Menu();
        menu.OpenMenuMethod();



    }
}
