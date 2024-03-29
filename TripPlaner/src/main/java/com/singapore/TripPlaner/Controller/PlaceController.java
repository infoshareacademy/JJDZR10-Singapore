package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.Image;
import com.singapore.TripPlaner.Model.Opinion;
import com.singapore.TripPlaner.Model.Place;
import com.singapore.TripPlaner.Service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class PlaceController {
    private final PlaceService placeService;
    private final CityService cityService;
    private final ImageService imageService;
    private final OpinionService opinionService;
    private final WeatherService weatherService;

    public PlaceController(PlaceService placeService, CityService cityService, ImageService imageService, OpinionService opinionService, WeatherService weatherService) {
        this.placeService = placeService;
        this.cityService = cityService;
        this.imageService = imageService;
        this.opinionService = opinionService;
        this.weatherService = weatherService;
    }

    @GetMapping("/places")
    public String getPlace(Model model) {
        model.addAttribute("places", placeService.findPlaces());
        model.addAttribute("images", imageService.getAllImages());
        return "places";
    }

    @GetMapping("/place/type/{type}")
    public String getPlacesByType(@RequestParam(required = true) String type, Model model) {
        List filtredPlaces = placeService.filterListByTypeOfPlace(type);
        model.addAttribute("places", filtredPlaces);
        model.addAttribute("images", imageService.getAllImages());
        return "places";
    }

    @GetMapping("/place/{id}")
    public String placeDetails(@PathVariable Long id, Model model) {
        Place place = placeService.findById(id);
        model.addAttribute("place", place);
        model.addAttribute("images", place.getImages());
        model.addAttribute("opinionDetail", opinionService.getRandomOpinion(place));
        model.addAttribute("opinion", new Opinion());
        model.addAttribute("weather", weatherService.getWeather(place.getCity()));
        model.addAttribute("localDateTime", LocalDateTime.now());
        return "placeDetails";
    }

    @GetMapping("/place/create")
    public String createPlace(Model model) {
        model.addAttribute("place", new Place());
        model.addAttribute("cities", cityService.getCities());
        model.addAttribute("image", new Image());
        return "placeForm";
    }

    @PostMapping("/places")
    public String createPlace(@ModelAttribute Place place, @ModelAttribute Image image) {
        placeService.createPlace(place);
        imageService.saveImage(image);
        imageService.savePlaceForImage(image, place);
        imageService.saveCityForImage(image, place.getCity());
        return "redirect:/places";
    }

    @GetMapping("/place/edit-place/{id}")
    public String getPlaceById(@PathVariable Long id, Model model) {
        Place place = placeService.findById(id);
        model.addAttribute("place", place);
        model.addAttribute("cities", cityService.getCities());
        return "edit-place";
    }

    @PostMapping("/place/edit/{id}")
    public String editPlace(@ModelAttribute Place place) {
        placeService.editPlaceById(place);
        return "redirect:/places";
    }

    @GetMapping("/place/{id}/delete")
    public String placeDelete(@ModelAttribute Place place) {
        placeService.deletePlace(place);
        return "redirect:/places";
    }
}
