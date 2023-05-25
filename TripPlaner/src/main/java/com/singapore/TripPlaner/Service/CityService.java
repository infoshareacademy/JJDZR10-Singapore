package com.singapore.TripPlaner.Service;

import com.singapore.TripPlaner.Exception.ObjectNotFoundException;
import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City createCity(City city) {
        return cityRepository.save(city);
    }

    public List<City> getCities() {
        return cityRepository.findAll();
    }

    public City findById(Long id) {
        Optional<City> cityById = cityRepository.findById(id);
        return cityById.orElseThrow(
                () -> new ObjectNotFoundException("Not found city with given id: " + id));
    }

    public void editCityById(City city) {
        City cityToEdit = cityRepository.findById(city.getId()).orElseThrow(
                () -> new ObjectNotFoundException("Not found city with given id: " + city.getId()));
        cityToEdit.setName(city.getName());
        cityToEdit.setDescription(city.getDescription());
        cityRepository.save(cityToEdit);
    }

    public void deleteCity(Long id) {
        cityRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Not found city with given id: " + id));
        cityRepository.deleteById(id);
    }
}