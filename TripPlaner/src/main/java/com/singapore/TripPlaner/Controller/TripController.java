package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.*;
import com.singapore.TripPlaner.Service.TripService;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collections;
import java.util.List;

@Controller
public class TripController {

    private final Writer writer;
    private final Reader reader;
    private final TripService tripService;

    public TripController(Writer writer, Reader reader, TripService tripService) {
        this.writer = writer;
        this.reader = reader;
        this.tripService = tripService;
    }

    @GetMapping("/tripcreate")
    public String tripCreateForm(Model model) {
        model.addAttribute("trip", new Trip());
        return "tripcreate";
    }

    @PostMapping("/tripcreate")
    public RedirectView tripCreateSubmit(@ModelAttribute Trip trip, Model model) {
        trip.setUser(new User());
        /* TODO: walidacja */
        writer.save(trip);

        RedirectView rv = new RedirectView();
        rv.setContextRelative(true);
        rv.setUrl("/tripUpdate/" + trip.getId());
        return rv;
    }

    @PostMapping("/tripPointCreate")
    public RedirectView tripPointSubmit(@ModelAttribute TripPoint tripPoint, Model model,
                                        @RequestParam(name = "tripid") long tripId,
                                        @RequestParam(name = "placeid") long placesId) {

        Trip trip = tripService.findById(tripId);
        Places place = (Places) reader.getObjectById(Places.class, placesId);

        tripPoint.setTrip(trip);
        tripPoint.setPlace(place);

        /* TODO: walidacja */
        writer.save(tripPoint);

        RedirectView rv = new RedirectView();
        rv.setContextRelative(true);
        rv.setUrl("/tripUpdate/" + tripPoint.getTrip().getId());
        return rv;
    }

    @GetMapping("/tripUpdate/{id}")
    public String tripEditForm(@PathVariable(required = true) Long id, Model model) {

        Trip trip = tripService.findById(id);
        List<TripPoint> tripPoints= tripService.getTripPoints(trip);
        long tpNext = tripPoints.size() + 1;

        List<Persistent> places = reader.getList(Places.class);
        model.addAttribute("places", places);
        model.addAttribute("positionNew", tpNext);
        Collections.sort(tripPoints);
        TripPoint emptyTripPoint = new TripPoint();
        emptyTripPoint.setPosition(tpNext);
        emptyTripPoint.setTrip(trip);
        model.addAttribute("tripPoint", emptyTripPoint );
        model.addAttribute("tripPoints", tripPoints );
        model.addAttribute("trip", trip);
        return "tripupdate";
    }


}
