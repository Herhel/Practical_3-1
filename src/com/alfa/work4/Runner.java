package com.alfa.work4;

import java.io.FileNotFoundException;

public class Runner {
    public void run(String[] args) {
        try (AccountingUser users = new AccountingUser()) {
            users.addUsers("Sidorov");
            users.addUsers("Danilina");
            users.addUsers("Govga");
            users.addUsers("Govga");
            users.addUsers("Govga");
            users.addUsers("Danilina");
            users.printFile();
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось найти файл с пользователями " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка считывания посещаемости " + e.getMessage());
        } catch (Exception e) {
        System.out.println("Ошибка закрытия файла " + e.getMessage());
    }
    }
}
