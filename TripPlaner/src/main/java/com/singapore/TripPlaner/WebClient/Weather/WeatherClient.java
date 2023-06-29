package com.singapore.TripPlaner.WebClient.Weather;

import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherClient {
    @Value("${WEATHER_URL}")
    private String WEATHER_URL;
    @Value("${weatherClient.API_KEY}")
    public String API_KEY;
    private final RestTemplate restTemplate = new RestTemplate();

    public Weather getWeatherForCity(City city) {
        OpenWeatherMainDto response = restTemplate.getForObject(WEATHER_URL + "weather?q={city}&appid={apiKey}&units=metric&lang=pl",
                OpenWeatherMainDto.class,
                city.getName(),
                API_KEY);
        return Weather.builder()
                .id(response.getId())
                .temp(response.getMain().getTemp())
                .pressure(response.getMain().getPressure())
                .humidity(response.getMain().getHumidity())
                .build();
    }
}
