package com.kodilla.challenges._17_3_weighted_average;

import java.util.Arrays;
import java.util.List;

public class WeightedAverageCalculator {
    public static double calculateWeightedAverage(List<Integer> grades, List<Integer> weights) {
        if (grades == null || weights == null || grades.isEmpty() || weights.isEmpty()) {
            throw new IllegalArgumentException("Grades and weights lists must not be empty.");
        }

        if (grades.size() != weights.size()) {
            throw new IllegalArgumentException("Grades and weights lists must have the same length.");
        }

        int totalWeight = 0;
        int weightedSum = 0;

        for (int i = 0; i < grades.size(); i++) {
            int grade = grades.get(i);
            int weight = weights.get(i);

            if (grade < 1 || grade > 6) {
                throw new IllegalArgumentException("Grade " + grade + " is out of the valid range (1-6).");
            }

            if (weight < 1 || weight > 10) {
                throw new IllegalArgumentException("Weight " + weight + " is out of the valid range (1-10).");
            }

            weightedSum += grade * weight;
            totalWeight += weight;
        }
        return (double) weightedSum / totalWeight;
    }

    public static void main(String[] args) {
        List<Integer> grades = Arrays.asList(3, 1, 1, 5, 6, 4);
        List<Integer> weights = Arrays.asList(4, 6, 8, 4, 4, 10);

        try {
            double average = calculateWeightedAverage(grades, weights);
            System.out.printf("Weighted average is %.2f\n", average);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
