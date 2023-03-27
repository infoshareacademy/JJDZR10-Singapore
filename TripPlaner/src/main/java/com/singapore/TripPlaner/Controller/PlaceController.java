package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Places;
import com.singapore.TripPlaner.Service.PlaceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PlaceController {
    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/place")
    public String getPlace(Model model) {
        List places = placeService.getPlace();
        model.addAttribute("places", places);
        return "places";
    }
    @GetMapping("/place/type/{index}")
    public String getPlacesByType(@PathVariable int index , Model model){
        List places = placeService.getPlace();
        List filtredPlaces = placeService.filterListByTypeOfPlace(index,places);
        model.addAttribute("places",filtredPlaces);
        return "places";
    }
    @GetMapping ("/place/{id}")
    public String placeDetails(@RequestParam(required = true) Long id, Model model){
        model.addAttribute("place", placeService.findById(id));
        return "placeDetails";
    }
}
