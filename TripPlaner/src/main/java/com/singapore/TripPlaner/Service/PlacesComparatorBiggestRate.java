package com.singapore.TripPlaner.Service;

import com.singapore.TripPlaner.Model.Places;
import org.springframework.stereotype.Component;

import java.util.Comparator;
@Component
public class PlacesComparatorBiggestRate implements Comparator<Places> {
    @Override
    public int compare(Places o1, Places o2) {
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
