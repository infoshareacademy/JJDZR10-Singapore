package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.Type;
import com.singapore.TripPlaner.Service.ImageService;
import com.singapore.TripPlaner.Service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final ImageService imageService;
    private final UserService userService;

    public HomeController(ImageService imageService, UserService userService) {
        this.imageService = imageService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String getStart(Model model, Authentication authentication){
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
        userService.displayUsername(model, authentication);
        return "home";
    }
}
