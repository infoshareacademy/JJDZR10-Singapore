package com.infoshareacademy.service.dataacces;

import com.infoshareacademy.model.Persistent;

import java.util.List;

public class PersistentService {

    public static long getMaxId(List<Persistent> list){
        long currMaxId = 0;
        for (Persistent o: list) {
            if(currMaxId < o.getId()){
                currMaxId = o.getId();
            }
        }
        return currMaxId;
    }


}
