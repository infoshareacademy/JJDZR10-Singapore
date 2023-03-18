package com.singapore.TripPlaner.Service.initData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


import static org.junit.Assert.*;

public class InitDataService {

    public void initData(String className)
            throws IOException {
        Path copied = Paths.get( "com", "singapore","TripPlaner","Service","initData", "Opinion.json");
        Path originalPath = Paths.get("src","main","resources","json", "Opinion.json");
        Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);

        assertThat(copied).exists();

        assertThat(Files.readAllLines(originalPath)
                .equals(Files.readAllLines(copied)));
    }
}
