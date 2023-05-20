package com.singapore.TripPlaner.Model;

import java.util.List;


public class City extends PersistentAbstract {

    private String name;
    private String description;
    private List <Long> images;

    public List getImages() {
        return images;
    }

    public void setImages(List images) {
        this.images = images;
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