package com.singapore.TripPlaner.Model;

import com.singapore.TripPlaner.Service.IOpinions;

import java.util.List;

public class Places extends PersistentAbstract implements IOpinions {

    private String name;
    private String description;
    private double price;
    private double rate;
    private List <Long> opinions;
    private City city;
    private long cityid;
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

    @Override
    public Object findById(long id) {
        return null;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Long> getOpinions() {
        return opinions;
    }

    @Override
    public String toString() {
        return "Places{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", rate=" + rate +
                ", opinions=" + opinions +
                ", city=" + city +
                ", cityid=" + cityid +
                ", type=" + type +
                '}';
    }
}