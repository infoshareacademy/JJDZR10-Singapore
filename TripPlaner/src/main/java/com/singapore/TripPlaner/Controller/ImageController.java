package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.Image;
import com.singapore.TripPlaner.Service.ImageService;
import com.singapore.TripPlaner.Service.PlaceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/images")


public class ImageController {
    private final ImageService imageService;


    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("")
    public String getImages(Model model) {
        List images = imageService.getImages();
        model.addAttribute("images", images);
        return "images/images";
    }


}