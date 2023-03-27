package com.singapore.TripPlaner.Model;

import jdk.jfr.Description;
import org.springframework.stereotype.Service;

import javax.validation.Valid;



public class City extends PersistentAbstract {

    private String name;
    private String description;

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