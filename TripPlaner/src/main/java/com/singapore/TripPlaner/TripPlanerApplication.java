package com.singapore.TripPlaner;

import com.singapore.TripPlaner.Model.Opinion;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TripPlanerApplication {
    public static void main(String[] args) {

        Opinion opinion = new Opinion();
        opinion.setId_user(0);
        opinion.setUserOpinion("Super");
        opinion.setUserRate(4);
        Writer writer = new Writer();
        writer.save(opinion);


//		SpringApplication.run(TripPlanerApplication.class, args);
    }

}
