package com.singapore.TripPlaner.Service;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
@Service
public class RandomValues {


    public List outputList(int outputElements, List inputList) {
        List outputList = new ArrayList<>();
        Random index = new Random();
        for (int i = 0; i < outputElements; i++) {
            int randomInt = index.nextInt(inputList.size());
            outputList.add(inputList.get(randomInt));
            inputList.remove(randomInt);
        }
        return outputList;
    }

    public Object randomObjectFromList(List inputList){
        Object randomObject;
        Random index = new Random();
        int randomInt = index.nextInt(inputList.size());
        return randomObject = (Object) inputList.get(randomInt);
    }
}