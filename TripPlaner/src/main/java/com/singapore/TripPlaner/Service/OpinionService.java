package com.singapore.TripPlaner.Service;


import com.singapore.TripPlaner.Model.Opinion;
import com.singapore.TripPlaner.Model.User;
import com.singapore.TripPlaner.Service.dataacces.Reader;
import com.singapore.TripPlaner.Service.dataacces.Writer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OpinionService {
    private long id_user;
    private String userOpinion;
    private Double objectRate;
    private List<Integer> ratingsList = new ArrayList<>();
    private Integer userRate;
    private User user;
    private List opinionsList;

    private final Reader reader;
    private final Writer writer;

    public OpinionService(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public List<Opinion> getOpinions(){
        return opinionsList = reader.getList(Opinion.class);
    }

    public Opinion findById(Long id){
        return (Opinion) reader.getObjectById(Opinion.class, id);
    }

    public void editOpinionById (Long id, Opinion opinion){
        Opinion opinionToEdit = findById(id);

        opinionToEdit.setUserOpinion(opinion.getUserOpinion());
        opinionToEdit.setUserRate(getUserRate());
        opinionToEdit.setObjectRate(opinion.getObjectRate());
        opinionToEdit.setId_user(opinion.getId_user());
    }

    public void removeOpinionById(long id){
        getOpinions();
        Opinion opinionToRemove = findById(id);
        opinionsList.remove(opinionToRemove);
    }

    public void addOpinion(Opinion opinion){
        getOpinions();
        opinionsList.add(opinion);
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




    public List<Integer> getRatingsList() {
        return ratingsList;
    }

    public Integer getUserRate() {
        return userRate;
    }

    public Double objectRate() {
        return objectRate;
    }

    @Override
    public String toString() {
        return "OpinionService{" +
                "id_user=" + id_user +
                ", userOpinion='" + userOpinion + '\'' +
                ", objectRate=" + objectRate +
                ", ratingsList=" + ratingsList +
                ", userRate=" + userRate +
                ", opinionsList=" + opinionsList +
                '}';
    }
}



