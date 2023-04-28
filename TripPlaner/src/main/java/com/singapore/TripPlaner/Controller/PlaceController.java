package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.Opinion;
import com.singapore.TripPlaner.Model.Places;
import com.singapore.TripPlaner.Service.OpinionService;
import com.singapore.TripPlaner.Service.PlaceService;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PlaceController {
    private final PlaceService placeService;
    private final OpinionService opinionService;
    private final Writer writer;


    public PlaceController(PlaceService placeService, OpinionService opinionService, Writer writer) {
        this.placeService = placeService;
        this.opinionService = opinionService;
        this.writer = writer;
    }

    @GetMapping("/places")
    public String getPlace(Model model) {
        model.addAttribute("places", placeService.getAllPlaces());
        return "places";
    }
    @GetMapping("/place/type/{type}")
    public String getPlacesByType(@RequestParam(required = true) String type, Model model){
        List filtredPlaces = placeService.filterListByTypeOfPlace(type);
        model.addAttribute("places",filtredPlaces);
        return "places";
    }
    @GetMapping ("/place/{id}")
    public String placeDetails(@PathVariable long id,
                               Model model){
        Places place = placeService.findById(id);
        model.addAttribute("place", place);
        List opinionsId = opinionService.randomOpinions(1,place.getOpinions());
        Opinion opinion = (Opinion) opinionService.findById(Double.valueOf((Double) opinionsId.get(0)).longValue());
        model.addAttribute("opinionDetail", opinion);
        Opinion opinionToAdd = new Opinion();
        model.addAttribute("opinion", opinionToAdd);
        place.getOpinions().add(opinionToAdd.getId());
        place.setRate(opinionService.setObjectRate(opinionToAdd, place.getOpinions(), place.getRate()));
        writer.save(place);
        return "placeDetails";
    }
}
