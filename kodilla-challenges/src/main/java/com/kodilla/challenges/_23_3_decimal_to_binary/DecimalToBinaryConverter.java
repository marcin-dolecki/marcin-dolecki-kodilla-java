package com.kodilla.challenges._23_3_decimal_to_binary;

public class DecimalToBinaryConverter {

    public static String toBinary(int number) {
        if (number == 0) {
            return "0";
        }

        StringBuilder binary = new StringBuilder();

        int n = number;
        while (n > 0) {
            int remainder = n % 2;
            binary.append(remainder);
            n /= 2;
        }

        return binary.reverse().toString();
    }

    public static void main(String[] args) {
        int decimal1 = 10;
        int decimal2 = 25;
        int decimal3 = 0;

        System.out.println(decimal1 + " in the binary system it is " + toBinary(decimal1));
        System.out.println(decimal2 + " in the binary system it is " + toBinary(decimal2));
        System.out.println(decimal3 + " in the binary system it is " + toBinary(decimal3));
    }
}
