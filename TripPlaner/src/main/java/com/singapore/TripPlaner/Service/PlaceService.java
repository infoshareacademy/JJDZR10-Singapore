package com.singapore.TripPlaner.Service;


import com.singapore.TripPlaner.Exception.PlaceNotFoundException;
import com.singapore.TripPlaner.Model.*;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaceService extends PersistentAbstract {
    private final Reader reader;
    private final Writer writer;
    private final PlacesComparatorBiggestRate placesComparatorBiggestRate;
    private final PlacesComparatorMostPopular placesComparatorMostPopular;

    public PlaceService(Reader reader, Writer writer, PlacesComparatorBiggestRate placesComparatorBiggestRate, PlacesComparatorMostPopular placesComparatorMostPopular) {
        this.reader = reader;
        this.writer = writer;
        this.placesComparatorBiggestRate = placesComparatorBiggestRate;
        this.placesComparatorMostPopular = placesComparatorMostPopular;
    }
    public List<Places> getAllPlaces() {
        List<Places> places = reader.getAllPlaces(Places.class);
         return places;
    }
    public List<Places> getTopRatedPlaces() {
        List<Places> places = reader.getAllPlaces(Places.class);
        Collections.sort(places, placesComparatorBiggestRate);
        return places;
    }
    public List<Places> getMostPopularPlaces() {
        List<Places> places = reader.getAllPlaces(Places.class);
        Collections.sort(places, placesComparatorMostPopular);
        return places;
    }
    public List <Places> getSorted(Comparator placesComparator){
        List<Places> places = reader.getAllPlaces(Places.class);
        Collections.sort(places, placesComparator);
        return places;
    }


    public List<Places> filterListByTypeOfPlace(String placeType) {
        return getAllPlaces().stream().filter(p -> p.getType().getPlaceType().toLowerCase().equals(placeType.toLowerCase())).collect(Collectors.toList());
    }
    public Places findById(Long id) {
        return reader.getAllPlaces(Places.class).
                stream().filter(places -> places.getId() == id).
                findFirst().orElseThrow(() -> new PlaceNotFoundException("Not found places with given id: " + id));
    }
}
