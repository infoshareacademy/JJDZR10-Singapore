package com.singapore.TripPlaner.Repository;

import com.singapore.TripPlaner.Model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

}
