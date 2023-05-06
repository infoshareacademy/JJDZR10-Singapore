package com.singapore.TripPlaner.Service;


import com.singapore.TripPlaner.Exception.PlaceNotFoundException;
import com.singapore.TripPlaner.Model.*;
import com.singapore.TripPlaner.Service.comparators.PlacesComparatorBiggestRate;
import com.singapore.TripPlaner.Service.comparators.PlacesComparatorMostPopular;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.ArrayList;
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
        List<Place> places = reader.getAllPlaces(Place.class);
         return places;
    }
    public List<Place> getTopRatedPlaces() {
        List<Place> places = reader.getAllPlaces(Place.class);
        Collections.sort(places, placesComparatorBiggestRate);
        return places;
    }
    public List<Place> getMostPopularPlaces() {
        List<Place> places = reader.getAllPlaces(Place.class);
        Collections.sort(places, placesComparatorMostPopular);
        return places;
    }

    /**
     *
     * @param cityId
     * @return lista places danego miasta
     */
    public List<Place> findPlacesByCityId(Long cityId) {

        List<Place> allPlaces = findPlaces();
        List<Place> listPlacesByCity = new ArrayList<>();

        for (Place place : allPlaces) {
            if (place.getCity().getId() == cityId) {
                listPlacesByCity.add(place);
            }
        }
        return listPlacesByCity;
    }



    public List<Place> filterListByTypeOfPlace(String placeType) {
        return getAllPlaces().stream().filter(p -> p.getType().getPlaceType().toLowerCase().equals(placeType.toLowerCase())).collect(Collectors.toList());
    }
    public Place findById(Long id) {
        return reader.getAllPlaces(Place.class).
                stream().filter(places -> places.getId() == id).
                findFirst().orElseThrow(() -> new PlaceNotFoundException("Not found places with given id: " + id));
    }
    public void createNewPlace(Place place){

        Writer writer1 = new Writer();
        writer1.save(place);
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
    public List<Place> findPlaces() {

        List<Place> listOfPlaces = new ArrayList<>();
        List<Persistent> lo = reader.getList(Place.class);

        for (Object o : lo) {
            listOfPlaces.add((Place) o);
        }
        return listOfPlaces;
    }
}
