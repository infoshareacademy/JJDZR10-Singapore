package com.singapore.TripPlaner.Service;

import com.singapore.TripPlaner.Model.*;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TripService {

    private final Reader reader;
    private final Writer writer;

    public TripService(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public Trip findTripById(long id) {
        return (Trip) reader.getObjectById(Trip.class, id);
    }

    public void removeTrip(Trip trip) {
        writer.remove(trip);
    }

    // jak będzie logowanie to trzeba będzie dodać taką metodę z Userem jako argument
    public List<Trip> findTrips() {
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
