package com.singapore.TripPlaner.Service;

import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Place;
import com.singapore.TripPlaner.Exception.ObjectNotFoundException;
import com.singapore.TripPlaner.Repository.PlaceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class PlaceService {
    private static final Logger logger = LoggerFactory.getLogger(PlaceService.class);

    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public Place createPlace(Place place) {
        logger.info("Place created: {}",place.getName());
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
        logger.info("Removed place with id: {}", place.getId());
        try {
            placeRepository.deleteById(place.getId());
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException("Not found place with given id:" + place.getId());
        }
    }

    public void editPlaceById(Place place) {
        logger.info("Edited city with id: {} ", place.getId());
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
                .findAny()
                .orElseThrow(() -> new ObjectNotFoundException("Not found place with given city_id: " + cityId));
        return findPlaces().stream().filter(place -> place.getCity().getId() == cityId)
                .collect(Collectors.toList());
    }

    public List<Long> getIdsExept(List<Long> listOfIds, City city) {
        return placeRepository.getIdsInCityExept(listOfIds, city);
    }

    public List<Long> getAllIds(City city) {
        return placeRepository.getAllIdsInCity(city);
    }
}

