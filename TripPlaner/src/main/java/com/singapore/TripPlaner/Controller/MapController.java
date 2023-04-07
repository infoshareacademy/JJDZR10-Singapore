package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.Places;
import com.singapore.TripPlaner.Service.PlaceService;
import com.singapore.TripPlaner.Service.TripService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {

    private TripService tripService;
    private PlaceService placeService;
    private Places places;

    public MapController(TripService tripService, PlaceService placeService, Places places) {
        this.tripService = tripService;
        this.placeService = placeService;
        this.places = places;
    }

    @GetMapping("/map")
    public String getMap(Model model){
        model.addAttribute("point", placeService.getAllPlaces());
        return "map";
    }
}
