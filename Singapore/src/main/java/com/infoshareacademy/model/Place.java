package com.infoshareacademy.model;

public class Place implements Persistent{
    private String name;
    private String description;
    private double prize;
    private double rate;
    private String opinion;

    @Override
    public void setId(long id) {

    }
}
