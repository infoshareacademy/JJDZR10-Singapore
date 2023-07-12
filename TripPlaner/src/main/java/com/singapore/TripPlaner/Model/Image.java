package com.singapore.TripPlaner.Model;

import com.singapore.TripPlaner.Model.User.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = Image.TABLE_NAME)
public class Image {
    public static final String TABLE_NAME = "image";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Length(min = 2, max = 1000)
    private String url;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private City trip;

    @Transient
    private User user;
}