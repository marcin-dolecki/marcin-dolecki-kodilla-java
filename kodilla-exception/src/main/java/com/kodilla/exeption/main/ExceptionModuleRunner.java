package com.kodilla.exeption.main;

import com.kodilla.exeption.io.FileReader;
import com.kodilla.exeption.io.FileReaderWithoutHandling;

public class ExceptionModuleRunner {
    public static void main(String[] args) {
        FileReaderWithoutHandling fileReader = new FileReaderWithoutHandling();
        fileReader.readFile();
    }
}
