package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.Opinion;
import com.singapore.TripPlaner.Model.Place;
import com.singapore.TripPlaner.Model.User.User;
import com.singapore.TripPlaner.Service.OpinionService;
import com.singapore.TripPlaner.Service.PlaceService;
import com.singapore.TripPlaner.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OpinionController {

    private final OpinionService opinionService;
    private final PlaceService placeService;
    private final UserService userService;
    public OpinionController(OpinionService opinionService, PlaceService placeService, UserService userService) {
        this.opinionService = opinionService;
        this.placeService = placeService;
        this.userService = userService;
    }


    @GetMapping("/opinions")
    public String getOpinions(Model model) {
        List opinions = opinionService.getAllOpinions();
        model.addAttribute("opinions", opinions);
        return "opinions/opinionList";
    }

    @GetMapping("/opinions/edit/{id}")
    public String editOpinionById(@PathVariable long id, Model model) {
        Opinion opinion = opinionService.findById(id);
        model.addAttribute("opinion", opinion);
        return "opinions/opinionForm";
    }

    @PostMapping("/opinions/edit/{id}")
    public String editOpinion(@PathVariable long id,
                              @ModelAttribute Opinion opinion, Place place,
                              Model model) {
        model.addAttribute("opinion", opinion);
        opinionService.editPlaceOpinionById(id, opinion, place);
        return "redirect:/opinions";
    }

    @GetMapping("/opinions/delete/{id}")
    public String deleteOpinion(@PathVariable long id, Place place) {
        opinionService.removePlaceOpinionById(id, place);
        return "redirect:/opinions";
    }

    @GetMapping("/opinions/place/{id}")
    public String opinionForm(@PathVariable long id,
                              Model model) {
        model.addAttribute("opinion", new Opinion());
        return "opinions/opinionForm";
    }

    @PostMapping("opinions/place/{id}")
    public String addOpinion(@ModelAttribute Opinion opinion,
                             @PathVariable long id) {
        User user = userService.getCurrentUser();
        opinionService.addOpinionToPlace(opinion, placeService.findById(id), user);
        return "redirect:/place/{id}";
    }
}