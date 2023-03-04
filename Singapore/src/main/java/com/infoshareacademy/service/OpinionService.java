package com.infoshareacademy.service;

import com.infoshareacademy.model.Persistent;
import com.infoshareacademy.model.User;
import com.infoshareacademy.service.dataacces.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class OpinionService extends ValidatorService implements Persistent {
    private String userOpinion;
    private Double objectRate;
    private List<Integer> ratingsList = new ArrayList<>();
    private Integer userRate;
    private User user;


    public OpinionService(User user) {
        this.user = user;
    }


    public String setUserOpinion() {
        scanUserString("Napisz komentarz.", "Nic nie napisałeś, podaj swoją opinię");
        setRate();
        System.out.println("Komentarz dodano. ");
        userOpinion = "Komentarz:\n" + getUserScanString() + "\nod: " + user.getLogin();
        System.out.println(userOpinion);  //FIXME usunąć po scaleniu z zapisywaniem w json
        return userOpinion;

    }

    private Integer setRate() {
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

    public Double getObjectRate() {
        System.out.println( "\nŚrednia ocena " + ratingsList.size() + " użytkowników to " + objectRate + ".");
        return objectRate;
    }

    @Override
    public void setId(long id) {

    }
}



