package com.kodilla.exeption.test;

public class SecondChallenge {
    public String probablyIWillThrowException(double x, double y) throws SecondChallengeException {
        if(x >= 2) {
            throw new SecondChallengeException("x cannot be greater or equal to 2");
        } else if (x < 1) {
            throw new SecondChallengeException("x cannot be less than 1");
        } else if (y == 1) {
            throw new SecondChallengeException("y cannot be equal to 1");
        }
        return "Done!";
    }
}
