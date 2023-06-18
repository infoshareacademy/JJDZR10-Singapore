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
@AllArgsConstructor
public class Place {
    public static final String TABLE_NAME = "place";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Length(min = 1, max = 100)
    private String name;

    @Length(min = 2, max = 1000)
    private String description;

    private double price;

    private double rate;

    @OneToMany(mappedBy = "place", cascade = CascadeType.ALL)
    private List<Image> images = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @OneToMany (mappedBy = "place", cascade = CascadeType.ALL)
    private List <Opinion> opinions = new ArrayList<>();

    @Enumerated(value = EnumType.STRING)
    private Type type;

}
