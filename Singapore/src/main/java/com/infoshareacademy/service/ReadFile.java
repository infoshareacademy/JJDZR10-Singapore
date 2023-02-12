package com.infoshareacademy.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadFile {

    private String writeFile;
    private String filePath = "/home/bartek/Desktop/Singapore/JJDZR10-Singapore/Singapore/src/main/resources/Gdańsk/Monuments/próba.txt";
    // TODO Stworzyć metodę na generowanie ścieżki


    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

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

    public void setWriteFile(String writeFile) {
        this.writeFile = writeFile;
    }

    public void writeFile() {    //metoda do zapisu w tekstu pliku
        PrintWriter write;

        try {
            write = new PrintWriter(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        write.println(writeFile);
        write.close();
        System.out.println("Dodanie tekstu zakończone sukcesem");
    }


}
