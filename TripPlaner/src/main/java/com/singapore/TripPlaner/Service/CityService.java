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

//    public void findAllCities() {
//        List<Persistent> city = getList(City.class);
//        for (Persistent listOfCity : city) {
//            City oParsed = (City) listOfCity;
//            System.out.println(oParsed);
//        }
//    }
//    public void showCityNameById(int index) {
//        List<City> city = getAllCities(City.class);
//        List<City> filteredList = filterListByCityIndex(index, city);
//        showOnlyNameOfCity(filteredList).forEach(System.out::println);
//    }

//
//    private List<City> filterListByCityIndex(int index, List<City> place) {
//        return place.stream().filter(p -> p.getId() == index).collect(Collectors.toList());
//    }
//    private List<String> showOnlyNameOfCity (List<City> list){
//        Function<City, String> onlyName = s->s.getName();
//        return list.stream().map(onlyName).collect(Collectors.toList());
//    }

    public void createCity(City city) {
        Writer writer = new Writer();
        writer.save(city);
    }
    public City findById(Long id){
        Reader reader = new Reader();
        City city = new City();
        return city = (City) reader.getObjectById(City.class, id);
    }

    public List getCities () {
        List<Persistent> cities = new ArrayList<>();
        return cities = reader.getList(City.class);

    }
}