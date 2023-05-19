package com.singapore.TripPlaner.Repository;

import antlr.collections.List;
import com.singapore.TripPlaner.Model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CityRepository extends JpaRepository<City, Long> {


}
