package com.singapore.TripPlaner.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String url;


    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;
//    @ManyToOne
//    @JoinColumn(name = "city_id",nullable = false)
//    private City city;

    @Transient
    private User user;

}