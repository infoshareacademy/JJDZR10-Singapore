package com.infoshareacademy.model;

import org.json.simple.JSONObject;

public class Place extends PersistentAbstract{
    private String name;
    private String description;
    private double prize;
    private double rate;
    private String opinion;

    private City city;

    @Override
    public JSONObject toJSON() {
        JSONObject jsonObject = super.toJSON();
        jsonObject.put("city",city.getId());
        return jsonObject;
    }
}
