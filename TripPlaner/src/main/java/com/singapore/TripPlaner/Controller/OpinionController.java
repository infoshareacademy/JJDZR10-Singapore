package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.Opinion;
import com.singapore.TripPlaner.Model.Place;
import com.singapore.TripPlaner.Service.OpinionService;
import com.singapore.TripPlaner.Service.PlaceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class OpinionController {

    private final OpinionService opinionService;
    private final PlaceService placeService;

    public OpinionController(OpinionService opinionService, PlaceService placeService) {
        this.opinionService = opinionService;
        this.placeService = placeService;
    }


    @GetMapping("/opinions")
    public String getOpinions(Model model) {
        List opinions = opinionService.getAllOpinions();
        model.addAttribute("opinions", opinions);
        model.addAttribute("user", "Singapore"); //TODO USER
        return "opinions/opinionList";
    }

    @GetMapping("/opinions/edit{id}")
    public String editOpinionById(@PathVariable long id, Model model) {
        Opinion opinion = opinionService.findById(id);
        model.addAttribute("opinion", opinion);
        return "opinions/opinionForm";  //TODO sprawdzić
    }

    @PostMapping("/opinions/edit{id}")
    public String editOpinion(@PathVariable long id,
                              @ModelAttribute Opinion opinion, Place place,
                              Model model) {
        model.addAttribute("opinion", opinion);
        opinionService.editPlaceOpinionById(id, opinion, place);
        return "redirect:/opinions/opinionList";
    }

    @GetMapping("/opinions/delete{id}")
    public String deleteOpinion(@PathVariable long id, Place place) {
        opinionService.removePlaceOpinionById(id, place);
        return "redirect:opinions/opinionList";
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
        opinionService.addOpinionToPlace(opinion, placeService.findById(id));
        return "redirect:/place/{id}";
    }
}