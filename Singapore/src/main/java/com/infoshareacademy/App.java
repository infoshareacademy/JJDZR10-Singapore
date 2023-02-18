package com.infoshareacademy;

import com.infoshareacademy.model.Opinion;
import com.infoshareacademy.service.ReadFile;

import java.util.Objects;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        ReadFile readFile = new ReadFile();
        Opinion opinion = new Opinion(readFile);
        opinion.userOpinion();



    }

}
