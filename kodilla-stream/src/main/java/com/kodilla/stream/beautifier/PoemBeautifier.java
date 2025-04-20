package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public void executeBeautifier(String poem, PoemDecorator decorator) {
        String result = decorator.beautifyText(poem);
        System.out.println(result);
    }
}
