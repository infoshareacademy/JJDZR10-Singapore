package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.TripGenerateCriteria;
import com.singapore.TripPlaner.Service.TripGenerateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class TripGenerateController {
    private final TripGenerateService tripGenerateService;

    public TripGenerateController(TripGenerateService tripGenerateService) {
        this.tripGenerateService = tripGenerateService;
    }

    @GetMapping("/generate-trip")
    public String tripGenerator(Model model) {

        model.addAttribute("tgc", tripGenerateService.tgc);
        model.addAttribute("cities" , tripGenerateService.getCities());

        return "tripGenerateForm";

    }
    @PostMapping("/tripgenerate")
    public String createGeneratedTrip(@ModelAttribute TripGenerateCriteria tgc) {

        System.out.println(tgc);

        return "redirect:/cosczegojeszczeniema";
    }
}