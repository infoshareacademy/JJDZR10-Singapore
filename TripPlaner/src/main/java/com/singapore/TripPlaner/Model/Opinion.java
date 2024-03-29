package com.singapore.TripPlaner.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "opinions")
@AllArgsConstructor

public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long opinionId;
    @Column(columnDefinition = "VARCHAR(2000)")
    @NotNull
    private String comment;
    @NotNull
    private Integer rate;
    private String user = "Singapore";
    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    public Opinion(String comment) {
        this.comment = comment;
    }
}
