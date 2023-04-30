package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Places;
import com.singapore.TripPlaner.Service.CityService;
import com.singapore.TripPlaner.Service.ImageService;
import com.singapore.TripPlaner.Service.PlaceService;
import com.singapore.TripPlaner.Service.RandomValues;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {
    private final ImageService imageService;
    private final RandomValues randomValues;
    private final PlaceService placeService;
    private final CityService cityService;

    public StartController(ImageService imageService, RandomValues randomValues, PlaceService placeService, CityService cityService) {
        this.imageService = imageService;
        this.randomValues = randomValues;
        this.placeService = placeService;
        this.cityService = cityService;
    }


    @GetMapping("/")
    public String getStart(Model model){
        model.addAttribute("randomImage1",imageService.getRandomImage(imageService.getImages()));
        model.addAttribute("randomImage2",imageService.getRandomImage(imageService.getImages()));
        model.addAttribute("randomImage3",imageService.getRandomImage(imageService.getImages()));

        Places randomNature = (Places) randomValues.randomObjectFromList(placeService.filterListByTypeOfPlace("Natura"));
        model.addAttribute("randomNatureImage",imageService.randomImageFromIdList(randomNature.getImages()));

        Places randomMonument = (Places) randomValues.randomObjectFromList(placeService.filterListByTypeOfPlace("Zabytki"));
        model.addAttribute("randomMonumentImage",imageService.randomImageFromIdList(randomMonument.getImages()));

        Places randomRestaurant = (Places) randomValues.randomObjectFromList(placeService.filterListByTypeOfPlace("Jedzenie"));
        model.addAttribute("randomRestaurantImage",imageService.randomImageFromIdList(randomRestaurant.getImages()));

        City randomCity = (City) randomValues.randomObjectFromList(cityService.getCities());
        model.addAttribute("randomCityImage", imageService.randomImageFromIdList(randomCity.getImages()));
        return "dashboard";
    }




}
