package com.singapore.TripPlaner.Service;

import com.singapore.TripPlaner.Model.Persistent;
import com.singapore.TripPlaner.Model.Trip;
import com.singapore.TripPlaner.Model.TripPoint;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
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

    /**
     * Medoda wyciąga wszystkie trippointy przypisane do danego tripa
     * @param trip
     * @param sortByPosition
     * @return
     */
    public List<TripPoint> getTripPoints(Trip trip, boolean sortByPosition) {
        List<Persistent> tpList = reader.getList(TripPoint.class);
        List<TripPoint> tpListRet = new ArrayList<TripPoint>();
        for (Object o: tpList) {
            TripPoint tripPoint = (TripPoint) o;
            if(tripPoint.getTrip().getId() == trip.getId()) {
                tpListRet.add(tripPoint);
            }
        }
        if(sortByPosition){
            Collections.sort(tpListRet);
        }

        return tpListRet;
    }
    public Trip findById(long id ){
        return (Trip) reader.getObjectById(Trip.class, id);
    }
    public TripPoint findTpById(long id ){
        return (TripPoint) reader.getObjectById(TripPoint.class, id);
    }

    public void removeTpFromTrip(TripPoint tripPoint){
        Trip trip = tripPoint.getTrip();
        writer.remove(tripPoint);
        List<TripPoint> tripPoints = getTripPoints(trip);
        int idx = 1;
        for(TripPoint tp: tripPoints){
            tp.setPosition(idx);
            idx++;
            writer.save(tp);
        }
    }
    public void removeTrip(Trip trip){
        List<TripPoint> tripPoints = getTripPoints(trip);
        for(TripPoint tripPoint: tripPoints){
            writer.remove(tripPoint);
        }
        writer.remove(trip);
    }

}
