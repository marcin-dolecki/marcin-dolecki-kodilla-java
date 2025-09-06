package com.kodilla.challenges._21_4_char_to_int;

import java.sql.SQLOutput;
import java.util.Scanner;

public class CharToIntegerConverter {

    public static int convertCharToInt(char ch) {
        if (ch >= '0' && ch <= '9') {
            return ch - '0';
        } else {
            throw new IllegalArgumentException("The character: " + ch + " is not a digit");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = -1;

        while (true) {
            System.out.println("Please enter a digit between 0 and 9: ");
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                System.out.println("Input is empty. Please provide a digit between 0 and 9: ");
                continue;
            } else if (input.length() > 1) {
                System.out.println("Wrong. You must enter exactly one digit between 0 and 9: ");
                continue;
            }

            char character = input.charAt(0);

            try {
                number = convertCharToInt(character);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("Entered character as an integer: " + number);
    }
}
