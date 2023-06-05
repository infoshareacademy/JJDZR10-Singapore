package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.Image;
import com.singapore.TripPlaner.Model.Opinion;
import com.singapore.TripPlaner.Model.Place;
import com.singapore.TripPlaner.Service.ImageService;
import com.singapore.TripPlaner.Service.CityService;
import com.singapore.TripPlaner.Service.OpinionService;
import com.singapore.TripPlaner.Service.PlaceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PlaceController {
    private final PlaceService placeService;
    private final CityService cityService;
    private final ImageService imageService;
    private final OpinionService opinionService;

    public PlaceController(PlaceService placeService, CityService cityService, ImageService imageService, OpinionService opinionService) {
        this.placeService = placeService;
        this.cityService = cityService;
        this.imageService = imageService;
        this.opinionService = opinionService;
    }

    @GetMapping("/places")
    public String getPlace(Model model) {
        model.addAttribute("places", placeService.findPlaces());
        model.addAttribute("images", imageService.getAllImages());
        return "places";
    }

    @GetMapping("/place/type/{type}")
    public String getPlacesByType(@RequestParam(required = true) String type, Model model) {
        List filtredPlaces = placeService.filterListByTypeOfPlace(type);
        model.addAttribute("places", filtredPlaces);
        model.addAttribute("images", imageService.getAllImages());
        return "places";
    }

    @GetMapping("/place/{id}")
    public String placeDetails(@PathVariable Long id, Model model) {
        Place place = placeService.findById(id);
        model.addAttribute("place", place);
        model.addAttribute("images", place.getImages());
        model.addAttribute("opinionDetail", opinionService.getRandomOpinion(place));
        model.addAttribute("opinions", new Opinion());
        return "placeDetails";
    }

    @GetMapping("/place/create")
    public String createPlace(Model model) {
        Place place = new Place();
        model.addAttribute("place", place);
        model.addAttribute("cities", cityService.getCities());
        model.addAttribute("image", new Image());

        return "placeForm";
    }

    @PostMapping("/places")
    public String createPlace(@ModelAttribute Place place, @ModelAttribute Image image) {
        place.getId();
        placeService.createPlace(place);
        imageService.saveImage(image);
        imageService.savePlaceForImage(image, place);

        return "redirect:/places";
    }

    @GetMapping("/place/edit-place/{id}")
    public String getPlaceById(@PathVariable Long id, Model model) {
        Place place = placeService.findById(id);
        model.addAttribute("place", place);
        model.addAttribute("cities", cityService.getCities());
        return "edit-place";
    }

    @PostMapping("/place/edit/{id}")
    public String editPlace(@PathVariable Long id, @ModelAttribute Place place, Model model) {
        placeService.editPlaceById(place, id);
        return "redirect:/places";
    }

    @GetMapping("/place/{id}/delete")
    public String placeDelete(@PathVariable Long id) {
        placeService.deletePlace(id);
        return "redirect:/places";
    }
}
