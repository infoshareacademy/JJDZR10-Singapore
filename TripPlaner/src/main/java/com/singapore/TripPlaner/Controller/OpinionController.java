package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.Opinion;
import com.singapore.TripPlaner.Service.IOpinions;
import com.singapore.TripPlaner.Service.OpinionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/opinions")
public class OpinionController<T extends IOpinions> {

    private final OpinionService<T> opinionService;

    public OpinionController(OpinionService<T> opinionService) {
        this.opinionService = opinionService;
    }


    @GetMapping("")
    public String getOpinions(Model model) {
        List opinions = opinionService.getAllOpinions();
        model.addAttribute("opinions", opinions);
        model.addAttribute("user", "Singapore");
        return "opinions";
    }

    @GetMapping("/edit{id}")
    public String editOpinionById(@PathVariable long id, Model model) {
        Opinion opinion = (Opinion) opinionService.findById(id);
        model.addAttribute("opinion", opinion);
        return "opinionEdit";
    }

    @PostMapping("/edit{id}")
    public String editOpinion(@PathVariable long id,
                              @ModelAttribute Opinion opinion,
                              Model model) {
        model.addAttribute("opinion", opinion);
        opinionService.editOpinionById(id, opinion);
        return "redirect:/opinions";
    }

    @GetMapping("/delete{id}")
    public String deleteOpinion(@PathVariable long id) {
        opinionService.removeOpinionById(id);
        return "redirect:/opinions";
    }

    @GetMapping("/{t}/{id}")
    public String opinionForm(@PathVariable long id,
                              @PathVariable T t,
                              Model model) {
        model.addAttribute("t", t.findById(id));
        model.addAttribute("opinion", new Opinion());
        return "opinionForm";
    }

    @PostMapping("/{t}/{id}")
    public String addOpinion(@ModelAttribute Opinion opinion,
                             @PathVariable("id") long id,
                             @PathVariable T t) {
        opinionService.addOpinion(opinion, (T) t.findById(id));
        return "redirect:/place/{id}";
    }
}