package com.kodilla.good.patterns.food.ordering.ui;

public class ConsoleUserInterface implements UserInterface {
    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}
