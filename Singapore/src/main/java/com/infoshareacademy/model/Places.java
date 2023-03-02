package com.infoshareacademy.model;

public class Places implements Persistent {
    private long id;
    private String name;
    private String description;
    private double prize;
    private double rate;
    private String opinion;
    private City city;



    @Override
    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
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
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
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
                "\nCena: "+prize + " zł\nOcena: " + rate +
                "\nOpinie: " + opinion +
                "\n******************************";
    }
}
