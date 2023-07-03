package com.singapore.TripPlaner.Service;


import com.singapore.TripPlaner.Exception.OpinionNotFoundException;
import com.singapore.TripPlaner.Model.Opinion;
import com.singapore.TripPlaner.Model.Place;
import com.singapore.TripPlaner.Model.User.User;
import com.singapore.TripPlaner.Repository.OpinionRepository;
import com.singapore.TripPlaner.Repository.PlaceRepository;
import com.singapore.TripPlaner.Repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OpinionService {
    private final RandomValues randomValues;
    private final OpinionRepository opinionRepository;
    private final PlaceRepository placeRepository;
    private final UserRepository userRepository;

    public OpinionService(RandomValues randomValues, OpinionRepository opinionRepository, PlaceRepository placeRepository, UserRepository userRepository) {
        this.randomValues = randomValues;
        this.opinionRepository = opinionRepository;
        this.placeRepository = placeRepository;
        this.userRepository = userRepository;
    }

    public List <Opinion> getAllOpinions() {
        return opinionRepository.findAll();
    }

    public Opinion findById(long id) {
        return opinionRepository.findById(id)
                .orElseThrow(() -> new OpinionNotFoundException("Not found Opinion with given id: " + id));
    }

    public void editPlaceOpinionById(long id, Opinion opinion, Place place) {
        Opinion opinionToEdit = findById(id);
        opinionToEdit.setComment(opinion.getComment());
        opinionToEdit.setRate(opinion.getRate());
        opinionRepository.save(opinionToEdit);
    }

    public void removePlaceOpinionById(long id, Place place) {
        Opinion opinionToDelete = findById(id);
        opinionRepository.delete(opinionToDelete);
        place.setRate(setPlaceRateThenRemoveOpinion(opinionToDelete, place));
    }

    @Transactional
    public void addOpinionToPlace(Opinion opinion, Place place, User user) {
        List <Opinion> userOpinions = new ArrayList<>(opinionRepository.findAllByUser(user));
        userOpinions.add(opinion);
        userRepository.save(user);
        place.setRate(setPlaceRateWithOpinionRate(opinion, place));
        opinion.setPlace(place);
        opinion.setUser(user);
        opinionRepository.save(opinion);
        List <Opinion> opinions = new ArrayList<>(place.getOpinions());
        opinions.add(opinion);
        place.setOpinions(opinions);
        placeRepository.save(place);
    }

    private double setPlaceRateWithOpinionRate(Opinion opinion, Place place) {
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

    public Opinion getRandomOpinion(Place place) throws OpinionNotFoundException{
        List<Opinion> opinionByPlace = opinionRepository.findAllOpinionByPlace(place);
        if(opinionByPlace.isEmpty()){
            return new Opinion("Dodaj pierwszą opinią");
        }
        return randomValues.randomObjectFromList(opinionByPlace);

    }
}
