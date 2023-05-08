package com.singapore.TripPlaner.Service;


import com.singapore.TripPlaner.Exception.PlaceNotFoundException;
import com.singapore.TripPlaner.Model.*;
import com.singapore.TripPlaner.Service.comparators.PlacesComparatorBiggestRate;
import com.singapore.TripPlaner.Service.comparators.PlacesComparatorMostPopular;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
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
    public List<Place> getAllPlaces() {
        List<Place> places = reader.getList(Place.class).stream().
                map(object -> (Place) object).
                collect(Collectors.toList());
        return places;
    }

    public List<Place> getTopRatedPlaces() {
        List<Place> places = getAllPlaces();
        Collections.sort(places, placesComparatorBiggestRate);
        return places;
    }

    public List<Place> getMostPopularPlaces() {
        List<Place> places = getAllPlaces();
        Collections.sort(places, placesComparatorMostPopular);
        return places;
    }


    public List<Place> filterListByTypeOfPlace(String placeType) {
        return getAllPlaces().stream().
                filter(p -> p.getType().getPlaceType().toLowerCase().equals(placeType.toLowerCase())).
                collect(Collectors.toList());
    }

    public Place findById(Long id) {
        return getAllPlaces().
                stream().filter(places -> places.getId() == id).
                findFirst().orElseThrow(() -> new PlaceNotFoundException("Not found places with given id: " + id));
    }

    public void createNewPlace(Place place) {
        writer.save(place);
    }
    public void removePlace(Long id){
        writer.remove(findById(id));
    }

    public void editPlaceById(Long id, Place place) {
        Place placeToEdit = findById(id);
        placeToEdit.setName(place.getName());
        placeToEdit.setDescription(place.getDescription());
        placeToEdit.setCityid(place.getCityid());
        placeToEdit.setRate(place.getRate());
        placeToEdit.setPrice(place.getPrice());
        placeToEdit.setType(place.getType());
    }
}
