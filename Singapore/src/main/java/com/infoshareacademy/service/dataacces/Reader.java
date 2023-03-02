package com.infoshareacademy.service.dataacces;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.infoshareacademy.model.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Reader {

    private String method;

    public Reader() {
        this.method = "json";
    }

    public List<Persistent> getList(Class c) {

        List<Persistent> lo = new ArrayList<>();
        JSONArray jsonArray = this.getListInJson(c);

        try {
            for (Object o : jsonArray) {
                JSONObject jsonObject = (JSONObject) o;
                lo.add(this.mapJsonToEntity(jsonObject, c));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lo;
    }

    private Persistent mapJsonToEntity(JSONObject jsonObject, Class c) throws Exception {

        String className = c.getName();
        switch (className) {
            case "com.infoshareacademy.model.Trip":
                return this.createTripInstance(jsonObject);
            case "com.infoshareacademy.model.User":
                return this.createUserInstance(jsonObject);
            case "com.infoshareacademy.model.City":
                return this.createCityInstance(jsonObject);
            case "com.infoshareacademy.model.Places":
                return this.createPlaceInstance(jsonObject);
        }
        throw(new Exception("No such model entity"));
    }

    public Persistent getObjectById(Class c, long id){
        JSONArray jsonArray = this.getListInJson(c);
        try {
            for (Object o : jsonArray) {
                JSONObject jsonObject = (JSONObject) o;
                if (jsonObject.containsKey("id") && ((long) jsonObject.get("id")) == id) {
                    return this.mapJsonToEntity(jsonObject, c);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;


    }

    /**
     *
     * @param c
     * @return
     */
    public JSONArray getListInJson(Class c) {

        JSONArray jsonArray;
        JSONParser parser = new JSONParser();

        /**
         * Odczyt z resources InputStream + InputStreamReader
         * Parsujemy InputStream
         */
        InputStream resource = getResource(c);
        InputStreamReader isr =new InputStreamReader(resource);
        try {
            jsonArray = (JSONArray) parser.parse(isr);
        } catch (Exception e) {
            System.out.println(e);
            return new JSONArray();
        }
        return  jsonArray;

    }

    /**
     * Budowanie ścieżki pod jaką oczekujemy Jsona dla konkretnej klasy.
     * (getResource zwraca nam Inputstream)
     * @param c
     * @return
     */
    private InputStream getResource(Class c) {

        return c.getResourceAsStream("/"
                + this.method + "/"
                + c.getPackageName() + "/"
                + c.getSimpleName() + ".json");
    }

    private User createUserInstance(JSONObject jsonObject){
        User user = new User();
        user.setFirstName(jsonObject.get("firstname").toString());
        user.setLastName(jsonObject.get("lastname").toString());
        user.setLogin(jsonObject.get("login").toString());
        user.setId((Long) jsonObject.get("id"));
        return user;
    }
    private City createCityInstance(JSONObject jsonObject){
        City city = new City();
        city.setId((Long) jsonObject.get("id"));
        city.setName(jsonObject.get("name").toString());
        city.setDescription(jsonObject.get("description").toString());
        return city;
    }

    private Trip createTripInstance(JSONObject jsonObject) {
        Trip trip = new Trip();
        trip.setId((Long) jsonObject.get("id"));
        if(jsonObject.containsKey("name")) {
            trip.setName((String) jsonObject.get("name"));
        }
        if(jsonObject.containsKey("distance")) {
            trip.setDistance(Double.parseDouble(jsonObject.get("distance").toString()));
        }
        if(jsonObject.containsKey("time_for_trip")){
            trip.setTimeForTrip(Double.parseDouble(jsonObject.get("time_for_trip").toString()));
        }


        if(jsonObject.containsKey("user")){
            long idUser = (long) jsonObject.get("user");
            User user = (User) this.getObjectById(User.class, idUser);
            trip.setUser(user);
        }
        return trip;
    }
    private Places createPlaceInstance(JSONObject jsonObject) {
        Places place = new Places();
        place.setId((Long) jsonObject.get("id"));
        place.setName((String) jsonObject.get("name"));
        place.setDescription(jsonObject.get("description").toString());
        place.setRate(Double.parseDouble(jsonObject.get("rate").toString()));
        place.setPrize(Double.parseDouble(jsonObject.get("prize").toString()));
        place.setOpinion((String) jsonObject.get("opinion"));
        if(jsonObject.containsKey("fromCity")){
            long idCity = (long) jsonObject.get("fromCity");
            City city = (City) this.getObjectById(City.class, idCity);
            place.setCity(city);
        }
        return place;
    }
}
