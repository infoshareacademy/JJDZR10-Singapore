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
        List cities = cityService.getAllCities();
        model.addAttribute("cities", cities);
        model.addAttribute("images", imageService.getAllImages());
        return "cities";
    }

    @GetMapping("/city/{id}")
    public String cityDetails(@RequestParam(required = true) Long id, Model model) {
        City city = cityService.findById(id);
        model.addAttribute("city", city);
        List imagesUrls = imageService.getImagesFromList(city.getImages());
        model.addAttribute("images", imagesUrls);
        return "cityDetails";
    }

    @GetMapping("/city")
    public String cityForm(Model model) {
        model.addAttribute("city", new City());
        return "cityForm";
    }


    @PostMapping("/cities")
    public String createCity(@ModelAttribute City city) {
        cityService.createCity(city);
        return "redirect:/cities/";

    }

    @GetMapping("/cities/edit-city/{id}")
    public String getCityById(@PathVariable Long id, Model model) {
        City city = cityService.findById(id);
        model.addAttribute("cities", city);
        return "edit-city";
    }

    @PostMapping("/cities/edit/{id}")
    public String editCity(@PathVariable Long id, @ModelAttribute City city, Model model) {
        cityService.editCityById(id, city);
        return "redirect:/cities";
    }

}
