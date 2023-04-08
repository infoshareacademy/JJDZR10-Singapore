package com.singapore.TripPlaner.Model;

import org.json.simple.JSONObject;

import java.util.List;

public class Places /*extends PersistentAbstract*/ {

    private String name;
    private String description;
    private double prize;
    private double rate;
    private List opinions;
    private City city;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List getOpinions() {
        return opinions;
    }

    public void setOpinions(List opinions) {
        this.opinions = opinions;
    }

    @Override
    public String toString() {
        return "Places{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", prize=" + prize +
                ", rate=" + rate +
                ", opinions=" + opinions +
                ", city=" + city +
                '}';
    }
}
