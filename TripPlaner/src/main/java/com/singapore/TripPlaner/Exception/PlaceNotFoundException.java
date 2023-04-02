package com.singapore.TripPlaner.Exception;

import org.springframework.http.HttpStatus;



public class PlaceNotFoundException extends RuntimeException{
    public PlaceNotFoundException(String message){
        super(message);
    }
}
