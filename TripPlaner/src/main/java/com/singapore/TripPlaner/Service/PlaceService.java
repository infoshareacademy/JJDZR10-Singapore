package com.singapore.TripPlaner.Service;


import com.singapore.TripPlaner.Model.*;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
@Component
public class PlaceService extends PersistentAbstract{
    private final Reader reader;
    private final Writer writer;

    public PlaceService(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void findAllPlacesByCity(int index) {
        List<Places> place = reader.getAllPlaces(Places.class);
        System.out.println(place.stream().filter(p -> p.getCityid() == index).collect(Collectors.toList()));
    }
    public List<Places> getPlace(){
        List <Places> places = reader.getAllPlaces(Places.class);
        return places;
    }

    public List<Places> filterListByCityIndex(int index, List<Places> place) {
        return place.stream().filter(p -> p.getCityid() == index).collect(Collectors.toList());
    }

    public List<Places> filterListByTypeOfPlace(int index, List<Places> place) {
        return place.stream().filter(p -> p.getType() == index).collect(Collectors.toList());
    }
    public Places findById(Long id){
        return (Places) reader.getObjectById(Places.class,id);
    }
}
