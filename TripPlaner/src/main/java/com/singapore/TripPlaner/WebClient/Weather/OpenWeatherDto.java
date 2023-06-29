package com.singapore.TripPlaner.WebClient.Weather;

import lombok.Getter;

@Getter
public class OpenWeatherDto {
    private OpenWeatherMainDto main;
    private OpenWeatherWeatherDto [] weather;
    private OpenWeatherWindDto wind;
    private long id;
}
