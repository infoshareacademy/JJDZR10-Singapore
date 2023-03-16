package com.singapore.TripPlaner.Model;

import com.google.gson.Gson;
import com.infoshareacademy.model.Persistent;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public abstract class PersistentAbstract implements Persistent {


    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public JSONObject toJSON() {

        Gson gson = new Gson();
        String jsonString = gson.toJson(this);
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) parser.parse(jsonString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return jsonObject;
    }
}
