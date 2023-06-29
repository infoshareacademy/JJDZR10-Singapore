package com.singapore.TripPlaner.WebClient.Weather;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OpenWeatherMainDto {
    private OpenWeatherDto main;
    private long id;
}
