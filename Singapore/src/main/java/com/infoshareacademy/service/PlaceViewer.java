package com.infoshareacademy.service;

import com.infoshareacademy.model.Persistent;
import com.infoshareacademy.model.Places;
import com.infoshareacademy.service.dataacces.Reader;

import java.util.List;

public class PlaceViewer extends Reader {
    public void placesView() {
        List<Persistent> place = getList(Places.class);
        for (Persistent o : place) {
            Places oParsed = (Places) o;
            System.out.println(oParsed);
        }
    }
    public void placesViewByCityId(long id){
        }


}
