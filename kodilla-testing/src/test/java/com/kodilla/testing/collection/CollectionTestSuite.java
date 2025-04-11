package com.kodilla.testing.collection;
import com.kodilla.testing.collection.OddNumbersExterminator;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DisplayName("Collection Test Suite")
class CollectionTestSuite {
    @BeforeEach
    public void beforeEach(TestInfo testInfo) {
        System.out.println("Test Case: begin " + testInfo.getDisplayName());
    }

    @AfterEach
    public void afterEach(TestInfo testInfo) {
        System.out.println("Test Case: end " + testInfo.getDisplayName());
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: start");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: stop");
    }

    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given
        List<Integer> numbers = new ArrayList<>();
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();

        //When
        List<Integer> resultEvenNumbersList = oddNumbersExterminator.exterminate(numbers);
        List<Integer> expectedEvenNumbersList = new ArrayList<>();

        //Then
        Assertions.assertEquals(expectedEvenNumbersList, resultEvenNumbersList);
    }

    @Test
    void testOddNumbersExterminatorNormalList() {
        //Given
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13);
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();

        //When
        List<Integer> resultEvenNumbersList = oddNumbersExterminator.exterminate(numbers);
        List<Integer> expectedEvenNumbersList = Arrays.asList(2,4,6,8,10,12);

        //Then
        Assertions.assertEquals(expectedEvenNumbersList, resultEvenNumbersList);
    }
}
