package com.infoshareacademy;

import com.infoshareacademy.service.ReadFile;

import java.io.IOException;

import static com.infoshareacademy.service.Menu.OpenMenuMethod;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {

        OpenMenuMethod();

        ReadFile readFile = new ReadFile();
        readFile.readFile();


    }


}
