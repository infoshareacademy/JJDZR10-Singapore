package com.singapore.TripPlaner.Service;


import com.singapore.TripPlaner.Model.Opinion;
import com.singapore.TripPlaner.Model.Persistent;
import com.singapore.TripPlaner.Model.User;
import com.singapore.TripPlaner.Model.Places;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpinionService {
    private long userId;
    private String userOpinion;
    private Integer userRate;
    private User user;
    private List opinionsList;
    private final Reader reader;
    private final Writer writer;
    private final PlaceService placeService;

    public OpinionService(Reader reader, Writer writer, PlaceService placeService) {
        this.reader = reader;
        this.writer = writer;
        this.placeService = placeService;
    }

    public List<Opinion> getOpinions() {
        return opinionsList = reader.getList(Opinion.class);
    }

    public Opinion findById(int id) {
        Opinion opinion = getOpinions().get(id);
        return opinion;
    }

    public void editOpinionById(int id, Opinion opinion) {
        Opinion opinionToEdit = getOpinions().get(id);

        opinionToEdit.setUserOpinion(opinion.getUserOpinion());
        opinionToEdit.setUserRate(opinion.getUserRate());
        opinionToEdit.setUserId(opinion.getUserId());
        writer.save(opinionToEdit);
    }

    public void removeOpinionById(int id) {
        opinionsList=getOpinions();
        Opinion opinionToRemove = getOpinions().get(id);
        // TODO zapisanie do jsona
    }

    public void addOpinionToPlace(Opinion opinion) {
//        Places place = placeService.findById(placeId);

        writer.save(opinion);

//        place.getOpinions().add(opinion.getId());
//        setObjectRate(placeId);
//        writer.save(place);
    }

    private void setObjectRate (Long placeId){
        Places place = placeService.findById(placeId);
        double rate = (place.getNumberOfOpinions()*place.getRate()+userRate)/(place.getNumberOfOpinions()+1);
        place.setRate(rate);
        place.setNumberOfOpinions(place.getNumberOfOpinions() + 1);
    }


}



