package com.singapore.TripPlaner.Controller;

import com.singapore.TripPlaner.Model.City;
import com.singapore.TripPlaner.Model.Persistent;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UseDataaccessController {

    @Autowired
    private Reader reader;

    @GetMapping("/start")
    public String getStart(){
        return "index";
    }


    @GetMapping("/ex1")
    public String ex1(Model model) {
        List<Persistent> cities = reader.getList(City.class);
        model.addAttribute("cities", cities);
        return "examples/ex1";
    }

    @GetMapping("/ex1/details")
    public String ex1details(@RequestParam(required = true) Long id, Model model) {
        City city = (City) reader.getObjectById(City.class, id);
        model.addAttribute("city", city);
        return "examples/ex1details";
    }

}
