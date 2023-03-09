package com.infoshareacademy.service;

import com.infoshareacademy.model.Persistent;
import com.infoshareacademy.model.Places;
import com.infoshareacademy.service.dataacces.Reader;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PlaceService extends Reader {
    public void findAllPlacesByCity(int index) {
        List<Places> place = getAllPlaces(Places.class);
        System.out.println(place.stream().filter(p -> p.getFromCity() == index).collect(Collectors.toList()));
    }

    public void findAllPlaces() {
        List<Persistent> place = getList(Places.class);
        for (Persistent listOfPlaces : place) {
            Places oParsed = (Places) listOfPlaces;
            System.out.println(oParsed);
        }
    }

    public void findAllPlacesByCityOnlyNames(int index) {
        List<Places> place = getAllPlaces(Places.class);
        List <Places> filteredList = filterListByCityIndex(index, place);
        showOnlyNamesCity(filteredList).forEach(s -> System.out.println(s));

    }
    private List<Places> filterListByCityIndex (int index, List <Places> place){
        List <Places> filteredList = place.stream().filter(p -> p.getFromCity() == index).collect(Collectors.toList());
        return filteredList;
    }
    private List<String> showOnlyNamesCity (List <Places> list){
        Function<Places, String> onlyName = s -> s.getName();
        List<String> namesOfPlaces = list.stream().map(onlyName).collect(Collectors.toList());
        return namesOfPlaces;
    }
}
