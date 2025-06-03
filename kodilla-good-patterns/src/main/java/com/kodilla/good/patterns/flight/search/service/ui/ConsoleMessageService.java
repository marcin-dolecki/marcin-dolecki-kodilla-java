package com.kodilla.good.patterns.flight.search.service.ui;

public class ConsoleMessageService implements UserInterface {
    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}
