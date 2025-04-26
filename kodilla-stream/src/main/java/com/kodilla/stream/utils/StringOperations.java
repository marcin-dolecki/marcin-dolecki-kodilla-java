package com.kodilla.stream.utils;

public interface StringOperations {
    static String mirror(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
