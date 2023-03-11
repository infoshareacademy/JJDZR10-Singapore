package com.infoshareacademy;
import com.infoshareacademy.model.User;
import com.infoshareacademy.service.ReadFile;
import static com.infoshareacademy.service.Menu.OpenMenuMethod;

import com.infoshareacademy.model.Persistent;
import com.infoshareacademy.model.Trip;
import com.infoshareacademy.service.dataacces.Reader;
import com.infoshareacademy.service.dataacces.Writer;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args)  {
        writerUsage();

    }
    public static void writerUsage(){
        Writer writer = new Writer();
        Reader reader = new Reader();
        Persistent tripPersistent = reader.getObjectById(Trip.class,1);
        Trip trip = (Trip) tripPersistent;
        trip.setName("Weekend in 3City");
        writer.save(trip);

        Trip trip2 = new Trip();
        trip2.setName("Test");
        User user = (User) reader.getObjectById(User.class,1);
        trip2.setUser(user);
        trip2.setDistance(20.5);
        writer.save(trip2);

    }

    public static void readerUsage(){
        Reader reader = new Reader();
        List<Persistent> trips = reader.getList(Trip.class);
        for (Persistent o: trips) {
            Trip trip = (Trip) o;
            trip.userSentence();
        }

        OpenMenuMethod();

        ReadFile readFile = new ReadFile();
        readFile.readFile();


    }

}
