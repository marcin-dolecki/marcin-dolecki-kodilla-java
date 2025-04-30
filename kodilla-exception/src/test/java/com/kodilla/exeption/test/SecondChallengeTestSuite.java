package com.kodilla.exeption.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecondChallengeTestSuite {
    @Test
    void testProbablyIWillThrowException() {
        //given
        SecondChallenge secondChallenge = new SecondChallenge();

        //when & then
        assertAll(
            () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1,3)),
            () -> assertThrows(SecondChallengeException.class, () -> secondChallenge.probablyIWillThrowException(2,3)).getMessage(),
            () -> assertEquals("x cannot be greater or equal to 2", assertThrows(SecondChallengeException.class, () -> secondChallenge.probablyIWillThrowException(2,3)).getMessage()),
            () -> assertEquals("x cannot be less than 1", assertThrows(SecondChallengeException.class, () -> secondChallenge.probablyIWillThrowException(0,3)).getMessage()),
            () -> assertEquals("y cannot be equal to 1.5", assertThrows(SecondChallengeException.class, () -> secondChallenge.probablyIWillThrowException(1,1.5)).getMessage()),
            () -> assertEquals("Done!", secondChallenge.probablyIWillThrowException(1,2))
        );
    }
}
