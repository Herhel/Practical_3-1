package com.alfa.work2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Runner {
    public void run(String[] params) {
        if (params.length < 1) {
            try {
                printFile(".\\src\\com\\alfa\\work2\\Runner.java");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if ( !Files.isDirectory(Paths.get(params[0]))) {
            try {
                printFile2(params[0]);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void printFile(String uri) throws IOException {
        String text;
        File file = new File(uri);
        try(BufferedReader fileText = new BufferedReader(new FileReader(file))) {
            while ((text = fileText.readLine()) != null) {
                System.out.println(text);
            }
        }
    }

    public void printFile2(String uri) throws IOException {
        Path path = Paths.get(uri);
        List<String> lines = Files.readAllLines(path);
        for (String lin:lines) {
            System.out.println(lin);
        }

    }
}
