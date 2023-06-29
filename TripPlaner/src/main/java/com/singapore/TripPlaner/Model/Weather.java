package com.singapore.TripPlaner.Model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
    private long id;
    private int temp;
    private int pressure;
    private int humidity;
}