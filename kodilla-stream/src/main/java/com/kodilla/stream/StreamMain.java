package com.kodilla.stream;

import com.kodilla.stream.lambda.ExecuteSaySomething;
import com.kodilla.stream.lambda.Executor;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambda");
        expressionExecutor.executeExpression(5,3,(a,b) -> a + b);
        expressionExecutor.executeExpression(5,3,(a,b) -> a - b);
        expressionExecutor.executeExpression(5,3,(a,b) -> a * b);
        expressionExecutor.executeExpression(5,3,(a,b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(5,3, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(5,3, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(5,3, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(5,3, FunctionalCalculator::divideAByB);
    }
}
