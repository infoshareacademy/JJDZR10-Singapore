package com.singapore.TripPlaner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

    @GetMapping("/")

    public String index(@RequestParam(defaultValue = "Gdańsk") String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }

}
