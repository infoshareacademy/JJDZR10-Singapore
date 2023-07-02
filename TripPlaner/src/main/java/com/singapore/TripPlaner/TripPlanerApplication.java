package com.singapore.TripPlaner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class TripPlanerApplication {
    private static ApplicationContext applicationContext;
    public static void main(String[] args) {

        applicationContext=SpringApplication.run(TripPlanerApplication.class, args);
    }

}
