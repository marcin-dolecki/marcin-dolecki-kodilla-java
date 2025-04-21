package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExecuteSaySomething;
import com.kodilla.stream.lambda.Executor;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.person.People;
import com.kodilla.stream.reference.FunctionalCalculator;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StreamMain {
    public static void main(String[] args) {
        People.getList().stream()
//                .map(s -> s.toUpperCase())
                .map(String::toUpperCase)
//                .forEach(System.out::println);
                .forEach(s -> System.out.println(s));
    }
}
