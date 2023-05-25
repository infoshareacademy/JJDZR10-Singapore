package com.singapore.TripPlaner.Model;

import java.util.ArrayList;
import java.util.List;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = Place.TABLE_NAME)
public class Place {
    public static final String TABLE_NAME = "place";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Length(min = 2, max = 50)
    @Column(name = "name", nullable = false)
    private String name;


    @Length(min = 2, max = 1000)
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "rate", nullable = false)
    private double rate;

//    @Transient
    @OneToMany (mappedBy = "place")
    private List <Image> images = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
//@Transient
    private City city;

    @Column(name = "numberOfOpinions")
    private int numberOfOpinions;

   @Enumerated(value = EnumType.STRING)
    private Type type;
}
