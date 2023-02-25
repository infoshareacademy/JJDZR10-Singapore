package com.infoshareacademy.service.dataacces;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.infoshareacademy.model.Persistent;
import com.infoshareacademy.model.Trip;
import com.infoshareacademy.model.User;
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

    private Trip createTripInstance(JSONObject jsonObject) {
        Trip trip = new Trip();
        trip.setId((Long) jsonObject.get("id"));
        trip.setName((String) jsonObject.get("name"));
        trip.setDistance(Double.parseDouble(jsonObject.get("distance").toString()));
        trip.setTimeForTrip(Double.parseDouble(jsonObject.get("time_for_trip").toString()));

        if(jsonObject.containsKey("created_by_user")){
            long idUser = (long) jsonObject.get("created_by_user");
            User user = (User) this.getObjectById(User.class, idUser);
            trip.setUser(user);
        }
        return trip;
    }
}
