package com.singapore.TripPlaner.Model;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter

public class Image extends PersistentAbstract {
    private String url;


}
