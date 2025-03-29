package com.kodilla;

public class Calculator {

    public void turnOn() {
        System.out.println("Calculator turned on.");
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.turnOn();
    }
}
