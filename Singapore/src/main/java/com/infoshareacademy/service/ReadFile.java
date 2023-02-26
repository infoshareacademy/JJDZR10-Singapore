package com.infoshareacademy.service;

import java.io.*;
import java.util.Scanner;

public class ReadFile {

    private File file;
    private String userInput;
    private String filePath = "/home/bartek/Desktop/Singapore/JJDZR10-Singapore/Singapore/src/main/resources/Gdańsk/Monuments/próba.txt";
    // TODO Stworzyć metodę na generowanie ścieżki


    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setWriteFile(String writeFile) {
        this.userInput = writeFile;
    }

    public void readFile() {
        file = new File(filePath);   //file - zmienna z nazwą miejsca
        String userInput = null;

        try {
            Scanner in = new Scanner(file);
            userInput = in.nextLine();
            while (in.hasNextLine()) {
                userInput = in.nextLine();
                if (userInput.equals("Komentarz:")) {
                    do {
                        userInput = in.nextLine();
                        System.out.println(userInput);
                    }
                    while (!in.hasNext("%koniec%"));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }




    public void writeFile(String userInput) {//metoda zapisu na końcu pliku tekstowego
        file = new File(filePath); //file - zmienna z nazwą pliku
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            fileWriter.write("\n" + userInput);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
