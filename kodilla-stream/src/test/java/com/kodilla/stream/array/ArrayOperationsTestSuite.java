package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayOperationsTestSuite {
    @Test
    void testGetAverage() {
        //Given
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //When
        double resultAverage = ArrayOperations.getAverage(numbers);

        //Then
        double expectedAverage = 5.5;
        assertEquals(expectedAverage, resultAverage);
    }
}
