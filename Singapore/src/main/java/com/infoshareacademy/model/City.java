package com.infoshareacademy.model;
import java.util.List;

public class City implements Persistent {
    private long id;
    private String name;
    private String description;


    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id =id;
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
        return "Miasto: "+ name +
                "\nOpis: " +description+ "\nid="+id+
                "\n**********************";
    }
}