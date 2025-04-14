package com.kodilla.testing;
import com.kodilla.testing.collection.OddNumbersExterminator;
import com.kodilla.testing.shape.ShapeCircle;
import com.kodilla.testing.shape.ShapeCollector;
import com.kodilla.testing.shape.ShapeSquare;
import com.kodilla.testing.shape.ShapeTriangle;
import com.kodilla.testing.shape.Shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestingMain {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);

        List<Integer> numbers2 = Arrays.asList(8,9,10,11,12,13);

        System.out.println(numbers);
        System.out.println(numbers2);

        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> evenNumbersList = oddNumbersExterminator.exterminate(numbers);
        List<Integer> evenNumbersList2 = oddNumbersExterminator.exterminate(numbers2);
        System.out.println(evenNumbersList);
        System.out.println(evenNumbersList2);
    }
}
