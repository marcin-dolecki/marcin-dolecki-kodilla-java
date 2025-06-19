package com.kodilla.good.patterns.challenges;

public class FibonacciCalculation {
    public static int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number cannot be negative");
        }

        if (n == 0 || n == 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("Fibonacci (" + n + ") = " + fibonacci(n));
    }
}
