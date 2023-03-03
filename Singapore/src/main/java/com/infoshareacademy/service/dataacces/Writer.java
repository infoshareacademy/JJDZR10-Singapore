package com.infoshareacademy.service.dataacces;

import com.google.gson.Gson;
import com.infoshareacademy.model.Persistent;
import com.infoshareacademy.model.Trip;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Writer {

    public void save(Persistent entity)  {
        Gson gson = new Gson();

        Reader reader = new Reader();
        List<Persistent> list = reader.getList(entity.getClass());
        JSONArray listJson = new JSONArray();
        boolean isNew = false;
        if (entity.getId() == 0){
            isNew = true;
            long currMaxId = 0;
            for (Persistent o: list) {
                if(currMaxId < o.getId()){
                    currMaxId = o.getId();
                }
            }
            entity.setId(currMaxId+1);
        }

        if (list.size() == 0 || isNew) {
            listJson.add(entity.toJSON());
        }

        // podmiana obiektu na liście
        for (Persistent o: list) {
            if (o.getId()==entity.getId()){
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

    /**
     * Budowanie ścieżki pod jaką oczekujemy Jsona dla konkretnej klasy.
     * @param c
     * @return
     */
    private String getResourcePath(Class c) {

        return c.getResource(".").getFile()+"../../../json/" + c.getPackageName() + "/"  + c.getSimpleName() + ".json";
    }









    private String entityToJson (Persistent entity){
        Gson gson = new Gson();
        String jsonStr = gson.toJson(entity);
        return jsonStr;
    }

    /**
     * przyjmujemy stringa z jsonem do zapisu
     * @param jsonStr
     */
    private void saveInResources(String jsonStr,Persistent entity){
        Reader reader = new Reader();
        List<Persistent> trips = reader.getList(Trip.class);

    }
}

