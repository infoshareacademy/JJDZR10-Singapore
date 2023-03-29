package com.singapore.TripPlaner.Service;


import com.singapore.TripPlaner.Exception.PlaceNotFoundException;
import com.singapore.TripPlaner.Model.*;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PlaceService extends PersistentAbstract {
    private final Reader reader;
    private final Writer writer;

    public PlaceService(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }
    public List<Places> getPlace() {
        List<Places> places = reader.getAllPlaces(Places.class);
        return places;
    }

    public List<Places> filterListByTypeOfPlace(String placeType, List<Places> place) {
        return place.stream().filter(p -> p.getType().getPlaceType().toLowerCase().equals(placeType.toLowerCase())).collect(Collectors.toList());
    }
    public Places findById(Long id) {
        return reader.getAllPlaces(Places.class).
                stream().filter(places -> places.getId() == id).
                findFirst().orElseThrow(() -> new PlaceNotFoundException("Nie ma takiego obiektu"));
    }
}
