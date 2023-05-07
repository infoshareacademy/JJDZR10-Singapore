package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Service.CityService;
import com.singapore.TripPlaner.Service.ImageService;
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
    private final ImageService imageService;

    public CityController(CityService cityService, ImageService imageService) {
        this.cityService = cityService;
        this.imageService = imageService;
    }


    @GetMapping("/cities")
    public String getCity(Model model) {
        List cities = cityService.getCities();
        model.addAttribute("cities", cities);
        return "cities";
    }

    @GetMapping("/city/{id}")
    public String cityDetails(@RequestParam(required = true) Long id, Model model) {
        City city = cityService.findById(id);
        model.addAttribute("city", city);
        double imageId = imageService.getImageIds(city.getImages());
        model.addAttribute("image", imageService.findImageById(Double.valueOf(imageId).longValue()));
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

}
