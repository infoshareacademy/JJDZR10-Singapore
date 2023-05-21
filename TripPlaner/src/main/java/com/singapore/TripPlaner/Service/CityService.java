package com.singapore.TripPlaner.Service;

import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Persistent;
import com.singapore.TripPlaner.Model.PersistentAbstract;
import com.singapore.TripPlaner.Service.dataacces.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CityService extends PersistentAbstract {
    private final Reader reader;
    private final Writer writer;

    public CityService(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void createCity(City city) {
        Writer writer = new Writer();
        writer.save(city);
    }
    public City findById(Long id){
        Reader reader = new Reader();
        City city = new City();
        return city = (City) reader.getObjectById(City.class, id);
    }

    public List getAllCities() {
        List<Persistent> cities = new ArrayList<>();
        return cities = reader.getList(City.class);
    }

    public void editCityById(City city) {
        City cityToEdit = findById(city.getId());

        cityToEdit.setName(city.getName());
        cityToEdit.setDescription(city.getDescription());

        writer.save(cityToEdit);
    }

}