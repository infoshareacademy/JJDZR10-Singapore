package com.singapore.TripPlaner.Service;

import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Place;
import com.singapore.TripPlaner.Exception.ObjectNotFoundException;

import com.singapore.TripPlaner.Repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class PlaceService {

    private final PlaceRepository placeRepository;


    public PlaceService(PlaceRepository placeRepository) {

        this.placeRepository = placeRepository;

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


    public void editPlaceById(Place place, Long id) {
        Place placeToEdit = placeRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Not found place with given id: " + id));
        placeToEdit.setName(place.getName());
        placeToEdit.setDescription(place.getDescription());
        placeToEdit.setRate(place.getRate());
        placeToEdit.setPrice(place.getPrice());
        placeToEdit.setType(place.getType());
        placeRepository.save(placeToEdit);
    }

    public List<Place> filterListByTypeOfPlace(String placeType) {
        return findPlaces().stream()
                .filter(p -> p.getType().getPlaceType().toLowerCase().equals(placeType.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Place> findPlacesByCityId(Long cityId) {
        List<Place> allPlaces = findPlaces();
        allPlaces.stream().filter(place -> place.getCity().getId() == cityId).findAny().orElseThrow(() -> new ObjectNotFoundException("Not found place with given city_id: " + cityId));
        return allPlaces.stream()
                .filter(place -> place.getCity().getId() == cityId)
                .collect(Collectors.toList());
    }

    public List<Place> findPlacesByCity(City city) {
        return placeRepository.findAllByCity(city);

    }

    public String getTypeOfPlace(Place place) {
        return place.getType().getPlaceType();
    }
}

