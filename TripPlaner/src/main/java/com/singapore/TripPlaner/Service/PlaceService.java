package com.singapore.TripPlaner.Service;

import com.singapore.TripPlaner.Model.Place;
import com.singapore.TripPlaner.Exception.ObjectNotFoundException;
import com.singapore.TripPlaner.Repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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
        return placeRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Not found place with given id:" + id));
    }

    public void deletePlace(Place place) {
        try {
            placeRepository.deleteById(place.getId());
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Not found place with given id:" + place.getId());
        }
    }

    public void editPlaceById(Place place) {
        Place placeToEdit = placeRepository.findById(place.getId()).orElseThrow(() -> new ObjectNotFoundException("Not found place with given id: " + place.getId()));
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
        findPlaces().stream().filter(place -> place.getCity().getId() == cityId)
                .findAny().orElseThrow(() -> new ObjectNotFoundException("Not found place with given city_id: " + cityId));
        return findPlaces().stream().filter(place -> place.getCity().getId() == cityId)
                .collect(Collectors.toList());
    }
}

