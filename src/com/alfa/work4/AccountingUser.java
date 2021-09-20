package com.alfa.work4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AccountingUser implements AutoCloseable {
    private final RandomAccessFile file;
    private int count;

    public AccountingUser() throws FileNotFoundException {
        file = new RandomAccessFile(".\\src\\com\\alfa\\files\\users.txt", "rw");
        count = 1;
    }

    public void addUsers(String nameUser) throws IOException, NumberFormatException {
        nameUser = nameUser.trim();
        long position = 0;
        while (position < file.length()) {
            file.seek(position);
            String[] text = file.readLine().split(":");
            String user = text[0];
            if (user.equals(nameUser)) {
                count = Integer.parseInt(text[1].trim()) + 1;
                file.seek(position);
                file.writeBytes(nameUser + ":" + count + "\n");
                return;
            }
            position = file.getFilePointer();
        }
        file.writeBytes(nameUser + ":" + count + "\n");
    }

    public void printFile() throws IOException {
        file.seek(0);
        String text;
        while ((text = file.readLine()) != null) {
            System.out.println(text);
        }
    }

    @Override
    public void close() throws Exception {
        file.close();
    }
}
