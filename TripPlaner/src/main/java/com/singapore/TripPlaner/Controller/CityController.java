package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Persistent;
import com.singapore.TripPlaner.Service.CityService;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CityController {

    private final CityService cityService;
    private final Reader reader;

    public CityController(CityService cityService, Reader reader) {
        this.cityService = cityService;
        this.reader = reader;
    }



    @GetMapping("/city")
    public String getCity(Model model) {
        List<Persistent> cities = reader.getList(City.class);
        model.addAttribute("cities", cities);
        return "city";
    }

    @GetMapping("/city/details")
    public String cityDetails(@RequestParam(required = true) Long id, Model model) {
        City city = (City) reader.getObjectById(City.class, id);
        model.addAttribute("city", city);
        return "cityDetails";
    }

    @GetMapping("/city/create")
    public String showAddForm(Model model) {
        model.addAttribute("city", new City());
        return "cityAddForm";
    }

    @PostMapping("/city")
    public String createCity(@ModelAttribute City city) {
        cityService.addCity(city);
        return "redirect:/city/";
    }

}
