package com.infoshareacademy;

import com.infoshareacademy.model.Menu;
import com.infoshareacademy.service.ReadFile;

import java.io.IOException;
import java.util.InputMismatchException;

import static com.infoshareacademy.model.Menu.OpenMenuMethod;

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
