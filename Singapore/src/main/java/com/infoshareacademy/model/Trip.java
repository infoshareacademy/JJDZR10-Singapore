package com.infoshareacademy.model;

import com.infoshareacademy.model.place.Places;
import org.json.simple.JSONObject;

import java.util.List;

public class Trip extends PersistentAbstract {


    private String name;

    /**
     * Distance in kilometers
     */
    private Double distance;

    /**
     * Time to spend in hours i.e. 5.5
     */
    private Double time_for_trip;

    private User user;
    /**
     * Places to see on the route
     */
    private List<Places> places;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public double getTimeForTrip() {
        return time_for_trip;
    }

    public void setTimeForTrip(double time_for_trip) {
        this.time_for_trip = time_for_trip;
    }

    @Override
    public JSONObject toJSON() {
        JSONObject jsonObject = super.toJSON();
        jsonObject.put("user", user.getId());
        return jsonObject;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", distance=" + distance +
                ", time_for_trip=" + time_for_trip +
                ", created_by_user=" + user +
                ", places=" + places +
                '}';
    }
}
