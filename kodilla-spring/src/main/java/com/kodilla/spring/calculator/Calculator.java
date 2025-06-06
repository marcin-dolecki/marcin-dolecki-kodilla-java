package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class Calculator {
    @Autowired
    Display display;

    public Double add(double a, double b) {
        double result = a + b;
        display.displayValue(result);
        return result;
    }

    public Double sub(double a, double b) {
        double result = a - b;
        display.displayValue(result);
        return result;
    }

    public Double mul(double a, double b) {
        double result = a * b;
        display.displayValue(result);
        return result;
    }

    public Double div(double a, double b) {
        double result = a / b;
        display.displayValue(result);
        return result;
    }
}
