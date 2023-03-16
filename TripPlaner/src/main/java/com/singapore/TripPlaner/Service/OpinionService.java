package com.singapore.TripPlaner.Service;


import com.singapore.TripPlaner.Model.Persistent;
import com.singapore.TripPlaner.Model.User;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class OpinionService extends ValidatorService implements Persistent {
    private long id_user;
    private String userOpinion;
    private Double objectRate;
    private List<Integer> ratingsList = new ArrayList<>();
    private Integer userRate;
    private User user;

    private User scanUsers() {
        User user = new User();
        User user1 = new User();
        user.setId(1);
        user1.setId(2);
        List<User> userList = Arrays.asList(user, user1); //TODO zamiana na wczytaną listę z plików .json
        return user = userList.get((int) id_user);
    }

    public String setUserOpinion() {
        scanUserString("Napisz komentarz.", "Nic nie napisałeś, podaj swoją opinię");
        System.out.println("Komentarz dodano. ");
        userOpinion = "Komentarz:\n" + getUserScanString() + "\nod: " + user.getLogin();
        return userOpinion;

    }

    public Integer setRate() {
        userScanInteger("Podaj swoją ocenę w skali 1-10", "Podałeś liczbę spoza zakresu", 1, 10);
        ratingsList.add(getUserScanInteger());
        setObjectRate();
        return userRate = getUserScanInteger();
    }


    private Double setObjectRate() {
        Double sum = 0d;
        for (int i = 0; i < ratingsList.size(); i++) {
            sum += (double) ratingsList.get(i);
        }
        return objectRate = (double) (sum / ratingsList.size());
    }

//    public void opinionFilter (){
//
//        Reader reader = new Reader();
//        List opinionList = reader.getList(OpinionService.class);
//
//        Integer rate = userScanInteger("Podaj minimalną ocenę komentarza", "Podałeś liczbę spoza zakresu. Wprowadź ją ponownie", 1, 10);
//        List<String> reducedList = opinionList.stream()
//                .filter(o -> o.getUserRate() > rate)
//                .map(o->o.getUserOpinion()).collect(Collectors.toList());
//
//        Integer opinionsToShow = userScanInteger("Podaj ilość opinii do wyświetlenie", "Nie mamy tylu opinii", 1, reducedList.size());
//        for (int i=0; i<opinionsToShow; i++){
//                System.out.println(reducedList.get(i));
//                System.out.println();
//            }
//        }


    public String getUserOpinion() {
        return userOpinion;
    }

    public List<Integer> getRatingsList() {
        return ratingsList;
    }

    public Integer getUserRate() {
        return userRate;
    }

    public Double objectRate() {
        System.out.println("\nŚrednia ocena " + ratingsList.size() + " użytkowników to " + objectRate + ".");
        return objectRate;
    }

    @Override
    public void setId(long id) {

    }

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public JSONObject toJSON() {
        return null;
    }
}



