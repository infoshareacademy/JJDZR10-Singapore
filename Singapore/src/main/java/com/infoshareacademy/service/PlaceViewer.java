package com.infoshareacademy.service;

import com.infoshareacademy.model.Persistent;
import com.infoshareacademy.model.Places;
import com.infoshareacademy.service.dataacces.Reader;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PlaceViewer extends Reader {
    public void placesViewForCity(int index) {
        List<Places> place = getListOfPlaces(Places.class);
        System.out.println(place.stream().filter(p -> p.getFromCity() == index).collect(Collectors.toList()));
    }

    public void placesViewAll() {
        List<Persistent> place = getList(Places.class);
        for (Persistent o : place) {
            Places oParsed = (Places) o;
            System.out.println(oParsed);
        }
    }

    public void findAllPlacesByCity(int index) {
        List<Places> place = getListOfPlaces(Places.class);
        List <Places> filteredList = place.stream().filter(p -> p.getFromCity() == index).collect(Collectors.toList());
        Function<Places, String> onlyName = s -> s.getName();
        List<String> namesOfPlaces = filteredList.stream().map(onlyName).collect(Collectors.toList());
        namesOfPlaces.forEach(s -> System.out.println(s));

    }
}
