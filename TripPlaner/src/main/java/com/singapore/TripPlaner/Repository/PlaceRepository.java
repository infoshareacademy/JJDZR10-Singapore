package com.singapore.TripPlaner.Repository;

import com.singapore.TripPlaner.Model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    @Query("SELECT p FROM Place p")
    List<Place> findAll();

    @Query("SELECT p FROM Place p WHERE p.id = ?1 ")
    Optional<Place> findById(Long id);





}
