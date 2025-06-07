package com.kodilla.spring.challenges;

public class FibonacciCalculation {
    public static long fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number cannot be negative");
        }

        if (n == 0 || n == 1) {
            return n;
        }

        long prev = 0;
        long curr = 1;

        for (int i = 2; i <= n; i++) {
            long next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public static void main(String[] args) {
        long result = fibonacci(10);
        System.out.println(result);
    }
}
