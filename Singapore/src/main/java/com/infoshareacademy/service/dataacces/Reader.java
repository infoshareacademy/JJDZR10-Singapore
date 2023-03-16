package com.infoshareacademy.service.dataacces;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

    public List<Places> getAllPlaces(Class c) {

        List<Places> listOfPlaces = new ArrayList<>();
        JSONArray jsonArray = this.getListInJson(c);

        try {
            for (Object o : jsonArray) {
                JSONObject jsonObject = (JSONObject) o;
                listOfPlaces.add(this.createPlaceInstance(jsonObject));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listOfPlaces;
    }

    private Persistent mapJsonToEntity(JSONObject jsonObject, Class c) throws Exception {
        String className = c.getName();

        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new GsonExclusionStrategy())
                .create();
        Object object = gson.fromJson(jsonObject.toJSONString(), c);

        switch (className) {
            case "com.infoshareacademy.model.Trip":
                return this.createTripInstance(jsonObject, object);
            case "com.infoshareacademy.model.User":
                return (User) object;
            case "com.infoshareacademy.model.City":
                return (City) object;
            case "com.infoshareacademy.model.Places":
                return this.createPlaceInstance(jsonObject, object);
        }
        throw (new Exception("No such model entity"));
    }

    public Persistent getObjectById(Class c, long id) {
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
        InputStreamReader isr = new InputStreamReader(resource);
        try {
            jsonArray = (JSONArray) parser.parse(isr);
        } catch (Exception e) {
            System.out.println(e);
            return new JSONArray();
        }
        return jsonArray;

    }

    /**
     * Budowanie ścieżki pod jaką oczekujemy Jsona dla konkretnej klasy.
     * (getResource zwraca nam Inputstream)
     *
     * @param c
     * @return
     */
    private InputStream getResource(Class c) {

        return c.getResourceAsStream("/"
                + this.method + "/"
                + c.getPackageName() + "/"
                + c.getSimpleName() + ".json");
    }

    private Trip createTripInstance(JSONObject jsonObject, Object object) {
        Trip trip = (Trip) object;
        if(jsonObject.containsKey("userid")) {
            long idUser = (long) jsonObject.get("userid");
            User user = (User) this.getObjectById(User.class, idUser);
            trip.setUser(user);
        }
        return trip;
    }

    private Places createPlaceInstance(JSONObject jsonObject, Object object) {
        Places place = (Places) object;
        if (jsonObject.containsKey("fromCity")) {
            long idCity = (long) jsonObject.get("fromCity");
            City city = (City) this.getObjectById(City.class, idCity);
            place.setCity(city);
        }
        return place;
    }
}
