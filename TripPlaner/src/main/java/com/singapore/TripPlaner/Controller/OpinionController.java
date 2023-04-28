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
    private final Opinion opinion;

    public OpinionController(OpinionService opinionService, Opinion opinion) {
        this.opinionService = opinionService;
        this.opinion = opinion;
    }


    @GetMapping("")
    public String getOpinions(Model model) {
        List opinions = opinionService.getOpinions();
        model.addAttribute("opinions", opinions);
        model.addAttribute("user", "Singapore");
        return "opinions";
    }

//    @GetMapping("/details/{id}")
//    public String getOpinionById(@PathVariable("id") long id, Model model) {
//        Places placeOpinionById = opinionService.getPlaceByOpinionId(id);
//        Opinion opinion = (Opinion) opinionService.findById(id);
//        model.addAttribute("opinionDetail", opinion);
//        model.addAttribute("placeOpinionById", placeOpinionById);
//        return "opinionDetails";
//    }

    @GetMapping("/edit{id}")
    public String editOpinionById(@PathVariable("id") long id, Model model) {
        Opinion opinion = (Opinion) opinionService.findById(id);
        model.addAttribute("opinion", opinion);
        return "opinionEdit";
    }

    @PostMapping("/edit{id}")
    public String editOpinion(@PathVariable("id") long id,
                              @ModelAttribute Opinion opinion,
                              Model model) {
        model.addAttribute("opinion", opinion);
        opinionService.editOpinionById(id, opinion);
        return "redirect:/opinions";
    }


    @GetMapping("/delete{id}")
    public String deleteOpinion(@PathVariable("id") long id) {
        opinionService.removeOpinionById(id);
        return "redirect:/opinions";
    }

    @GetMapping("/new/{id}")
    public String opinionForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("opinion", new Opinion());
        return "opinionForm";
    }

    @PostMapping("/")
    public String addOpinion(@ModelAttribute Opinion opinion, Model model) {
        opinionService.addOpinion(opinion);
        opinion.getId();
        return "opinionDetails";
    }
}