package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.Place;
import com.singapore.TripPlaner.Service.CityService;
import com.singapore.TripPlaner.Model.Opinion;

import com.singapore.TripPlaner.Service.OpinionService;
import com.singapore.TripPlaner.Service.OpinionService;
import com.singapore.TripPlaner.Service.PlaceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PlaceController {
    private final PlaceService placeService;
    private final CityService cityService;
    private final OpinionService opinionService;

    public PlaceController(PlaceService placeService, CityService cityService, OpinionService opinionService) {
        this.placeService = placeService;
        this.cityService = cityService;
        this.opinionService = opinionService;
    }

    @GetMapping("/places")
    public String getPlace(Model model) {
        Place newPlace = new Place();
        model.addAttribute("place", newPlace);

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
    @GetMapping("/place/create")
    public String createPlace (Model model){
       model.addAttribute("place", new Place());
       model.addAttribute("cities", cityService.getCities());
        return "placeForm";
    }
    @PostMapping("/places")
    public String createPlace (@ModelAttribute Place place){
        placeService.createNewPlace(place);
        return "redirect:/places";
    }
    @GetMapping("/place/edit-place/{id}")
    public String getCarById(@PathVariable Long id, Model model) {
        Place place = placeService.findById(id);
        model.addAttribute("place", place);
        model.addAttribute("cities", cityService.getCities());
        return "edit-place";
    }
    @PostMapping("/place/edit/{id}")
    public String editPlace(@PathVariable Long id, @ModelAttribute Place place, Model model) {
        placeService.editPlaceById(id, place);
        return "redirect:/places";
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
