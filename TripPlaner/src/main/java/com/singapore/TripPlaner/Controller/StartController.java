package com.singapore.TripPlaner.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {



    @GetMapping("/")
    public String getStart(){
        return "dashboard";
    }




}