package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.Places;
import com.singapore.TripPlaner.Service.ImageService;
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
    private final ImageService imageService;


    public PlaceController(PlaceService placeService, ImageService imageService) {
        this.placeService = placeService;
        this.imageService = imageService;
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
    public String placeDetails(@PathVariable Long id, Model model){
        Places place = placeService.findById(id);
        model.addAttribute("place", place);
        double imageId= imageService.getImageIds(place.getImages());
        model.addAttribute("image", imageService.findImageById(Double.valueOf(imageId).longValue()));
        return "placeDetails";
    }


}
