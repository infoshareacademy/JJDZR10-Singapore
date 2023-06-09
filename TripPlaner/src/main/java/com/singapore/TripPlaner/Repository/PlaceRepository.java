package com.singapore.TripPlaner.Repository;

import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Place;
import com.singapore.TripPlaner.Model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    List <Place> findAllByType(Type type);
    List <Place> findAllByCity (City city);
}