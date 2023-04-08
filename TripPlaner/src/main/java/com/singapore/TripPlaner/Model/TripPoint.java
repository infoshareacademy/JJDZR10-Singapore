package com.singapore.TripPlaner.Model;

import org.json.simple.JSONObject;

public class TripPoint extends PersistentAbstract{
    private Places place;
    private Trip trip;
    private long position;

    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Places getPlace() {
        return place;
    }

    public void setPlace(Places place) {
        this.place = place;
    }

    @Override
    public JSONObject toJSON() {
        JSONObject jsonObject = super.toJSON();
        if(trip != null){
            jsonObject.put("tripid", trip.getId());
        }
        if(place != null){
            jsonObject.put("placeid", place.getId());
        }
        return jsonObject;

    }

    @Override
    public int compareTo(Persistent o) {
        TripPoint tripPoint = (TripPoint) o;
        if(getPosition() == tripPoint.getPosition()) {
            return 0;
        }
        return getPosition() > tripPoint.getPosition()? 1:-1;
    }
}
