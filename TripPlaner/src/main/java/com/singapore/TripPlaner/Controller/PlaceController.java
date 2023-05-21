package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.Places;
import com.singapore.TripPlaner.Service.OpinionService;
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
    private final OpinionService opinionService;


    public PlaceController(PlaceService placeService, OpinionService opinionService) {
        this.placeService = placeService;
        this.opinionService = opinionService;
    }

    @GetMapping("/places")
    public String getPlace(Model model) {
        model.addAttribute("places", placeService.findPlaces());
        return "places";
    }
    @GetMapping("/place/type/{type}")
    public String getPlacesByType(@RequestParam(required = true) String type, Model model){
        List filtredPlaces = placeService.filterListByTypeOfPlace(type);
        model.addAttribute("places",filtredPlaces);
        return "places";
    }
    @GetMapping ("/place/{id}")
    public String placeDetails(@PathVariable long id,
                               Model model){
        Places place = placeService.findById(id);
        model.addAttribute("place", place);
        model.addAttribute("opinionDetail", opinionService.getRandomOpinion(place));
        return "placeDetails";
    }

}
