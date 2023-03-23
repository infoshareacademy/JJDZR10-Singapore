package com.singapore.TripPlaner.Model;

public class TripPoint extends PersistentAbstract {
    private long placeid;

    private Trip trip;

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public long getPlaceid() {
        return placeid;
    }

    public void setPlaceid(long placeid) {
        this.placeid = placeid;
    }

}
