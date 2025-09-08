package com.kodilla.challenges._22_4_string_to_int;

import java.util.Scanner;

public class StringToIntConverterBasic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        String userInput = scanner.nextLine();

        try {
            int number = Integer.parseInt(userInput);
            System.out.println("Your number as integer: " + number);
            System.out.println("We add 10: " + (number + 10));
        } catch (NumberFormatException e) {
            System.out.println("Wrong. You entered not a number!");
        }
    }
}
