package com.singapore.TripPlaner.Service;

import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Persistent;
import com.singapore.TripPlaner.Model.PersistentAbstract;
import com.singapore.TripPlaner.Service.dataacces.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
@Component
public class CityService extends PersistentAbstract {
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

    public void addCity(City city) {
//        Reader reader = new Reader();
//        Persistent cityPersistent = (Persistent) reader.getList(City.class);
//        List <City> cityList = (List<City>) cityPersistent;
//        cityList.add(city);
        Writer writer = new Writer();
        writer.save((Persistent) city);
    }
}