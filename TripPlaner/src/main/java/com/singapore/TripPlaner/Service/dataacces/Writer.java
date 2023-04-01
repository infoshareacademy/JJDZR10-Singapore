package com.singapore.TripPlaner.Service.dataacces;

import com.google.gson.Gson;


import com.singapore.TripPlaner.Model.Persistent;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class Writer {

    public void save(Persistent entity) {

        Reader reader = new Reader();
        List<Persistent> list = reader.getList(entity.getClass());
        JSONArray listJson = new JSONArray();

        //Dodanie nowego elementu + sprawdzanie jakie ID można mu nadać -> np. jeśli nadane id=2 to ten przyjmie nr 3

        boolean isNew = false;
        if (entity.getId() == 0) {
            isNew = true;
            long currMaxId = PersistentService.getMaxId(list);
            entity.setId(currMaxId + 1);
        }

        if (list.size() == 0 || isNew) {
            listJson.add(entity.toJSON());
        }

        // podmiana obiektu na liście
        for (Persistent o : list) {
            if (o.getId() == entity.getId()) {
                listJson.add(entity.toJSON());
            } else {
                listJson.add(o.toJSON());
            }
        }


        try (FileWriter file = new FileWriter(getResourcePath(entity.getClass()))) {
            listJson.writeJSONString(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void remove(Persistent entityObject) {

        Reader reader = new Reader();
        List<Persistent> list = reader.getList(entityObject.getClass());
        JSONArray listJson = new JSONArray();

        // zapisanie listy bez przekazanego obiektu
        for (Persistent o : list) {
            if (o.getId() != entityObject.getId()) {
                listJson.add(o.toJSON());
            }
        }

        try (FileWriter file = new FileWriter(getResourcePath(entityObject.getClass()))) {
            listJson.writeJSONString(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Budowanie ścieżki pod jaką oczekujemy Jsona dla konkretnej klasy.
     *
     * @param c
     * @return
     */
    private String getResourcePath(Class c) {

        return c.getResource(".").getFile() + "../../../../json/"
//                + c.getPackageName()
                + "/" + c.getSimpleName() + ".json";

    }

}