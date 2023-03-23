package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.*;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TripController {

    @Autowired
    Writer writer;
    @Autowired
    Reader reader;
    @GetMapping("/tripcreate")
    public String tripCreateForm(Model model) {
        model.addAttribute("trip", new Trip());
        return "tripcreate";
    }

    @PostMapping("/tripcreate")
    public String tripCreateSubmit(@ModelAttribute Trip trip, Model model) {
        trip.setUser(new User());
        writer.save(trip);

        List<Persistent> places = reader.getList(Places.class);
        model.addAttribute("places", places);
        model.addAttribute("tripPoint", new TripPoint());
        model.addAttribute("trip", trip);
        return "tripcreate";
    }

}
