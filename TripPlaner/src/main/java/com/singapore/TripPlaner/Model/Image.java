package com.singapore.TripPlaner.Model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Image extends PersistentAbstract {
    private String url;
    private User user;
}