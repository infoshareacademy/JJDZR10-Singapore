package com.singapore.TripPlaner.Model;

import org.json.simple.JSONObject;

import java.util.List;

public interface Persistent {
    /**
     *
     * @param id
     */
    void setId(long id);

    /**
     *
     * @return
     */
    long getId();

    /**
     *
     * @return
     */
    public JSONObject toJSON();


}
