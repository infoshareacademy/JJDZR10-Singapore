package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.Opinion;
import com.singapore.TripPlaner.Model.User;
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
        model.addAttribute("places", placeService.getAllPlaces());
        return "places";
    }
    @GetMapping("/place/type/{type}")
    public String getPlacesByType(@RequestParam(required = true) String type, Model model){
        List filtredPlaces = placeService.filterListByTypeOfPlace(type);
        model.addAttribute("places",filtredPlaces);
        return "places";
    }
    @GetMapping ("/place/{id}")
    public String placeDetails(@PathVariable Long id,
                               Model model){
        model.addAttribute("place", placeService.findById(id));
        List opinionsId = opinionService.randomOpinions(1,id);
        Opinion opinion = (Opinion) opinionService.findById(Double.valueOf((Double) opinionsId.get(0)).longValue());
        model.addAttribute("opinionDetail", opinion);
        model.addAttribute("opinion", new Opinion());
        return "placeDetails";
    }
    @GetMapping("/places/topRate")
    public String getTopRatePlaces(Model model) {
        model.addAttribute("places", placeService.getTopRatedPlaces());
        return "places";
    }
    @GetMapping("/places/mostPopular")
    public String getMostPopularPlaces(Model model) {
        model.addAttribute("places", placeService.getMostPopularPlaces());
        return "places";
    }

}
