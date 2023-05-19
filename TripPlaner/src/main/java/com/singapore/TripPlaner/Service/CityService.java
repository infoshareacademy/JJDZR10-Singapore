package com.singapore.TripPlaner.Service;

import com.singapore.TripPlaner.Exception.ObjectNotFoundException;
import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.PersistentAbstract;
import com.singapore.TripPlaner.Repository.CityRepository;
import com.singapore.TripPlaner.Service.dataacces.*;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@Component
public class CityService extends PersistentAbstract {
    private final Reader reader;
    private final Writer writer;
    private final CityRepository cityRepository;

    public CityService(Reader reader, Writer writer, CityRepository cityRepository) {
        this.reader = reader;
        this.writer = writer;
        this.cityRepository = cityRepository;
    }

    public City createCity(City city){
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

    @Transactional
    public City editCityById(City city, Long id){
//        Optional<City> cityById =cityRepository.findById(city.getId());
//        if(cityById.isPresent()){
//            City cityToEdit = cityById.get();
//             cityToEdit.setName(city.getName());
//             cityToEdit.setDescription(city.getDescription());
//            return cityToEdit;
//        }
//        return null;
        City cityToEdit = cityRepository.findById(id).orElseThrow(()->new ObjectNotFoundException("Not found city with given + id"));
        cityToEdit.setName(city.getName());
        cityToEdit.setDescription(city.getDescription());
        cityRepository.save(cityToEdit);
        return cityToEdit;


    }


//    public void createCity(City city) {
//        Writer writer = new Writer();
//        writer.save(city);
//    }
//    public City findById(Long id){
//        Reader reader = new Reader();
//        City city = new City();
//        return city = (City) reader.getObjectById(City.class, id);
//    }

//    public List getCities () {
//        List<Persistent> cities = new ArrayList<>();
//        return cities = reader.getList(City.class);
//
//    }
}