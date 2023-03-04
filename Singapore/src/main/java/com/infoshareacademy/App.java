package com.infoshareacademy;

import com.infoshareacademy.model.City;
import com.infoshareacademy.model.Places;
import com.infoshareacademy.model.User;
import com.infoshareacademy.service.OpinionService;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class App {
    public static void main(String[] args) {

        User user = new User();
        user.setLogin("Bolesław");

        //   Places places = new Places();
        OpinionService opinion = new OpinionService(user);
        opinion.setUserOpinion();
        OpinionService opinion1 = new OpinionService(user);
        opinion1.setUserOpinion();
//        OpinionService opinion2 = new OpinionService(user);
//        opinion.setUserOpinion();
//        OpinionService opinion3 = new OpinionService(user);
//        opinion.setUserOpinion();
//        OpinionService opinion4 = new OpinionService(user);
//        opinion.setUserOpinion();


        List<OpinionService> opinionList = List.of(opinion, opinion1);
        System.out.println(opinionList.get(1));

        List<String> reducedList = opinionList.stream()
                .filter(o -> o.getUserRate() > 4)
                .map(o->o.getUserOpinion()).collect(Collectors.toList());
        System.out.println();
        System.out.println();
        reducedList.forEach(System.out::println);
//                .map(opinionService -> opinionService.getUserOpinion())
//                .collect(Collectors.toList());


//        for(int i=0; i<reducedList.size(); i++){
//            System.out.println(reducedList.get(i));
//        }


    }
}
