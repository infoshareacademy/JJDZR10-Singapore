package com.infoshareacademy.model;

import org.json.simple.JSONObject;

public class Place extends PersistentAbstract{
    private String name;
    private String description;
    private double prize;
    private double rate;
    private String opinion;

    private City city;

    /**
     * należy wkleić do każdej klasy która ma zagnieżdżone obiekty - jak tu Id , bo Gson nie obsługuje ich
     * jsonObject.put przechwytuje dziłania tej metody z rodzica i dodaje do jsonObject pola których nie potrafi obsłużyć Gson.
     * @return
     */
    @Override
    public JSONObject toJSON() {
        JSONObject jsonObject = super.toJSON();
        jsonObject.put("city",city.getId());
        return jsonObject;
    }
}
