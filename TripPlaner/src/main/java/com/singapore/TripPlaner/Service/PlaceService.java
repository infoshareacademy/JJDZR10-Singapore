package com.singapore.TripPlaner.Service;

import com.singapore.TripPlaner.Model.Persistent;
import com.singapore.TripPlaner.Model.Places;
import com.singapore.TripPlaner.Exception.PlaceNotFoundException;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlaceService {


    private final Reader reader;
    private final Writer writer;

    public PlaceService(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;


    }

    public List<Places> findPlaces() {

        List<Places> listOfPlaces = new ArrayList<>();
        List<Persistent> lo = reader.getList(Places.class);

        for (Object o : lo) {
            Places place = (Places) o;
            listOfPlaces.add(place);
        }
        return listOfPlaces;
    }

    public List<Places> findPlacesByCityId(Long cityId) {

        List<Places> allPlaces = findPlaces();
        List<Places> listPlacesByCity = new ArrayList<>();

        for (Places place : allPlaces) {

            if (place.getCity().getId() == cityId) {
                listPlacesByCity.add(place);
            }

        }
        return listPlacesByCity;
    }


    public List<Places> filterListByTypeOfPlace(String placeType) {
        return findPlaces().stream().filter(p -> p.getType().getPlaceType().toLowerCase().equals(placeType.toLowerCase())).collect(Collectors.toList());
    }

    public Places findById(Long id) {
        return findPlaces().stream().filter(places -> places.getId() == id).
                findFirst().orElseThrow(() -> new PlaceNotFoundException("Not found places with given id: " + id));
    }
}

