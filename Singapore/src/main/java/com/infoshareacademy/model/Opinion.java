package com.infoshareacademy.model;

import com.infoshareacademy.service.ReadFile;

public class Opinion {

    private String comment;

    private int rate;

    private User user;

    public void userOpinion() {
        ReadFile readFile = new ReadFile();
        readFile.readFile();
  //      while (readFile.readFile()=="Komentarz"){
 //           readFile.writeFile();
     //   }
    }


}
