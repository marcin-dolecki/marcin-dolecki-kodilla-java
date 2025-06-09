package com.kodilla.good.patterns.singleton;

public enum PrinterManager {
    INSTANCE;

    public void print() {
        System.out.println("Printing printer");
    }
}
