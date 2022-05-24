package com.example;

import lombok.NonNull;

public class Account {

    private final String name;

    public Account(@NonNull String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */
        if (checkLengthName(name) & checkSpaceOnlyOne(name) & checkPlaceOfSpace(name)) {
            return true;
        }
        return false;
    }

    public boolean checkLengthName(String name) {
        if (name.length() < 3) {
            return false;
        }
        if (name.length() > 19) {
            return false;
        }
        return true;
    }

    public boolean checkSpaceOnlyOne(String name) {

        if (name.indexOf(" ") != name.lastIndexOf(" ")) {
            return false;
        }

        if (name.indexOf(" ") == -1) {
            return false;
        }
        return true;
    }


    public boolean checkPlaceOfSpace(String name) {
        if (name.startsWith(" ") | name.endsWith(" ")) {
            return false;
        }
        return true;
    }
}