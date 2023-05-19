package com.singapore.TripPlaner.Model;

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


    @Length(min = 2, max = 25)
    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "rate", nullable = false)
    private double rate;


//    @ManyToOne
//    @JoinColumn(name = "city_id", nullable = false)
@Transient
    private City city;

//    @Column(name = "cityid")
//    private long cityid;


    @Column(name = "numberOfOpinions")
    private int numberOfOpinions;

    @Enumerated(value = EnumType.STRING)
    private Type type;


    @Override
    public String toString() {
        return "Nazwa: " + name +
                "\nOpis: "+ description+
                "\nCena: "+price + " zł\nOcena: " + rate +
                "\n******************************\n";
    }


}
