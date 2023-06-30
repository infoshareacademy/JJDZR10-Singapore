package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.*;
import com.singapore.TripPlaner.Service.CityService;
import com.singapore.TripPlaner.Service.PlaceService;
import com.singapore.TripPlaner.Service.TripService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TripController {


    private final TripService tripService;
    private final PlaceService placeService;
    private final CityService cityService;


    public TripController(TripService tripService, PlaceService placeService, CityService cityService) {
        this.tripService = tripService;
        this.placeService = placeService;
        this.cityService = cityService;
    }

    @GetMapping("/trips/new")
    public String tripCreateForm(@RequestParam(required = false) Long cityId, Model model) {

        if(cityId==null){
            model.addAttribute("places", placeService.findPlaces());
        }
        else {
            model.addAttribute("places", placeService.findPlacesByCityId(cityId));
        }
        model.addAttribute("trip", new Trip());
        model.addAttribute("cities", cityService.getCities()) ;
        model.addAttribute("cityId", cityId);

        return "trip";
    }

    @PostMapping("/trip")
   public String createTrip(@ModelAttribute Trip trip) {
        trip.setUser(new User());
        tripService.save(trip);

        /* TODO: walidacja */

        return "redirect:/trips";
    }

    @GetMapping("/trips")
    public String getTrips(Model model) {

        model.addAttribute("trips", tripService.findTrips());

        return "trips";
    }

    @GetMapping("/trips/{tripId}/edit")
    public String editTrip(@RequestParam(required = false) Long cityId,@PathVariable long tripId, Model model) {

        if(cityId==null){
            model.addAttribute("places", placeService.findPlaces());
        }
        else {
            model.addAttribute("places", placeService.findPlacesByCityId(cityId));
        }
        Trip trip = tripService.findTripById(tripId);
        model.addAttribute("trip", trip);
        model.addAttribute("cities", cityService.getCities()) ;
        model.addAttribute("cityId", cityId);
        return "trip";
    }


    @GetMapping("/trips/{tripId}/delete")
    public String tripDelete(@PathVariable long tripId) {

        Trip trip = tripService.findTripById(tripId);
        tripService.removeTrip(trip);

        return "redirect:/trips";
    }


}
