package com.infoshareacademy.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {


    private String filePath = "src/main/resources/Gdańsk/Monuments/próba.txt";

    public String readFile() {
        File file = new File(filePath);
        Scanner in = null;
        String zdanie = "";
        try {
            in = new Scanner(file);
            zdanie = in.nextLine();

            System.out.println(zdanie);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return zdanie;

    }
}
