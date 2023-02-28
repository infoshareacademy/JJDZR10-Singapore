package com.infoshareacademy.service;

import com.infoshareacademy.model.City;
import com.infoshareacademy.model.Persistent;
import com.infoshareacademy.service.dataacces.Reader;

import java.util.List;

public class CityViewer  extends Reader {
    public void cityView() {
        List<Persistent> city = getList(City.class);
        for (Persistent o : city) {
            City oParsed = (City) o;
            System.out.println(oParsed);
        }
    }
}
