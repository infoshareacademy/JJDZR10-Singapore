package com.singapore.TripPlaner.Service.comparators;

import com.singapore.TripPlaner.Model.Places;
import org.springframework.stereotype.Component;
import java.util.Comparator;

@Component
public class PlacesComparatorMostPopular implements Comparator<Places> {
    @Override
    public int compare(Places o1, Places o2) {
        int compareResult = Integer.compare(o2.getOpinions().size(),o1.getOpinions().size());
        if (compareResult == 0) {
            compareResult = Double.compare(o2.getRate(), o1.getRate());
        }
        if (compareResult == 0) {
            compareResult = o1.getName().compareToIgnoreCase(o2.getName());
        }
        return compareResult;
    }
}

