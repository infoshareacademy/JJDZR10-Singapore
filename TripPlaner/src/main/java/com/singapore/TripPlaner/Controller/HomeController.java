package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.Type;
import com.singapore.TripPlaner.Service.CityService;
import com.singapore.TripPlaner.Service.ImageService;
import com.singapore.TripPlaner.Service.PlaceService;
import com.singapore.TripPlaner.Service.RandomValues;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final ImageService imageService;
    private final RandomValues randomValues;
    private final PlaceService placeService;
    private final CityService cityService;

    public HomeController(ImageService imageService, RandomValues randomValues, PlaceService placeService, CityService cityService) {
        this.imageService = imageService;
        this.randomValues = randomValues;
        this.placeService = placeService;
        this.cityService = cityService;
    }

    @GetMapping("/")
    public String getStart(Model model){
        model.addAttribute("momument", Type.MONUMENT);
        model.addAttribute("nature", Type.NATURE);
        model.addAttribute("restaurant", Type.RESTAURANT);
        model.addAttribute("randomImage1",imageService.randomImage(imageService.getAllImages()));
        model.addAttribute("randomImage2",imageService.randomImage(imageService.getAllImages()));
        model.addAttribute("randomImage3",imageService.randomImage(imageService.getAllImages()));
        model.addAttribute("randomNatureImage",imageService.getRandomPlaceImage(Type.NATURE.getPlaceType()));
        model.addAttribute("randomMonumentImage",imageService.getRandomPlaceImage(Type.MONUMENT.getPlaceType()));
        model.addAttribute("randomRestaurantImage",imageService.getRandomPlaceImage(Type.RESTAURANT.getPlaceType()));
        model.addAttribute("randomCityImage", imageService.randomImage(imageService.getAllImages()));

        return "home";
    }
}
