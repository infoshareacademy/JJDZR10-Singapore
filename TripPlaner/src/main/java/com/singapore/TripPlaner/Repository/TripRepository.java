package com.singapore.TripPlaner.Repository;

import com.singapore.TripPlaner.Model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
}