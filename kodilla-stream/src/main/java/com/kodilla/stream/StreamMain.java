package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.ExecuteSaySomething;
import com.kodilla.stream.lambda.Executor;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.reference.FunctionalCalculator;

import javax.swing.*;
import java.awt.*;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String poem = "Whispers drift through silent trees.";

        poemBeautifier.executeBeautifier(poem, p -> p.toUpperCase());
        poemBeautifier.executeBeautifier(poem, p -> p = ">>> " + p + " <<<");
        poemBeautifier.executeBeautifier(poem, p -> p = "\u001B[31m" + p + "\u001B[0m");
        poemBeautifier.executeBeautifier(poem, p -> String.join("\n", p.split(" ")));
    }
}
