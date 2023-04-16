package com.singapore.TripPlaner.Service;


import com.singapore.TripPlaner.Model.Opinion;
import com.singapore.TripPlaner.Model.Persistent;
import com.singapore.TripPlaner.Model.Places;
import com.singapore.TripPlaner.Model.User;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpinionService {
    private List opinionsList;
    private Opinion opinion;
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

    public Persistent findById(long id) {
        Persistent opinion = reader.getObjectById(Opinion.class, id);
        return opinion;
    }

    public void editOpinionById(int id, Opinion opinion) {
        Opinion opinionToEdit = (Opinion) reader.getObjectById(Opinion.class, id);


        opinionToEdit.setUserOpinion(opinion.getUserOpinion());
        opinionToEdit.setUserRate(opinion.getUserRate());
        opinionToEdit.setUser(opinion.getUser());
        writer.save(opinionToEdit);
    }

    public void removeOpinionById(long id) {
        Persistent opinionToRemove = reader.getObjectById(Opinion.class, id);
        writer.remove(opinionToRemove);
    }

    public void addOpinion(Opinion opinion, long placeId) {
        opinion.setUser(new User());
        writer.save(opinion);
        Places place = placeService.findById(placeId);
        place.getOpinions().add(opinion.getId());
        setObjectRate(place, opinion);
        writer.save(place);
    }

    private Places setObjectRate(Places place, Opinion opinion) {
        double rate = (place.getOpinions().size() * place.getRate() + opinion.getUserRate()) / (place.getOpinions().size() + 1);
        place.setRate(rate);
        return place;
    }


}



