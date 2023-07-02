package com.singapore.TripPlaner.Service;

import com.singapore.TripPlaner.Exception.ObjectNotFoundException;
import com.singapore.TripPlaner.Model.*;
import com.singapore.TripPlaner.Repository.TripRepository;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class TripService {

    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Trip findTripById(Long id) {
        return tripRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Not found trip with id: "+id));
    }

    public void removeTrip(Trip trip) {
        try {
            tripRepository.deleteById(trip.getId());
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Not found trip with given id:" + trip.getId());
        }
    }

    // jak będzie logowanie to trzeba będzie dodać taką metodę z Userem jako argument
    public List<Trip> findTrips() {
        return tripRepository.findAll();
    }

    public Trip save(Trip trip) {
        return tripRepository.save(trip);
    }
    
    private int getRandomPlaceIndex(int size) {
        Random rand = new Random();
        int intRandom = rand.nextInt(size);
        return intRandom;

    }
    
    public String getRandomPlaceImgUrl(Trip trip) {
        String url = "";
        if (trip.getPlaces() != null) {

            int randomPlaceIndex = this.getRandomPlaceIndex(trip.getPlaces().size());
            url = trip.getPlaces().get(randomPlaceIndex).getImages().get(0).getUrl();
        }
        return url;
    }

}
