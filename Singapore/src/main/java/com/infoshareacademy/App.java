package com.infoshareacademy;

import com.infoshareacademy.model.Menu;
import com.infoshareacademy.service.ReadFile;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Menu menu = new Menu();
        menu.menu();
        ReadFile readFile = new ReadFile();
        readFile.readFile();

    }

}
