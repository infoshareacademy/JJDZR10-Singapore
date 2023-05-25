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
    @JoinColumn(name = "place_id")
    private Place place;


    @Transient
    private User user;

    public Image(String url) {
        this.url = url;
    }
}