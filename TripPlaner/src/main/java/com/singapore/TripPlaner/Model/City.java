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

//    @OneToMany(mappedBy = "place")
//    private List<Place> places = new ArrayList<>();

    @Override
    public String toString() {
        return  name ;
    }
}