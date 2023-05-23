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

    public Place(String name, String description, double price, double rate, int numberOfOpinions, Type type) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.rate = rate;
        this.numberOfOpinions = numberOfOpinions;
        this.type = type;
    }
    public void addImages(List<Image> images){
        for (Image image : images){
            this.addImage(image);
        }
    }
    public void addImage(Image image){
        image.setPlace(this);
        this.images.add(image);
    }
    public Place(String name, String description, double price, double rate, int numberOfOpinions, Type type, List<Image> images) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.rate = rate;
        this.numberOfOpinions = numberOfOpinions;
        this.type = type;
        this.addImages(images);
    }

}
