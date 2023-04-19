package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.Opinion;
import com.singapore.TripPlaner.Model.Places;
import com.singapore.TripPlaner.Model.User;
import com.singapore.TripPlaner.Service.OpinionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/opinions")
public class OpinionController {

    private final OpinionService opinionService;

    public OpinionController(OpinionService opinionService) {
        this.opinionService = opinionService;
    }

    @GetMapping("")
    public String getOpinions(Model model) {
        List opinions = opinionService.getOpinions();
        model.addAttribute("opinions", opinions);
        User user = new User();  //TODO poprawa po zdefiniowaniu użytkowników
        model.addAttribute("user", user);
        return "opinions";
    }

    @GetMapping("/details{id}")
    public String getOpinionById(@RequestParam("id") long id, Model model) {
        Opinion opinion = (Opinion) opinionService.findById(id);
        Places placeOpinionById = opinionService.getPlaceByOpinionId(id);
        model.addAttribute("opinion", opinion);
        model.addAttribute("placeOpinionById", placeOpinionById);
        return "opinionDetails";
    }

    @GetMapping("/edit{id}")
    public String editOpinionById(@RequestParam("id") long id, Model model) {
        Opinion opinion = (Opinion) opinionService.findById(id);
        model.addAttribute("opinion", opinion);
        return "opinionEdit";
    }

    @PostMapping("/edit{id}")
    public String editOpinion(@RequestParam("id") long id,
                              @ModelAttribute Opinion opinion,
                              Model model) {
        opinionService.editOpinionById(id, opinion);
        return "redirect:/opinions";
    }


    @GetMapping("/delete{id}")
    public String deleteOpinion(@RequestParam("id") long id) {
        opinionService.removeOpinionById(id); //TODO usuwanie id z listy place.getOpinions()
        return "redirect:/opinions";
    }

    @GetMapping("/new/{placeId}")
    public String opinionForm(@PathVariable("placeId") long placeId, Model model) {
        model.addAttribute("opinion", new Opinion());
        model.addAttribute("placeId", placeId);
        return "opinionForm";
    }

    @PostMapping("/")
    public String addOpinion(@ModelAttribute Opinion opinion, Places places, Model model,
                             @RequestParam long placeId) {

        model.addAttribute("place", places);
        opinionService.addOpinion(opinion, placeId);
        return "redirect:/opinions";
    }

    @GetMapping("/{placeId}/random{number}")
    public String randomOpinions(@RequestParam("number") int number,
                                 @PathVariable("placeId") long placeId, Model model) {
        List opinions = opinionService.randomOpinions(number, placeId);
        model.addAttribute("opinions", opinions);
        User user = new User();  //TODO poprawa po zdefiniowaniu użytkowników
        model.addAttribute("user", user);
        return "opinions";
    }


}
