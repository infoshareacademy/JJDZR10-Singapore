package com.singapore.TripPlaner.Model;

import lombok.*;

@Getter
@Builder
public class Weather {
    private long id;
    private int temp;
    private int pressure;
    private int humidity;
    private String description;
    private String icon;
    private double speed;
}