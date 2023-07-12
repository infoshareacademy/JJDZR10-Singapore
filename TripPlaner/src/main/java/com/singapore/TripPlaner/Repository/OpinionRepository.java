package com.singapore.TripPlaner.Repository;

import com.singapore.TripPlaner.Model.Opinion;
import com.singapore.TripPlaner.Model.Place;
import com.singapore.TripPlaner.Model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpinionRepository extends JpaRepository <Opinion, Long> {
    List <Opinion> findAllOpinionByPlace(Place place);

    List<Opinion> findAllByUser(User user);


}
