package com.singapore.TripPlaner.Model;

import org.json.simple.JSONObject;

public class Places extends PersistentAbstract {

    private String name;
    private String description;
    private double price;
    private double rate;
    private String opinion;
    private City city;
    private long cityid;
    private int type;




    public int getType() {
        return type;
    }

    public void setType(int type) {
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

    public double getPrize() {
        return price;
    }

    public void setPrize(double prize) {
        this.price = prize;
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

    @Override
    public String toString() {
        return "Nazwa: " + name +
                "\nOpis: "+ description+
                "\nCena: "+price + " zł\nOcena: " + rate +
                "\nOpinie: " + opinion +
                "\n******************************\n";
    }


}
