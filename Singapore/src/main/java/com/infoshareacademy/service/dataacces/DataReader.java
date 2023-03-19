package com.infoshareacademy.service.dataacces;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class DataReader<T> {

    private Class<T[]> aClass;

    public DataReader(Class<T[]> aClass) {
        this.aClass = aClass;
    }

    public List<T> readFromFile(String filename) throws IOException {
        Gson gson = new Gson();
        Path path = Paths.get(filename);
        String usersFromFile = Files.readString(path);
        T[] arr = gson.fromJson(usersFromFile, aClass);
        return Arrays.asList(arr);
    }
}
