package com.singapore.TripPlaner.Service;

import com.singapore.TripPlaner.Exception.ObjectNotFoundException;
import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Repository.CityRepository;
import com.singapore.TripPlaner.Service.dataacces.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    private final Reader reader;
    private final Writer writer;
    private final CityRepository cityRepository;

    public CityService(Reader reader, Writer writer, CityRepository cityRepository) {
        this.reader = reader;
        this.writer = writer;
        this.cityRepository = cityRepository;
    }

    public City saveCity(City city){
        return cityRepository.save(city);
    }
    public List<City> getCities(){
        return cityRepository.findAll();
    }
    public City findById(Long id){
        Optional <City> cityById = cityRepository.findById(id);
        return cityById.orElseThrow(
                ()->new ObjectNotFoundException("Not found city with given id: " + id));
    }

    public City editCityById(City city, Long id){
        City cityToEdit = cityRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("Not found city with given id: "+ id));
        cityToEdit.setName(city.getName());
        cityToEdit.setDescription(city.getDescription());
        cityRepository.save(cityToEdit);
        return cityToEdit;
    }
    public void deleteCity(Long id){
        cityRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("Not found city with given id: "+ id));
        cityRepository.deleteById(id);
    }
}