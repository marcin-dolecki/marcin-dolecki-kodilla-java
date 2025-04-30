package com.kodilla.exeption.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            System.out.println("1st call - 1,3");
            String status = secondChallenge.probablyIWillThrowException(1,3);
            System.out.println(status);

            System.out.println("2nd call - 2,3");
            status = secondChallenge.probablyIWillThrowException(2,3);
            System.out.println(status);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        } finally {
            System.out.println("Final block processed.");
        }
    }
}
