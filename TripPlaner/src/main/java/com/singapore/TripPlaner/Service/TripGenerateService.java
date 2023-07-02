package com.singapore.TripPlaner.Service;

import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.TripGenerateCriteria;
import com.singapore.TripPlaner.Service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripGenerateService {

    //miasta do wyboru
    private List<City> cities;

    public TripGenerateCriteria tgc;

    public TripGenerateService(TripGenerateCriteria tgc, CityService cityService) {
        this.tgc = tgc;
        this.cities = cityService.getCities();
    }
    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;

    }
}
