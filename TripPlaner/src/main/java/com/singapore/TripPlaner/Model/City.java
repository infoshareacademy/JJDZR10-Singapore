package com.singapore.TripPlaner.Model;

import jdk.jfr.Description;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class City extends PersistentAbstract {
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @NotBlank(message = "Describe cannot be empty")
    @Size(min=10, max=55, message = "Describe shuold be betwen from 10 to 55 signs")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}