package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Persistent;
import com.singapore.TripPlaner.Service.CityService;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService, Reader reader, Writer writer) {
        this.cityService = cityService;
    }


    @GetMapping("/cities")
    public String getCity(Model model) {
        List cities = cityService.getCities();
        model.addAttribute("cities", cities);
        return "cities";
    }

    @GetMapping("/city/{id}")
    public String cityDetails(@RequestParam(required = true) Long id, Model model) {
        model.addAttribute("city", cityService.findById(id));
        return "cityDetails";
    }

    @GetMapping("/city")
    public String cityForm(Model model) {
        model.addAttribute("city", new City());
        return "cityForm";
    }


    @PostMapping("/cities")
    public String createCity(@Valid @ModelAttribute City city, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cityForm";
        }
        cityService.createCity(city);
        return "redirect:/cities/";

    }

}
