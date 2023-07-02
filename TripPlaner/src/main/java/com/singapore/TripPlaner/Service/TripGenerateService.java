package com.singapore.TripPlaner.Service;

import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Place;
import com.singapore.TripPlaner.Model.Trip;
import com.singapore.TripPlaner.Model.TripGenerateCriteria;
import com.singapore.TripPlaner.Service.CityService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TripGenerateService {

    //miasta do wyboru
    private final List<City> cities;

    public final TripGenerateCriteria tgc;
    private final TripService tripService;
    private final PlaceService placeService;

    public TripGenerateService(TripGenerateCriteria tgc, CityService cityService, TripService tripService, PlaceService placeService) {
        this.tgc = tgc;
        this.tripService = tripService;
        this.placeService = placeService;
        this.cities = cityService.getCities();
    }
    public List<City> getCities() {
        return this.cities;
    }

    public Trip generateTrip(TripGenerateCriteria tgc) {

        Trip trip = new Trip();
        trip.setPlaces(new ArrayList<Place>());
        trip.setTime_for_trip(tgc.getTimeToGo());
        trip.setDescription("Wycieczka generowana losowo dla miasta: " + tgc.getCity().getName());

        Random rand = new Random();
        List<Long> addedPlaces = new ArrayList<>();
        List<Long> remainingPlaces = new ArrayList<>();
        for (int i = 0; i < tgc.getNumberOfStops(); i++) {
            
            if (addedPlaces.size() > 0) {
                remainingPlaces = placeService.getIdsExept(addedPlaces, tgc.getCity());
            } else {
                remainingPlaces = placeService.getAllIds(tgc.getCity());
            }
            if (remainingPlaces.size() > 0) {
                
                int randomPlaceIndex = rand.nextInt(remainingPlaces.size());
                Place randomPlace = placeService.findById(remainingPlaces.get(randomPlaceIndex));
                addedPlaces.add(remainingPlaces.get(randomPlaceIndex));
                trip.getPlaces().add(randomPlace);
            }
        }
        


        tripService.save(trip);

        return trip;
    }
    
}
