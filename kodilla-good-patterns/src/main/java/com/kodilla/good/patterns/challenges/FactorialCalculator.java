package com.kodilla.good.patterns.challenges;

public class FactorialCalculator {

    public static long factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number cannot be negative");
        }

        long factorial = 1;
        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }

        return factorial;
    }

    public static void main(String[] args) {
        long factorial = factorial(10);
        System.out.println(factorial);
    }
}
