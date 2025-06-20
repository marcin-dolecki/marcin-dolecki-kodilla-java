package com.kodilla.good.patterns.challenges;

public class MinMaxFinder {

    public static int findMin(int[] array) {
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    public static int findMax(int[] array) {
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 1, 5, 6, 7, 9, 15, 3, 4, 7, 10};

        int min = findMin(numbers);
        int max = findMax(numbers);

        System.out.println("Min value is: " + min);
        System.out.println("Max value is: " + max);
    }
}
