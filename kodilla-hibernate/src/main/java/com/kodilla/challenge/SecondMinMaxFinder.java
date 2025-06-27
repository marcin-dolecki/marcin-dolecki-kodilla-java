package com.kodilla.challenge;

public class SecondMinMaxFinder {
    public static Integer findSecondMin(int[] array) {
        if (array == null || array.length < 2) {
            return null;
        }

        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int number : array) {
            if (number < min) {
                secondMin = min;
                min = number;
            } else if (number > min && number < secondMin) {
                secondMin = number;
            }
        }
        return (secondMin == Integer.MAX_VALUE) ? null : secondMin;
    }

    public static Integer findSecondMax(int[] array) {
        if (array == null || array.length < 2) {
            return null;
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int number : array) {
            if (number > max) {
                secondMax = max;
                max = number;
            } else if (number < max && number > secondMax) {
                secondMax = number;
            }
        }
        return (secondMax == Integer.MIN_VALUE) ? null : secondMax;
    }

    public static void main(String[] args) {
        int[] numbers = {3, 1, 1, 5, 6, 7, 9, 15, 3, 4, 7, 10};

        Integer secondMin = findSecondMin(numbers);
        Integer secondMax = findSecondMax(numbers);

        System.out.println("Second min: " + secondMin);
        System.out.println("Second max: " + secondMax);
    }
}
