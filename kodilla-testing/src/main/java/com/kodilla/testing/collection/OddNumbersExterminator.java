package com.kodilla.testing.collection;
import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {
    public OddNumbersExterminator() {
    }

    public List<Integer> exterminate(List<Integer> numbers) {
        List<Integer> outputList = new ArrayList<>();

        for (int number : numbers) {
            if (number % 2 == 0) {
                outputList.add(number);
            }
        }
        return outputList;
    }
}
