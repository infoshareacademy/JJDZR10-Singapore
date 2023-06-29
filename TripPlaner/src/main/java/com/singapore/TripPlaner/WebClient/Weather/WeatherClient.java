package com.singapore.TripPlaner.WebClient.Weather;

import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class WeatherClient {
    @Value("${WEATHER_URL}")
    private String WEATHER_URL;
    @Value("${weatherClient.API_KEY}")
    public String API_KEY;
    private final RestTemplate restTemplate = new RestTemplate();
    public Weather getWeatherForCity(City city) {
        OpenWeatherDto response = restTemplate.getForObject(WEATHER_URL + "weather?q={city}&appid={apiKey}&units=metric&lang=pl",
                OpenWeatherDto.class,
                city.getName(),
                API_KEY);

        return Weather.builder()
                .id(response.getId())
                .speed(response.getWind().getSpeed())
                .temp(response.getMain().getTemp())
                .pressure(response.getMain().getPressure())
                .humidity(response.getMain().getHumidity())
                .icon(Arrays.stream(response.getWeather()).toList().get(0).getIcon())
                .description(Arrays.stream(response.getWeather()).toList().get(0).getDescription())
                .build();
    }
}
