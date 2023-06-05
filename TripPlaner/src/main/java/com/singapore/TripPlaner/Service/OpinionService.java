package com.singapore.TripPlaner.Service;


import com.singapore.TripPlaner.Exception.OpinionNotFoundException;
import com.singapore.TripPlaner.Model.Opinion;
import com.singapore.TripPlaner.Model.Place;
import com.singapore.TripPlaner.Repository.OpinionRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OpinionService {
    private final RandomValues randomValues;
    private final OpinionRepository opinionRepository;

    public OpinionService(RandomValues randomValues, OpinionRepository opinionRepository) {
        this.randomValues = randomValues;
        this.opinionRepository = opinionRepository;
    }

    public List getAllOpinions() {
        return opinionRepository.findAll();
    }

    public Opinion findById(long id) {
        return opinionRepository.findById(id)
                .orElseThrow(() -> new OpinionNotFoundException("Not found Opinion with given id: " + id));
    }

    public void editPlaceOpinionById(long id, Opinion opinion, Place place) {
        Opinion opinionToEdit = findById(id);
        opinionToEdit.setOpinion(opinion.getOpinion());
        opinionToEdit.setRate(opinion.getRate());
        opinionRepository.save(opinionToEdit);
    }

    public void removePlaceOpinionById(long id, Place place) {
        Opinion opinionToDelete = findById(id);
        opinionRepository.delete(opinionToDelete);
        place.setRate(setPlaceRateThenRemoveOpinion(opinionToDelete, place));
    }

    @Transactional
    public void addOpinionToPlace(Opinion opinion, Place place) {
        opinionRepository.save(opinion);
        place.setRate(setPlaceRateThenAddOpinion(opinion, place));
        opinion.setPlace(place);
        place.getOpinions().add(opinion);
    }

    private double setPlaceRateThenAddOpinion(Opinion opinion, Place place) {
        long opinionCounts = opinionRepository.findAllOpinionByPlace(place).size();
        double rate = (place.getRate() + opinion.getRate()) / opinionCounts;
        rate *= 10;
        rate = Math.round(rate) / 10;
        return rate;
    }

    private double setPlaceRateThenRemoveOpinion(Opinion opinion, Place place) {
        long opinionCounts = opinionRepository.findAllOpinionByPlace(place).size();
        double rate = (place.getRate() - opinion.getRate()) / opinionCounts;
        rate *= 10;
        rate = Math.round(rate) / 10;
        return rate;
    }

    public Opinion getRandomOpinion(Place place) {
        return randomValues.randomObjectFromList(opinionRepository.findAllOpinionByPlace(place));
    }
}
