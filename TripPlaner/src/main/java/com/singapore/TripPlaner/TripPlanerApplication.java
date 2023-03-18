package com.singapore.TripPlaner;

import com.singapore.TripPlaner.Service.initData.InitDataService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class TripPlanerApplication {
    public static void main(String[] args) {

        InitDataService initDataService = new InitDataService();
        try {
            initDataService.initData("Opinion");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//		SpringApplication.run(TripPlanerApplication.class, args);
    }

}
