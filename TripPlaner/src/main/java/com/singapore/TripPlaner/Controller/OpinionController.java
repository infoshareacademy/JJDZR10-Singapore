package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.Opinion;
import com.singapore.TripPlaner.Model.User;
import com.singapore.TripPlaner.Service.OpinionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        User user = new User();
        model.addAttribute("user", user);
        return "opinions";
    }

    @GetMapping("/opinions/details{id}")
    public String getOpinionById(@RequestParam ("id") int id, Model model) {
        Opinion opinion = (Opinion) opinionService.findById(id);
        model.addAttribute("opinion", opinion);
        return "opinionDetails";
    }

//    @PostMapping("/opinions/details{id}")
//    public String editOpinion(@PathVariable("id") int id, @ModelAttribute Opinion opinion, Model model) {
//        opinionService.editOpinionById(id, opinion);
//        return "redirect:/opinions";
//    }




    @GetMapping("opinions/delete{id}")
    public String deleteOpinion(@RequestParam ("id") int id) {
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
