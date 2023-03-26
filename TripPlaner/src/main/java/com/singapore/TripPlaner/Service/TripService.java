package com.singapore.TripPlaner.Service;

import com.singapore.TripPlaner.Model.Persistent;
import com.singapore.TripPlaner.Model.Trip;
import com.singapore.TripPlaner.Model.TripPoint;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TripService {

    private final Reader reader;
    private final Writer writer;

    public TripService(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }


    public List<TripPoint> getTripPoints(Trip trip) {
        return getTripPoints(trip, true);

    }
    public List<TripPoint> getTripPoints(Trip trip, boolean sortByPosition) {
        List<Persistent> tpList = reader.getList(TripPoint.class);
        List<TripPoint> tpListRet = new ArrayList<TripPoint>();
        for (Object o: tpList) {
            TripPoint tripPoint = (TripPoint) o;
            if(tripPoint.getTrip().getId() == trip.getId()) {
                tpListRet.add(tripPoint);
            }
        }

        return tpListRet;
    }
    public Trip findById(long id ){
        return (Trip) reader.getObjectById(Trip.class, id);
    }

}
