package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Places;
import com.singapore.TripPlaner.Model.Type;
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

    @GetMapping("/places")
    public String getPlace(Model model) {
        model.addAttribute("places", placeService.getPlace());
        return "places";
    }
    @GetMapping("/place/type/{type}")
    public String getPlacesByType(@PathVariable String type, Model model){
        List places = placeService.getPlace();
        List filtredPlaces = placeService.filterListByTypeOfPlace(type,places);
        model.addAttribute("places",filtredPlaces);
        return "places";
    }
    @GetMapping ("/place/{id}")
    public String placeDetails(@PathVariable Long id, Model model){
        model.addAttribute("place", placeService.findById(id));
        return "placeDetails";
    }
}
