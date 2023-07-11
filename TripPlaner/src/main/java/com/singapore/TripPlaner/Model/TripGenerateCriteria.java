package com.singapore.TripPlaner.Model;

import org.springframework.stereotype.Component;

@Component
public class TripGenerateCriteria {
    private int numberOfStops;
    private Double timeToGo;

    public int getNumberOfStops() {
        return numberOfStops;
    }

    private City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setNumberOfStops(int numberOfStops) {
        this.numberOfStops = numberOfStops;
    }

    public Double getTimeToGo() {
        return timeToGo;
    }

    public void setTimeToGo(Double timeToGo) {
        this.timeToGo = timeToGo;
    }

    public TripGenerateCriteria() {
        this.numberOfStops = 7;
        this.timeToGo = 5.5;
    }
}
