package com.singapore.TripPlaner.Service;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Service
public class RandomValues {


    public List outputList(int outputElements, List inputList) {
        List outputList = new ArrayList<>();
        Random index = new Random();
        if (outputElements>inputList.size()){
            outputElements = inputList.size();
        }
        for (int i = 0; i < outputElements; i++) {
            int randomInt = index.nextInt(inputList.size());
            outputList.add(inputList.get(randomInt));
            inputList.remove(randomInt);
        }
        return outputList;
    }

    public <T> T randomObjectFromList(List <T> inputList){
        Random index = new Random();
        int randomInt = index.nextInt(inputList.size());
        return (T) inputList.get(randomInt);
    }
}