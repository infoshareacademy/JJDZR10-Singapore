package com.singapore.TripPlaner.Service;

import com.singapore.TripPlaner.Model.Place;
import com.singapore.TripPlaner.Exception.ObjectNotFoundException;
import com.singapore.TripPlaner.Repository.PlaceRepository;
import com.singapore.TripPlaner.Service.comparators.PlacesComparatorBiggestRate;
import com.singapore.TripPlaner.Service.comparators.PlacesComparatorMostPopular;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class PlaceService {
    private final PlacesComparatorBiggestRate placesComparatorBiggestRate;
    private final PlacesComparatorMostPopular placesComparatorMostPopular;
    private final PlaceRepository placeRepository;
    private final RandomValues randomValues;

    public PlaceService(PlacesComparatorBiggestRate placesComparatorBiggestRate, PlacesComparatorMostPopular placesComparatorMostPopular, PlaceRepository placeRepository, RandomValues randomValues) {
        this.placesComparatorBiggestRate = placesComparatorBiggestRate;
        this.placesComparatorMostPopular = placesComparatorMostPopular;
        this.placeRepository = placeRepository;
        this.randomValues = randomValues;
    }


    public Place createPlace(Place place) {
        return placeRepository.save(place);
    }

    public List<Place> findPlaces() {
        return placeRepository.findAll();
    }

    public Place findById(Long id) {
        Optional<Place> placeById = placeRepository.findById(id);
        return placeById.orElseThrow(() -> new ObjectNotFoundException("Not found place with given id:" + id));
    }

    public void deletePlace(Long id) {
        findById(id);
        placeRepository.deleteById(id);
    }


    public Place editPlaceById(Place place, Long id) {
        Place placeToEdit = placeRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Not found place with given id: " + id));
        placeToEdit.setName(place.getName());
        placeToEdit.setDescription(place.getDescription());
        placeToEdit.setRate(place.getRate());
        placeToEdit.setPrice(place.getPrice());
        placeToEdit.setType(place.getType());
        placeRepository.save(placeToEdit);
        return placeToEdit;
    }


    //TODO sortowanie wg najlepszej oceny dla miejsca, zrobić kontroler po dodaniu serwis opinii
    public List<Place> getTopRatedPlaces() {
        List<Place> places = findPlaces();
        Collections.sort(places, placesComparatorBiggestRate);
        return places;
    }

    //TODO sortowanie wg najwiekszej ilosci komentarzy dla miejsca, zrobić kontroler po dodaniu serwis opinii
    public List<Place> getMostPopularPlaces() {
        List<Place> places = findPlaces();
        Collections.sort(places, placesComparatorMostPopular);
        return places;
    }

    public List<Place> filterListByTypeOfPlace(String placeType) {
        return findPlaces().stream()
                .filter(p -> p.getType().getPlaceType().toLowerCase().equals(placeType.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * @param cityId
     * @return lista places danego miasta
     */
    public List<Place> findPlacesByCityId(Long cityId) {
        List<Place> allPlaces = findPlaces();
        return allPlaces.stream()
                .filter(place -> place.getCity().getId() == cityId)
                .collect(Collectors.toList());
    }
}

