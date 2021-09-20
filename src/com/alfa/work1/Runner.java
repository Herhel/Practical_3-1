package com.alfa.work1;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Runner {
    public void run(String[] parameters) {
        if (parameters.length < 1) {
            print(".\\");
        } else if ( !Files.isDirectory(Paths.get(parameters[0]))) {
            System.out.println("no exist!");
        } else {
            print(parameters[0]);
        }
    }

    public void print(String name) {
        File file = new File(name);
        File[] files = file.listFiles();
        for (File elem : files) {
            System.out.println(elem);
        }
    }
}
