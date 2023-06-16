package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Service.WeatherService;
import org.springframework.stereotype.Controller;

@Controller
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
}
