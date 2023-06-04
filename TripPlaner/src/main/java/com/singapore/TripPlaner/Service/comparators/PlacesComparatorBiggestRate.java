package com.singapore.TripPlaner.Service.comparators;

import com.singapore.TripPlaner.Model.Place;
import org.springframework.stereotype.Component;

import java.util.Comparator;
@Component
public class PlacesComparatorBiggestRate implements Comparator<Place> {
    @Override
    public int compare(Place o1, Place o2) {
        int compareResult = Double.compare(o2.getRate(), o1.getRate());
        if (compareResult == 0) {
            compareResult = Integer.compare(o2.getNumberOfOpinions(),o1.getNumberOfOpinions());
        }
        if (compareResult == 0) {
            compareResult = o1.getName().compareToIgnoreCase(o2.getName());
        }
        return compareResult;
    }
}
