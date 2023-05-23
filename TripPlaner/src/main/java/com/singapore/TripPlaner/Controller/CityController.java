package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Service.CityService;
import com.singapore.TripPlaner.Service.ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CityController {

    private final CityService cityService;
    private final ImageService imageService;

    public CityController(CityService cityService, ImageService imageService) {
        this.cityService = cityService;
        this.imageService = imageService;
    }

    @GetMapping("/cities")
    public String getCity(Model model) {
        List cities = cityService.getCities();
        model.addAttribute("cities", cities);
        model.addAttribute("images", imageService.getAllImages());
        return "cities";
    }

    @PostMapping("/cities")
    public String createCity(@ModelAttribute City city) {
        cityService.createCity(city);
        return "redirect:/cities/";
    }

    @GetMapping("/city/{id}")
    public String cityDetails(@RequestParam(required = true) Long id, Model model) {
        City city = cityService.findById(id);
        model.addAttribute("city", city);
        List imageList = imageService.getAllImageForCity(city);
        model.addAttribute("images", imageList);
        return "cityDetails";
    }

    @GetMapping("/city")
    public String cityForm(Model model) {
        model.addAttribute("city", new City());
        return "cityForm";
    }

    @GetMapping("/city/edit-city/{id}")
    public String getCityById(@PathVariable Long id, Model model) {
        City city = cityService.findById(id);
        model.addAttribute("city", city);
        return "edit-city";
    }

    @PostMapping("/city/edit/{id}")
    public String editCity(@PathVariable Long id, @ModelAttribute City city) {
        cityService.editCityById(city);
        return "redirect:/cites";
    }

    @GetMapping("/city/{id}/delete")
    public String cityDelete(@PathVariable Long id) {
        cityService.deleteCity(id);
        return "redirect:/cities";
    }
}
