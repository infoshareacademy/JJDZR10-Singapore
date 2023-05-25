package com.singapore.TripPlaner.Model;

import java.util.List;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import lombok.*;
import java.util.ArrayList;


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

    @Length(min = 2, max = 50)
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    @Length(min = 2, max = 1000)
    private String description;

    @OneToMany(mappedBy = "city")
    private List<Place> places = new ArrayList<>();

}