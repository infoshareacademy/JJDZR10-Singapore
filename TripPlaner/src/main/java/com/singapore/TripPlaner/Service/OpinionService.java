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
        Places reducedPlace = getPlaceByOpinionId(id);
        List opinionsBeforeRemove = reducedPlace.getOpinions();
        List opinionsAfterRemove = new ArrayList<>();
        for (int i=0; i<opinionsBeforeRemove.size(); i++) {
            if (!(opinionsBeforeRemove.get(i).equals((double) id))){
                opinionsAfterRemove.add(opinionsBeforeRemove.get(i));
            }
        }
        reducedPlace.setOpinions(opinionsAfterRemove);
        setObjectRate(reducedPlace, new Opinion("", 0, opinion.getUser()));
        writer.save(reducedPlace);
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


    public List randomOpinions(int numberOfOpinions, long placeId) {
        Places place = placeService.findById(placeId);
        List inputList =  place.getOpinions();
        List outputList = randomValues.outputList(numberOfOpinions, inputList);
        return outputList;
    }

    public Places getPlaceByOpinionId(double opinionId) {
        List<Places> places = reader.getAllPlaces(Places.class);
        Places placeByOpinionId = null;
        for (long i = 1; i < places.size(); i++) {
            placeByOpinionId = (Places) reader.getObjectById(Places.class, i);
            if (placeByOpinionId.getOpinions().contains(opinionId)) {
                break;
            }
        }
        return placeByOpinionId;
    }
    public void opinionAttributes(Model model, Long id, int number) {
        model.addAttribute("opinion", new Opinion());
        model.addAttribute("placeId", id);
        List opinions = randomOpinions(number, id);
        model.addAttribute("opinions", opinions);
        User user = new User();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpinionService that = (OpinionService) o;
        return Objects.equals(opinionsList, that.opinionsList) && Objects.equals(opinion, that.opinion) && Objects.equals(reader, that.reader) && Objects.equals(writer, that.writer) && Objects.equals(placeService, that.placeService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(opinionsList, opinion, reader, writer, placeService);
    }
}



