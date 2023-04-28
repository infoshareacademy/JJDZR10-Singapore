package com.singapore.TripPlaner.Service;


import com.singapore.TripPlaner.Model.Opinion;
import com.singapore.TripPlaner.Model.Persistent;
import com.singapore.TripPlaner.Model.Places;
import com.singapore.TripPlaner.Model.User;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.*;

@Service
public class OpinionService {
    private List opinionsList;
    private Opinion opinion;
    private final Reader reader;
    private final Writer writer;
    private final PlaceService placeService;
    private final RandomValues randomValues;

    public OpinionService(Opinion opinion, Reader reader, Writer writer, PlaceService placeService, RandomValues randomValues) {
        this.opinion = opinion;
        this.reader = reader;
        this.writer = writer;
        this.placeService = placeService;
        this.randomValues = randomValues;
    }

    public List<Opinion> getOpinions() {
        return opinionsList = reader.getList(Opinion.class);
    }

    public Persistent findById(long id) {
        Persistent opinion = reader.getObjectById(Opinion.class, id);
        return opinion;
    }

    public void editOpinionById(long id, Opinion opinion) {
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

    private void setObjectRate(Persistent objectToReduce, Opinion opinion) {
    }

    public void addOpinion(Opinion opinion) {
        opinion.setUser(opinion.getUser());
        opinion.setUserRate(opinion.getUserRate());
        writer.save(opinion);
    }

    public Double setObjectRate(Opinion opinion, List opinionsList, double objectRate) {
        double rate = (opinionsList.size() * objectRate + opinion.getUserRate()) / (opinionsList.size());
        rate = Math.round(rate*10)/10;
        return rate;
    }


    public List randomOpinions(int numberOfOpinions, List opinionsListByObject){
        List outputList = randomValues.outputList(numberOfOpinions, opinionsListByObject);
        return outputList;
    }

    public Object getObjectByOpinionId(double opinionId, List listToSearch, List opinionsList) throws NullPointerException {
        Object objectByOpinionId = null;
        for (long i = 0; i < listToSearch.size(); i++) {
            objectByOpinionId = listToSearch.get((int) i);
            if (opinionsList.contains(opinionId)) {
                break;
            }
        }
        return objectByOpinionId;
    }
}

