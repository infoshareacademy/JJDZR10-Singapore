package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Service.ImageService;
import com.singapore.TripPlaner.Service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/images")
public class ImageController {
    private final ImageService imageService;
    private final UserService userService;
    public ImageController(ImageService imageService, UserService userService) {
        this.imageService = imageService;
        this.userService = userService;
    }

    @GetMapping("")
    public String getImages(Model model, Authentication authentication) {
        model.addAttribute("images", imageService.getAllImages());
        userService.displayUsername(model, authentication);
        return "images/images";
    }
}