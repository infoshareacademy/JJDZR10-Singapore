package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Service.ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/images")
public class ImageController {
    private final ImageService imageService;
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("")
    public String getImages(Model model) {
        model.addAttribute("images", imageService.getAllImages());
        return "images/images";
    }
}