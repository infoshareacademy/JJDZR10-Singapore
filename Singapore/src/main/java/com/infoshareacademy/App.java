package com.infoshareacademy;
import com.infoshareacademy.service.ReadFile;
import static com.infoshareacademy.service.Menu.OpenMenuMethod;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        OpenMenuMethod();

        ReadFile readFile = new ReadFile();
        readFile.readFile();


    }


}
