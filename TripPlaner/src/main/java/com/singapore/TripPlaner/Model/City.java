package com.singapore.TripPlaner.Model;

import jdk.jfr.Description;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Service;

import javax.persistence.*;

import lombok.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = City.TABLE_NAME)

public class City {
    public static final String TABLE_NAME = "city";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Length(min = 2, max = 25)
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "city")
    private List<Place> places = new ArrayList<>();

    public City(String name, String description, List<Place> places) {
        this.name = name;
        this.description = description;
        this.addPlaces(places);
    }
    public void addPlaces(List<Place> places){
        for (Place place : places){
            this.addPlace(place);
        }
    }
    public void addPlace(Place place){
        place.setCity(this);
        this.places.add(place);
    }
}