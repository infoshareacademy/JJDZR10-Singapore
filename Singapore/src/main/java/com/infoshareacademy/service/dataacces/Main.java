package com.infoshareacademy.service.dataacces;

import com.infoshareacademy.model.Trip;
import com.infoshareacademy.model.User;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        DataReader<User> userDataReader = new DataReader<>(User[].class);
        List<User> users = userDataReader.readFromFile("User.json");

        DataReader<Trip> tripDataReader = new DataReader<>(Trip[].class);
        List<Trip> trips = tripDataReader.readFromFile("Trip.json");

        System.out.println(trips);
        users.forEach(System.out::println);
    }
}
