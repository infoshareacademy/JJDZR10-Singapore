package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Service.ImageService;
import com.singapore.TripPlaner.Service.RandomValues;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class StartController {
    private final ImageService imageService;
    private final RandomValues randomValues;
    public StartController(ImageService imageService, RandomValues randomValues) {
        this.imageService = imageService;
        this.randomValues = randomValues;
    }


    @GetMapping("/")
    public String getStart(Model model){
        model.addAttribute("randomImage",imageService.getRandomImage());


        return "dashboard";
    }




}
