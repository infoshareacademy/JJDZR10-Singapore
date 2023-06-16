package com.singapore.TripPlaner.Service;

import com.singapore.TripPlaner.Model.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${WEATHER_URL}")
    private String WEATHER_URL;
    @Value("${weatherClient.API_KEY}")
    public String API_KEY;
    private RestTemplate restTemplate = new RestTemplate();
    public Weather getWeather(double lat, double lon){
        return restTemplate.getForObject(WEATHER_URL + "weather?lat={lat}&lon={lon}&appid={apiKey}&units=metric&lang=pl",
                Weather.class,
                lat, lon, API_KEY);
    }
}
