package com.singapore.TripPlaner.Service;

import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Weather;
import com.singapore.TripPlaner.WebClient.Weather.client.WeatherClient;
import org.springframework.stereotype.Service;

    @Service
    public class WeatherService {
        private final WeatherClient weatherClient;
        public WeatherService(WeatherClient weatherClient) {
            this.weatherClient = weatherClient;
        }

        public Weather getWeather(City city){
            return weatherClient.getWeatherForCity(city);
        }
    }