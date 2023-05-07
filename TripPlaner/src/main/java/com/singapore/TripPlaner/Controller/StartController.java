package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.Type;
import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Place;
import com.singapore.TripPlaner.Service.CityService;
import com.singapore.TripPlaner.Service.ImageService;
import com.singapore.TripPlaner.Service.PlaceService;
import com.singapore.TripPlaner.Service.RandomValues;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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
     model.addAttribute("momument", Type.MONUMENT);
     model.addAttribute("nature", Type.NATURE);
     model.addAttribute("restaurant", Type.RESTAURANT);
        model.addAttribute("randomImage1",imageService.getRandomImage(imageService.getImages()));
        model.addAttribute("randomImage2",imageService.getRandomImage(imageService.getImages()));
        model.addAttribute("randomImage3",imageService.getRandomImage(imageService.getImages()));

        Place randomNature = (Place) randomValues.randomObjectFromList(placeService.filterListByTypeOfPlace("Natura"));
        model.addAttribute("randomNatureImage",imageService.randomImageFromIdList(randomNature.getImages()));

        Place randomMonument = (Place) randomValues.randomObjectFromList(placeService.filterListByTypeOfPlace("Zabytki"));
        model.addAttribute("randomMonumentImage",imageService.randomImageFromIdList(randomMonument.getImages()));

        Place randomRestaurant = (Place) randomValues.randomObjectFromList(placeService.filterListByTypeOfPlace("Jedzenie"));
        model.addAttribute("randomRestaurantImage",imageService.randomImageFromIdList(randomRestaurant.getImages()));

        City randomCity = (City) randomValues.randomObjectFromList(cityService.getCities());
        model.addAttribute("randomCityImage", imageService.randomImageFromIdList(randomCity.getImages()));

        return "dashboard";
    }




}
