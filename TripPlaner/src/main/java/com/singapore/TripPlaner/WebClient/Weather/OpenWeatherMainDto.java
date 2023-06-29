package com.singapore.TripPlaner.WebClient.Weather;

import lombok.Getter;

@Getter
public class OpenWeatherMainDto {
    private int temp;
    private int pressure;
    private int humidity;
    private int temp_min;
    private int temp_max;

}
