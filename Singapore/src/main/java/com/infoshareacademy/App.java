package com.infoshareacademy;
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
        Reader reader = new Reader();
        List<Persistent> trips = reader.getList(Trip.class);
        for (Persistent o: trips) {
            Trip oParsed = (Trip) o;
            System.out.println(oParsed);
        }

        OpenMenuMethod();

        ReadFile readFile = new ReadFile();
        readFile.readFile();


    }

}
