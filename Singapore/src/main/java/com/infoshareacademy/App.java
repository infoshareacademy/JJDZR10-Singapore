package com.infoshareacademy;
import com.infoshareacademy.model.City;
import com.infoshareacademy.model.User;
import com.infoshareacademy.service.CityViewer;
import com.infoshareacademy.service.PlaceViewer;
import com.infoshareacademy.service.ReadFile;
import static com.infoshareacademy.service.Menu.OpenMenuMethod;

import com.infoshareacademy.model.Persistent;
import com.infoshareacademy.model.Trip;
import com.infoshareacademy.service.dataacces.Reader;
import org.json.simple.JSONObject;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {


        CityViewer cityViewer = new CityViewer();
        cityViewer.cityView();
        PlaceViewer placeViewer = new PlaceViewer();
        //placeViewer.placesView();
        placeViewer.placesViewByCityId(2);



        //OpenMenuMethod();
    }

}
