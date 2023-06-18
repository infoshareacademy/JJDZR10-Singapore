package com.singapore.TripPlaner.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class WeatherDto {
    private String temperature;
    private String pressure;
    private String icon;

    public WeatherDto() {
    }

    public WeatherDto(String temperature, String pressure, String icon) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.icon = icon;
    }


}
