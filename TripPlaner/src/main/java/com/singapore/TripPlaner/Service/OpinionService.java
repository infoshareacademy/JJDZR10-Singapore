package com.singapore.TripPlaner.Service;


import com.singapore.TripPlaner.Model.Opinion;
import com.singapore.TripPlaner.Model.Persistent;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpinionService {
    private List opinionsList;
    private final Opinion opinion;
    private final Reader reader;
    private final Writer writer;
    private final PlaceService placeService;

    public OpinionService(Opinion opinion, Reader reader, Writer writer, PlaceService placeService) {
        this.opinion = opinion;
        this.reader = reader;
        this.writer = writer;
        this.placeService = placeService;
    }

    public List<Opinion> getOpinions() {
        return opinionsList = reader.getList(Opinion.class);
    }

    public Persistent findById(int id) {
        Persistent opinion = reader.getObjectById(Opinion.class, id);
        return opinion;
    }

    public void editOpinionById(int id, Opinion opinion) {
        Opinion opinionToEdit = (Opinion) reader.getObjectById(Opinion.class, id);


        opinionToEdit.setUserOpinion(opinion.getUserOpinion());
        opinionToEdit.setUserRate(opinion.getUserRate());
        opinionToEdit.setUserId(opinion.getUserId());
        writer.save(opinionToEdit);
    }

    public void removeOpinionById(int id) {
        Persistent opinionToRemove = reader.getObjectById(Opinion.class, id);
        writer.remove(opinionToRemove);
    }

    public void addOpinion(Opinion opinion) {
//        Places place = placeService.findById(placeId);
        writer.save(opinion);

//        place.getOpinions().add(opinion.getId());
//        setObjectRate(placeId);
//        writer.save(place);
    }

//    private void setObjectRate (Long placeId){
//        Places place = placeService.findById(placeId);
//        double rate = (place.getNumberOfOpinions()*place.getRate()+userRate)/(place.getNumberOfOpinions()+1);
//        place.setRate(rate);
//        place.setNumberOfOpinions(place.getNumberOfOpinions() + 1);
//    }


}



