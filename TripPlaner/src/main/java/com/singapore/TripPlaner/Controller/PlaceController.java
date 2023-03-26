package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Places;
import com.singapore.TripPlaner.Service.PlaceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PlaceController {
    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/places")
    public String getPlace(Model model) {
        List places = placeService.getPlace();
        model.addAttribute("places", places);
        return "places";
    }
    @GetMapping("/places/type/{index}")
    public String getPlacesByType(@PathVariable int index , Model model){
        List places = placeService.getPlace();
        List filtredPlaces = placeService.filterListByTypeOfPlace(index,places);
        model.addAttribute("places",filtredPlaces);
        return "places";
    }
}
