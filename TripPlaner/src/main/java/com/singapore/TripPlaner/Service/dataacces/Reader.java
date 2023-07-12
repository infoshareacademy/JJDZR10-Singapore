package com.singapore.TripPlaner.Service.dataacces;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.singapore.TripPlaner.Model.*;
import com.singapore.TripPlaner.Model.User.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

@Component
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

        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new GsonExclusionStrategy())
                .create();
        Object object = gson.fromJson(jsonObject.toJSONString(), c);

        switch (className) {
            case "com.singapore.TripPlaner.Model.User":
                return (Persistent) object;
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
//                + c.getPackageName() + "/"
                + c.getSimpleName() + ".json");
    }



}

