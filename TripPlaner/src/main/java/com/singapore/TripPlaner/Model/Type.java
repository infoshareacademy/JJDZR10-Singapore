package com.singapore.TripPlaner.Model;

public enum Type {
    MONUMENT("Zabytki"),
    NATURE("Natura"),
    RESTAURANT("Jedzenie");

    private final String placeType;

    Type(String placeType) {
        this.placeType = placeType;
    }

    public String getPlaceType() {
        return placeType;
    }

    @Override
    public String toString() {
        return placeType;
    }
}
