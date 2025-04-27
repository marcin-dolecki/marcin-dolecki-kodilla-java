package com.kodilla.exeption.main;

import com.kodilla.exeption.io.FileReader;

public class ExceptionModuleRunner {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        fileReader.readFile();
    }
}
