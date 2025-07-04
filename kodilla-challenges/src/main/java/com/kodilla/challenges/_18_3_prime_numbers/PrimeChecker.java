package com.kodilla.challenges._18_3_prime_numbers;

public class PrimeChecker {

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int testNumber = 29;
        boolean isPrime = isPrime(testNumber);

        if (isPrime) {
            System.out.println(testNumber + " is a prime number");
        } else {
            System.out.println(testNumber + " is not a prime number");
        }
    }
}
