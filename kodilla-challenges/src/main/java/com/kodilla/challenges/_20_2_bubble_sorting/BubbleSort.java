package com.kodilla.challenges._20_2_bubble_sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] numbers = {2, 1, 8, 5, 4, 2, 4, 1};

        System.out.println("Before sorting: " + Arrays.toString(numbers));

        bubbleSort(numbers);
        
        System.out.println("After sorting: " + Arrays.toString(numbers));
    }

    private static void bubbleSort(int[] array) {

        int length = array.length;
        boolean swapped;

        for (int i = 0; i < length - 1; i++) {
            swapped = false;

            for (int j = 0; j < length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}
