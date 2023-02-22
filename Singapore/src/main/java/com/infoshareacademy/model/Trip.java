package com.infoshareacademy.model;

import com.infoshareacademy.model.place.Places;
import java.util.List;

public class Trip implements Persistent{

    private long id;

    private String name;

    /**
     * Distance in kilometers
     */
    private Double distance;

    /**
     * Time to spend in hours i.e. 5.5
     */
    private Double time_for_trip;

    private User created_by_user;

    public User getCreatedByUser() {
        return created_by_user;
    }

    public void setCreatedByUser(User created_by_user) {
        this.created_by_user = created_by_user;
    }

    /**
     * Places to see on the route
     */
    private List<Places> places;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", distance=" + distance +
                ", time_for_trip=" + time_for_trip +
                ", created_by_user=" + created_by_user +
                ", places=" + places +
                '}';
    }
}
