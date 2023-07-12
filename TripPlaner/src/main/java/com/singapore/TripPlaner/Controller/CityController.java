package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Image;
import com.singapore.TripPlaner.Service.CityService;
import com.singapore.TripPlaner.Service.ImageService;
import com.singapore.TripPlaner.Service.UserService;
import com.singapore.TripPlaner.Service.WeatherService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class CityController {
    private final CityService cityService;
    private final ImageService imageService;
    private final WeatherService weatherService;
    private final UserService userService;

    public CityController(CityService cityService, ImageService imageService, WeatherService weatherService, UserService userService) {
        this.cityService = cityService;
        this.imageService = imageService;
        this.weatherService = weatherService;
        this.userService = userService;
    }

    @GetMapping("/cities")
    public String getCity(Model model, Authentication authentication) {
        List cities = cityService.getCities();
        model.addAttribute("cities", cities);
        model.addAttribute("images", imageService.getAllImages());
        userService.displayUsername(model, authentication);
        return "cities";
    }

    @PostMapping("/cities")
    public String createCity(@ModelAttribute City city, @ModelAttribute Image image) {
        cityService.createCity(city);
        imageService.saveImage(image);
        imageService.saveCityForImage(image, city);
        return "redirect:/cities/";
    }

    @GetMapping("/city/{id}")
    public String cityDetails(@RequestParam(required = true) Long id, Model model, Authentication authentication) {
        City cityByID = cityService.findById(id);
        model.addAttribute("city", cityByID);
        model.addAttribute("images", cityByID.getImages());
        model.addAttribute("weather", weatherService.getWeather(cityByID));
        model.addAttribute("localDateTime", LocalDateTime.now());
        userService.displayUsername(model, authentication);
        return "cityDetails";
    }

    @GetMapping("/city/create")
    public String cityForm(Model model, Authentication authentication) {
        model.addAttribute("city", new City());
        model.addAttribute("image", new Image());
        userService.displayUsername(model, authentication);
        return "cityForm";
    }

    @GetMapping("/city/edit-city/{id}")
    public String getCityById(@PathVariable Long id, Model model, Authentication authentication) {
        City city = cityService.findById(id);
        model.addAttribute("city", city);
        userService.displayUsername(model, authentication);
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
