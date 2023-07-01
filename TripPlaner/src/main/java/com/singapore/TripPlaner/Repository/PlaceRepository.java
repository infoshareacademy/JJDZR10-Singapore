package com.singapore.TripPlaner.Repository;

import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Place;
import com.singapore.TripPlaner.Model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    List <Place> findAllByCity (City city);
}