package com.singapore.TripPlaner.Model;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = Trip.TABLE_NAME)
@AllArgsConstructor
public class Trip implements Comparable<Trip>  {

    public static final String TABLE_NAME = "trip";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Length(min = 1, max = 100)
    private String name;

    /**
     * Distance in kilometers
     */
    private Double distance;

    /**
     * Time to spend in hours i.e. 5.5
     */
    private Double time_for_trip;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    private List<Image> images = new ArrayList<>();
    
    @Length(min = 2, max = 1000)
    private String description;
    
    /**
     * Places to see on the route
     */
    @ManyToMany
    private List<Place> places;

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", distance=" + distance +
                ", time_for_trip=" + time_for_trip +
                ", places=" + places +
                '}';
    }

    public void userSentence() {
        // System.out.println("To jest wycieczka " + this.getName() + " utworzona przez użytkownika " + this.getUser().getFirstName() + " " + this.getUser().getLastName());
    }

    @Override
    public int compareTo(Trip o) {

        if(getId() == o.getId()) {
            return 0;
        }
        return getId() > o.getId()? 1:-1;
    }
}