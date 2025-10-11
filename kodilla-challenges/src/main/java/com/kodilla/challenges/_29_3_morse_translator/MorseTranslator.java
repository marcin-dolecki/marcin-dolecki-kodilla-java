package com.kodilla.challenges._29_3_morse_translator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseTranslator {

    public static String morseToText(String morseCode) {
        Map<String, String> morseMap = new HashMap<>();
        morseMap.put(".-", "A");
        morseMap.put("-...", "B");
        morseMap.put("-.-.", "C");
        morseMap.put("-..", "D");
        morseMap.put(".", "E");
        morseMap.put("..-.", "F");
        morseMap.put("--.", "G");
        morseMap.put("....", "H");
        morseMap.put("..", "I");
        morseMap.put(".---", "J");
        morseMap.put("-.-", "K");
        morseMap.put(".-..", "L");
        morseMap.put("--", "M");
        morseMap.put("-.", "N");
        morseMap.put("---", "O");
        morseMap.put(".--.", "P");
        morseMap.put("--.-", "Q");
        morseMap.put(".-.", "R");
        morseMap.put("...", "S");
        morseMap.put("-", "T");
        morseMap.put("..-", "U");
        morseMap.put("...-", "V");
        morseMap.put(".--", "W");
        morseMap.put("-..-", "X");
        morseMap.put("-.--", "Y");
        morseMap.put("--..", "Z");

        String[] codes = morseCode.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String code : codes) {
            String letter = morseMap.get(code);
            if (letter != null) {
                result.append(letter);
            } else {
                result.append("?");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string in Morse code (separate letters with a space):");
        String input = scanner.nextLine();

        String translated = morseToText(input);
        System.out.println("Input: " + input + ", translated: " + translated);
    }
}
