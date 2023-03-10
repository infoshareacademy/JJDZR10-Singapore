package com.infoshareacademy.service;

import com.infoshareacademy.model.City;
import com.infoshareacademy.model.Persistent;
import com.infoshareacademy.service.dataacces.Reader;

import java.util.List;

public class CityService extends Reader {
    public void findAllCities() {
        List<Persistent> city = getList(City.class);
        for (Persistent listOfCity : city) {
            City oParsed = (City) listOfCity;
            System.out.println(oParsed);
        }
    }
}
