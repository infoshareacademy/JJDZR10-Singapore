package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.Places;
import com.singapore.TripPlaner.Service.TripService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {

    private TripService tripService;

    public MapController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/map")
    public String getMap(Model model){
        model.addAttribute("place", new Places());
        return "map";
    }
}
