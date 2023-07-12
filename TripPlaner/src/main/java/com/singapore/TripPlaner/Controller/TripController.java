package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.*;
import com.singapore.TripPlaner.Service.*;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class TripController {
    private final TripService tripService;
    private final PlaceService placeService;
    private final CityService cityService;
    private final WeatherService weatherService;
    private final UserService userService;


    public TripController(TripService tripService, PlaceService placeService, CityService cityService, WeatherService weatherService, UserService userService) {
        this.tripService = tripService;
        this.placeService = placeService;
        this.cityService = cityService;
        this.weatherService = weatherService;
        this.userService = userService;
    }

    @GetMapping("/trips/new")
    public String tripCreateForm(@RequestParam(required = false) Long cityId, Model model, Authentication authentication) {

        if (cityId == null) {
            model.addAttribute("places", placeService.findPlaces());
        } else {
            model.addAttribute("places", placeService.findPlacesByCityId(cityId));
        }
        model.addAttribute("trip", new Trip());
        model.addAttribute("cities", cityService.getCities());
        model.addAttribute("cityId", cityId);
        userService.displayUsername(model, authentication);
        return "trip";
    }

    @PostMapping("/trip")
    public String createTrip(@ModelAttribute Trip trip) {
        // trip.setUser(new User());
        trip = tripService.save(trip);
        /* TODO: walidacja */
        return "redirect:/trips";
    }

    @GetMapping("/trips")
    public String getTrips(Model model, Authentication authentication) {
        model.addAttribute("trips", tripService.findTrips());
        userService.displayUsername(model, authentication);
        return "trips";
    }

    @GetMapping("/trips/{tripId}/edit")
    public String editTrip(@RequestParam(required = false) Long cityId,
                           @PathVariable long tripId,
                           Model model, Authentication authentication) {

        if (cityId == null) {
            model.addAttribute("places", placeService.findPlaces());
        } else {
            model.addAttribute("places", placeService.findPlacesByCityId(cityId));
        }
        Trip trip = tripService.findTripById(tripId);
        model.addAttribute("trip", trip);
        model.addAttribute("cities", cityService.getCities());
        model.addAttribute("cityId", cityId);
        userService.displayUsername(model, authentication);
        return "trip";
    }

    @GetMapping("/trips/{tripId}/show")
    public String editTrip(@PathVariable long tripId, Model model, Authentication authentication) {
        Trip trip = tripService.findTripById(tripId);
        model.addAttribute("trip", trip);
        model.addAttribute("weather", weatherService.getWeather(trip.getPlaces().get(0).getCity()));
        model.addAttribute("localDateTime", LocalDateTime.now());
        model.addAttribute("randomPlaceImgUrl", tripService.getRandomPlaceImgUrl(trip));
        userService.displayUsername(model, authentication);
        return "tripDetails";
    }

    @GetMapping("/trips/{tripId}/delete")
    public String tripDelete(@PathVariable long tripId) {
        Trip trip = tripService.findTripById(tripId);
        tripService.removeTrip(trip);
        return "redirect:/trips";
    }


}
