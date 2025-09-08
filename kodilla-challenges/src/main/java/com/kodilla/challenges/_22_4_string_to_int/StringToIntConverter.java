package com.kodilla.challenges._22_4_string_to_int;

import java.util.Scanner;

public class StringToIntConverter {

    public static int convertToInt(String input) throws NumberFormatException {

        if (input == null || input.isEmpty()) {
            throw new NumberFormatException("Empty string!");
        }

        int result = 0;
        boolean isNegative = false;
        int startIndex = 0;

        if (input.charAt(0) == '-') {
            isNegative = true;
            startIndex = 1;
        }

        for (int i = startIndex; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c < '0' || c > '9') {
                throw new NumberFormatException("Illegal character: " + c);
            }

            int digit = c - '0';
            result = result * 10 + digit;
        }
        return isNegative ? -result : result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        String input = scanner.nextLine();

        try {
            int number = convertToInt(input);
            System.out.println("Your number as integer: " + number);
            System.out.println("We add 10: " + (number + 10));
        } catch (NumberFormatException e) {
            System.out.println("Conversion error: " + e.getMessage());
        }
    }
}
