package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Persistent;
import com.singapore.TripPlaner.Service.CityService;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CityController {

    private final CityService cityService;
    private final Reader reader;
    private final Writer writer;

    public CityController(CityService cityService, Reader reader, Writer writer) {
        this.cityService = cityService;
        this.reader = reader;
        this.writer = writer;
    }



    @GetMapping("/cities")
    public String getCity(Model model) {
        List<Persistent> cities = reader.getList(City.class);
        model.addAttribute("cities", cities);
        return "cities";
    }

    @GetMapping("/city/details{id}")
    public String cityDetails(@RequestParam(required = true) Long id, Model model) {
        model.addAttribute("city", (City) reader.getObjectById(City.class, id));
        return "cityDetails";
    }

    @GetMapping("/city")
    public String showAddForm(Model model) {
        model.addAttribute("city", new City());
        return "cityForm";
    }



    @PostMapping("/cities")
    public String createCity(@ModelAttribute City city) {
        cityService.addCity(city);
        return "redirect:/cities/";

    }

}
