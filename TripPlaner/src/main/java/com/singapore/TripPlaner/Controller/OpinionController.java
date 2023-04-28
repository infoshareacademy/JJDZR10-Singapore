package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.Opinion;
import com.singapore.TripPlaner.Service.OpinionService;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/opinions")
public class OpinionController {

    private final OpinionService opinionService;
    private final Opinion opinion;
    private final Reader reader;

    public OpinionController(OpinionService opinionService, Opinion opinion, Reader reader) {
        this.opinionService = opinionService;
        this.opinion = opinion;
        this.reader = reader;
    }


    @GetMapping("")
    public String getOpinions(Model model) {
        List opinions = opinionService.getOpinions();
        model.addAttribute("opinions", opinions);
        model.addAttribute("user", "Singapore");
        return "opinions";
    }

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

    @GetMapping("/new")
    public String opinionForm(Model model) {
        model.addAttribute("opinion", new Opinion());
        return "opinionForm";
    }

    @PostMapping("/new")
    public String addOpinion(@ModelAttribute Opinion opinion, Model model) {
        opinionService.addOpinion(opinion);
        return "opinionDetails";
    }
}