package com.infoshareacademy;

import com.infoshareacademy.service.ReadFile;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        ReadFile readFile = new ReadFile();
        readFile.setWriteFile("test3");
        readFile.writeFile();
        readFile.readFile();


    }

}
