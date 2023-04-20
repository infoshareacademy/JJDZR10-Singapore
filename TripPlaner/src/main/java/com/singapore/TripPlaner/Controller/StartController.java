package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.Type;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class StartController {



    @GetMapping("/")
    public String getStart(Model model){
     model.addAttribute("momument", Type.MONUMENT);
     model.addAttribute("nature", Type.NATURE);
     model.addAttribute("restaurant", Type.RESTAURANT);
        return "dashboard";
    }




}
