package com.alfa.work3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class Runner {
    public void run(String[] params) {
//        params = new String[] {".\\src\\com\\alfa\\files\\text.txt", ".\\src\\com\\alfa\\files\\newtext.txt"}; //copy
//        params = new String[] {".\\src\\com\\alfa\\files\\test.java"}; //replace
        switch (params.length) {
            case (1): {
                try {
                    replacementInFile(params[0]);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case (2): {
                try {
                    copyFile(params[0], params[1]);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            default: {
                System.out.println("Параметры заданны неверно");
                break;
            }
        }
    }

    private void copyFile(String oldFile, String newFile) throws IOException {
        System.out.println("Copy file from " + oldFile + " to " + newFile);
        Files.copy(Paths.get(oldFile), Paths.get(newFile), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Copy ended");
    }

    private void replacementInFile(String file) throws IOException {
        Path path = Paths.get(file);
        System.out.println("Replacing a file " + file);
        List<String> lines = Files.readAllLines(path);
        Path tempFile = Paths.get(file.substring(0, file.lastIndexOf("\\") + 1) + "temp.file");

        try (BufferedWriter br = Files.newBufferedWriter(tempFile)) {
            for (String line : lines) {
                br.write(line.replace("public", "protected") + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Files.move(tempFile, path, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Replacement complete");
    }
}
