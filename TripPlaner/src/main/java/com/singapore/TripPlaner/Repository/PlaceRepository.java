package com.singapore.TripPlaner.Repository;

import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Place;
import com.singapore.TripPlaner.Model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    List<Place> findAllByCity(City city);

    @Query("select p.id from Place p where p.id not in (:ids) and p.city = :city")
    List<Long> getIdsInCityExept(List<Long> ids, City city);

    @Query("select p.id from Place p where p.city = :city")
    List<Long> getAllIdsInCity(City city);
}