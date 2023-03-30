package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.Opinion;
import com.singapore.TripPlaner.Service.OpinionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OpinionController {

    private final OpinionService opinionService;

    public OpinionController(OpinionService opinionService) {
        this.opinionService = opinionService;
    }

    @GetMapping("/opinions")
    public String getOpinions(Model model) {
        List opinions = opinionService.getOpinions();
        model.addAttribute("opinions", opinions);
        return "opinions";
    }

    @GetMapping("/opinions/{id}")
    public String getOpinionById(@PathVariable Long id, Model model) {
        Opinion opinion = opinionService.findById(id);
        model.addAttribute(opinion);
        return "opinions/opinionAdmForm"; //TODO
    }

    @PostMapping("/opinions/{id}/edit")
    public String editOpinion(@PathVariable("id") Long id, @ModelAttribute Opinion opinion, Model model) {
        opinionService.editOpinionById(id, opinion);
        return "redirect:/opinions";
    }

    @GetMapping("opinions/delete/{id}")
    public String deleteOpinion(@PathVariable long id) {
        opinionService.removeOpinionById(id);
        return "redirect:/opinions";
    }

    @GetMapping("opinion/new")
    public String opinionForm(Model model) {
        model.addAttribute("opinion", new Opinion());
        return "opinionForm";
    }

    @PostMapping("/opinions")
    public String addOpinion(@ModelAttribute Opinion opinion, Model model) {
        opinionService.addOpinion(opinion);
        return "redirect:/opinions";
    }

}
