package com.singapore.TripPlaner.Model;

import com.singapore.TripPlaner.Service.IOpinions;

import java.util.List;


public class City extends PersistentAbstract implements IOpinions {

    private String name;
    private String description;
    private List <Long> opinions;
    private double rate;

    public List getOpinions() {
        return opinions;
    }

    public void setOpinions(List opinions) {
        this.opinions = opinions;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public Object findById(long id) {
        return null;
    }

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

}