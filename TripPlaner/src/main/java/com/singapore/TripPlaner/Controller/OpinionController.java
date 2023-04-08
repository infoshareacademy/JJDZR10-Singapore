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
        Opinion opinion = opinionService.findById(id);
        model.addAttribute("opinion", opinion);
        return "opinionDetails"; // TODO  dodać html z opinią
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

//    @PostMapping("/opinions")
//    public String addOpinion(@ModelAttribute Opinion opinion, Model model) {
//        opinionService.addOpinionToPlace(opinion);
//        return "redirect:/opinions";
//    }

//    @PostMapping("/tripPointCreate")
//    public RedirectView tripPointSubmit(@ModelAttribute TripPoint tripPoint, Model model,
//                                        @RequestParam(name = "tripid") long tripId,
//                                        @RequestParam(name = "placeid") long placesId) {
//
//        Trip trip = tripService.findById(tripId);
//        Places place = (Places) reader.getObjectById(Places.class, placesId);
//
//        tripPoint.setTrip(trip);
//        tripPoint.setPlace(place);
//
//        /* TODO: walidacja */
//        writer.save(tripPoint);
//
//        RedirectView rv = new RedirectView();
//        rv.setContextRelative(true);
//        rv.setUrl("/tripUpdate/" + tripPoint.getTrip().getId());
//        return rv;
//    }

}
