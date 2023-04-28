package com.singapore.TripPlaner.Model;

import jdk.jfr.Description;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.*;


public class City extends PersistentAbstract {

    private String name;
    private String description;
    private List opinions;
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