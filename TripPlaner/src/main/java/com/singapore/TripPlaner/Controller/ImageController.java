package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.Image;
import com.singapore.TripPlaner.Service.ImageService;
import com.singapore.TripPlaner.Service.PlaceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;
import java.util.List;

@Controller
@RequestMapping("/images")
@AllArgsConstructor


public class ImageController {
    private final ImageService imageService;
    private final PlaceService placeService;

    @GetMapping("")
    public String getImages(Model model) {
        List images = imageService.getImages();
        model.addAttribute("images", images);
        return "images/images";
    }
}
