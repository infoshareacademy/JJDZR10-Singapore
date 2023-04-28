package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Opinion;
import com.singapore.TripPlaner.Service.CityService;
import com.singapore.TripPlaner.Service.OpinionService;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CityController {

    private final CityService cityService;
    private final OpinionService opinionService;
    private final Writer writer;

    public CityController(CityService cityService, Reader reader, Writer writer, OpinionService opinionService, Writer writer1) {
        this.cityService = cityService;
        this.opinionService = opinionService;
        this.writer = writer;
    }


    @GetMapping("/cities")
    public String getCity(Model model) {
        List cities = cityService.getCities();
        model.addAttribute("cities", cities);
        return "cities";
    }

    @GetMapping("/city/{id}")
    public String cityDetails(@PathVariable long id, Model model) {
        City city = cityService.findById(id);
        model.addAttribute("city", city);
        List opinions = opinionService.randomOpinions(1, city.getOpinions());
        Opinion opinion = (Opinion) opinionService.findById(Double.valueOf((Double)opinions.get(0)).longValue());
        model.addAttribute("opinionDetail", opinion);
        Opinion opinionToAdd = new Opinion();
        model.addAttribute("opinion", opinionToAdd);
        city.getOpinions().add(opinionToAdd.getId());
        city.setRate(opinionService.setObjectRate(opinionToAdd, city.getOpinions(), city.getRate()));
        writer.save(city);
        return "cityDetails";
    }

    @GetMapping("/city")
    public String cityForm(Model model) {
        model.addAttribute("city", new City());
        return "cityForm";
    }


    @PostMapping("/cities")
    public String createCity(@ModelAttribute City city) {
        cityService.createCity(city);
        return "redirect:/cities/";

    }

}
