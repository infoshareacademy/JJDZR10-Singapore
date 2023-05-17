package com.singapore.TripPlaner.Service;


import com.singapore.TripPlaner.Controller.PlaceController;
import com.singapore.TripPlaner.Model.*;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import com.singapore.TripPlaner.Exception.OpinionNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpinionService extends PersistentAbstract {
    private final Reader reader;
    private final Writer writer;
    private final PlaceService placeService;
    private final RandomValues randomValues;

    public OpinionService(Reader reader, Writer writer, PlaceService placeService, RandomValues randomValues) {
        this.reader = reader;
        this.writer = writer;
        this.placeService = placeService;
        this.randomValues = randomValues;
    }

    public List getAllOpinions() {
            return reader.getList(Opinion.class);
    }

    public Opinion findById(long id) {
        return (Opinion) reader.getList(Opinion.class).stream()
                .filter(s->s.getId()==id)
                .findFirst()
                .orElseThrow(()-> new OpinionNotFoundException("Not found Opinion with given id: " + id));
    }

    public void editOpinionById(long id, Opinion opinion) {
        Opinion opinionToEdit = (Opinion) reader.getObjectById(Opinion.class, id);
        opinionToEdit.setUserOpinion(opinion.getUserOpinion());
        opinionToEdit.setUserRate(opinion.getUserRate());
        opinionToEdit.setUser(opinion.getUser());
        writer.save(opinionToEdit);
    }

    public void removeOpinionById(long id) {
        writer.remove(findById(id));
    }

    public void addOpinionToPlace(Opinion opinion, Places place) {
        writer.save(opinion);
        place.getOpinions().add(opinion.getId());
        setPlaceRate(opinion,place);
        writer.save(place);
    }

    public void setPlaceRate(Opinion opinion, Places place) {
        double rate = ((place.getOpinions().size()-1) * place.getRate() + opinion.getUserRate()) /(place.getOpinions().size());
        rate *= 10;
        rate =  Math.round(rate)/10;
        place.setRate(rate);
    }

    public List randomOpinions(int numberOfOpinions, List opinionsListByObject){
        List outputList = randomValues.outputList(numberOfOpinions, opinionsListByObject);
        return outputList;
    }

    public Opinion getRandomOpinionFromPlace(Places place) {
        long opinionId= (long) randomOpinions(1, place.getOpinions()).get(0);
        return findById(opinionId);
    }
}

