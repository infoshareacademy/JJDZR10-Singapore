package com.singapore.TripPlaner.Service;

import com.singapore.TripPlaner.Dto.WeatherDto;
import com.singapore.TripPlaner.POJO.weather.WeatherMain;
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
    public WeatherDto getWeather(double lat, double lon){
        WeatherMain response = restTemplate.getForObject(WEATHER_URL + "weather?lat={lat}&lon={lon}&appid={apiKey}&units=metric&lang=pl",
                WeatherMain.class,
                lat, lon, API_KEY);
        WeatherDto weatherDto = new WeatherDto();
        weatherDto.set
    }
}
