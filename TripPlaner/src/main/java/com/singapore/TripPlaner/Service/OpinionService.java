package com.singapore.TripPlaner.Service;


import com.singapore.TripPlaner.Exception.OpinionNotFoundException;
import com.singapore.TripPlaner.Model.Opinion;
import com.singapore.TripPlaner.Model.Place;
import com.singapore.TripPlaner.Repository.OpinionRepository;
import com.singapore.TripPlaner.Repository.PlaceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OpinionService {
    private static final Logger logger = LoggerFactory.getLogger(OpinionService.class);

    private final RandomValues randomValues;
    private final OpinionRepository opinionRepository;
    private final PlaceRepository placeRepository;

    public OpinionService(RandomValues randomValues, OpinionRepository opinionRepository, PlaceRepository placeRepository) {
        this.randomValues = randomValues;
        this.opinionRepository = opinionRepository;
        this.placeRepository = placeRepository;
    }

    public List <Opinion> getAllOpinions() {
        return opinionRepository.findAll();
    }

    public Opinion findById(long id) {
        return opinionRepository.findById(id)
                .orElseThrow(() -> new OpinionNotFoundException("Not found Opinion with given id: " + id));
    }

    public void editPlaceOpinionById(long id, Opinion opinion, Place place) {
        logger.info("Edited opinion for place with id: {} ", opinion.getOpinionId());
        Opinion opinionToEdit = findById(id);
        opinionToEdit.setComment(opinion.getComment());
        opinionToEdit.setRate(opinion.getRate());
        opinionRepository.save(opinionToEdit);
    }

    public void removePlaceOpinionById(long id, Place place) {
        logger.info("Removed opinion for place with id: {} ", id);
        Opinion opinionToDelete = findById(id);
        opinionRepository.delete(opinionToDelete);
        place.setRate(setPlaceRateThenRemoveOpinion(opinionToDelete, place));
    }

    @Transactional
    public void addOpinionToPlace(Opinion opinion, Place place) {
        logger.info("Added opinion {} for place with id: {} ", opinion.getComment(), place.getId());
        place.setRate(setPlaceRateWithOpinionRate(opinion, place));
        opinion.setPlace(place);
        opinionRepository.save(opinion);
        List <Opinion> opinions = new ArrayList<>(place.getOpinions());
        opinions.add(opinion);
        place.setOpinions(opinions);
        placeRepository.save(place);
    }

    private double setPlaceRateWithOpinionRate(Opinion opinion, Place place) {
        logger.info("Set new rate for place with id: {} ", place.getId());
        long opinionCounts = opinionRepository.findAllOpinionByPlace(place).size();
        double rate = (place.getRate() + opinion.getRate()) / opinionCounts;
        rate *= 10;
        rate = Math.round(rate) / 10;
        return rate;
    }

    private double setPlaceRateThenRemoveOpinion(Opinion opinion, Place place) {
        logger.info("Set new rate for place with id: {} ", place.getId());
        long opinionCounts = opinionRepository.findAllOpinionByPlace(place).size();
        double rate = (place.getRate() - opinion.getRate()) / opinionCounts;
        rate *= 10;
        rate = Math.round(rate) / 10;
        return rate;
    }

    public Opinion getRandomOpinion(Place place) throws OpinionNotFoundException{
        List<Opinion> opinionByPlace = opinionRepository.findAllOpinionByPlace(place);
        if(opinionByPlace.isEmpty()){
            return new Opinion("Dodaj pierwszą opinie");
        }
        return randomValues.randomObjectFromList(opinionByPlace);
    }
}
