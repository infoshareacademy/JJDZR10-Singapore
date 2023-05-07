package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.Place;
import com.singapore.TripPlaner.Service.CityService;
import com.singapore.TripPlaner.Model.Opinion;

import com.singapore.TripPlaner.Service.OpinionService;
import com.singapore.TripPlaner.Service.OpinionService;
import com.singapore.TripPlaner.Service.ImageService;
import com.singapore.TripPlaner.Service.PlaceService;
import com.singapore.TripPlaner.Service.RandomValues;
import com.singapore.TripPlaner.Model.Image;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PlaceController {
    private final PlaceService placeService;
    private final CityService cityService;
    private final OpinionService opinionService;
    private final ImageService imageService;
    private final RandomValues randomValues;
    private final Image image;

    public PlaceController(PlaceService placeService, CityService cityService, OpinionService opinionService, ImageService imageService, RandomValues randomValues, Image image) {
        this.placeService = placeService;
        this.cityService = cityService;
        this.opinionService = opinionService;
        this.imageService = imageService;
        this.randomValues = randomValues;
        this.image = image;
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
        model.addAttribute("opinion", new Opinion()); Place place = placeService.findById(id);
        model.addAttribute("place", place);
        double imageId = (double) randomValues.randomObjectFromList(place.getImages());
        model.addAttribute("image", (Image) imageService.findImageById(Double.valueOf(imageId).longValue()));

        return "placeDetails";

    }
}
