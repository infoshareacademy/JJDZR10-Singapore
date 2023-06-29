package com.singapore.TripPlaner.WebClient.Weather;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OpenWeatherDto {
    private int temp;
    private int pressure;
    private int humidity;
}
