package com.singapore.TripPlaner.Model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class City extends PersistentAbstract {

    private String name;
    private String description;
    private List images;

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

    @Override
    public String toString() {
        return  name ;
    }
}