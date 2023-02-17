package com.infoshareacademy;

import com.infoshareacademy.model.Opinion;
import com.infoshareacademy.service.ReadFile;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        Opinion opinion = new Opinion();
        ReadFile readFile = new ReadFile();
        readFile.readFile();
        readFile.writeFile();


    }

}
