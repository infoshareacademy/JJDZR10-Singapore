package com.singapore.TripPlaner.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.singapore.TripPlaner.Service.dataacces.GsonExclusionStrategy;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public abstract class PersistentAbstract implements Persistent,Comparable<Persistent> {


    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     * należy wkleić do każdej klasy która ma zagnieżdżone obiekty - jak tu Id , bo Gson nie obsługuje ich
     * jsonObject.put przechwytuje dziłania tej metody z rodzica i dodaje do jsonObject pola których nie potrafi obsłużyć Gson.
     * @return
     */
    @Override
    public JSONObject toJSON() {

//        Gson gson = new Gson();
        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new GsonExclusionStrategy())
                .create();
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

    @Override
    public int compareTo(Persistent o) {
        return 0;
    }
}