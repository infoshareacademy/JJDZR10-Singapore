package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Opinion;
import com.singapore.TripPlaner.Service.CityService;
import com.singapore.TripPlaner.Service.ImageService;
import com.singapore.TripPlaner.Service.RandomValues;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@Controller
public class CityController {

    private final CityService cityService;
    private final ImageService imageService;

    public CityController(CityService cityService, Reader reader, Writer writer, ImageService imageService) {
        this.cityService = cityService;
        this.imageService = imageService;
    }


    @GetMapping("/cities")
    public String getCity(Model model) {
        List cities = cityService.getCities();
        model.addAttribute("cities", cities);
        model.addAttribute("image", imageService);
        return "cities";
    }

    @GetMapping("/city/{id}")
    public String cityDetails(@PathVariable Long id, Model model) {
        model.addAttribute("city", cityService.findById(id));
        model.addAttribute("opinion", new Opinion());
        model.addAttribute("placeId", id);
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
