package com.singapore.TripPlaner.Model;

import org.json.simple.JSONObject;

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
