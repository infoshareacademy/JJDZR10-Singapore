package com.singapore.TripPlaner.Service;

import com.singapore.TripPlaner.Model.*;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class TripService {

    private final Reader reader;
    private final Writer writer;

    public TripService(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }


    public List<Trip> getTrip(Trip trip, boolean sortByPosition) {
        List<Persistent> tripList = reader.getList(Trip.class);
        List<Trip> tripListRet = new ArrayList<Trip>();
        for (Object o : tripList) {

            if (trip.getId() == trip.getId()) {
                tripListRet.add(trip);
            }
        }
        if (sortByPosition) {
            Collections.sort(tripListRet);
        }

        return tripListRet;
    }

    public Trip findById(long id) {
        return (Trip) reader.getObjectById(Trip.class, id);
    }

    public void removeTrip(Trip trip) {
        writer.remove(trip);
    }

    // jak będzie logowanie to trzeba będzie dodać taką metodę z Userem jako argument
    public List<Trip> getTrips() {
        List<Trip> trips = new ArrayList<>();
        List<Persistent> tripsPersistent = reader.getList(Trip.class);

        for (Object tripObject : tripsPersistent) {
            Trip trip = (Trip) tripObject;
            trips.add(trip);

        }
        Collections.sort(trips);
        return trips;
    }
    public void save(Trip trip){
        writer.save(trip);
    }

}
