package com.singapore.TripPlaner.Repository;

import com.singapore.TripPlaner.Model.Opinion;
import com.singapore.TripPlaner.Model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpinionRepository extends JpaRepository <Opinion, Long> {
    List <Opinion> findAllOpinionByPlace(Place place);
    List <Opinion> findOpinionByPlaceRate(Place place);

}
