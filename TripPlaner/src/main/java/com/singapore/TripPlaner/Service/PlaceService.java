package com.singapore.TripPlaner.Service;

import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Persistent;
import com.singapore.TripPlaner.Model.PersistentAbstract;
import com.singapore.TripPlaner.Model.Places;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PlaceService {

    private final Reader reader;
    private final Writer writer;

    public PlaceService(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;

    }

    public List<Places> findPlaces() {

        List<Places> listOfPlaces = new ArrayList<>();
        List<Persistent> lo = reader.getList(Places.class);

        for (Object o : lo) {
            Places place = (Places) o;
            listOfPlaces.add(place);
        }
        return listOfPlaces;
    }

    public List<Places> findPlacesByCityId(Long cityId) {

        List<Places> allPlaces = findPlaces();
        List<Places> listPlacesByCity = new ArrayList<>();

        for (Places place : allPlaces) {

            if(place.getCity().getId()==cityId){
                listPlacesByCity.add(place);
            }

        }
        return listPlacesByCity;
    }


}


