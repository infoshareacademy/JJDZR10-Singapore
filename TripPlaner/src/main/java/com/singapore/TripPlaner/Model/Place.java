package com.singapore.TripPlaner.Model;


import java.util.*;

public class Place extends PersistentAbstract {

    private String name;
    private String description;
    private double price;
    private double rate;
    private String opinion;
    private List <Long> images;
    private List opinions;
    private City city;
    private long cityid;

    private int numberOfOpinions;

    public int getNumberOfOpinions() {
        return numberOfOpinions;
    }

    public void setNumberOfOpinions(int numberOfOpinions) {
        this.numberOfOpinions = numberOfOpinions;
    }

    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public long getCityid() {
        return cityid;
    }

    public void setCityid(long cityid) {
        this.cityid = cityid;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List getImages() {
        return images;
    }

    public void setImages(List images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Nazwa: " + name +
                "\nOpis: "+ description+
                "\nCena: "+price + " zł\nOcena: " + rate +
                "\n******************************\n";
    }


}
