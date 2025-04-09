package com.kodilla.testing;
import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        // SimpleUser
        SimpleUser simpleUser = new SimpleUser("theForumUser");
        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("test FAILED!");
        }

        // Calculator
        Calculator calculator = new Calculator();
        int resultOfAddition = calculator.add(10, 20);
        int resultOfSubtraction = calculator.subtract(10, 20);

        if (resultOfAddition == 30) {
            System.out.println("test OK");
        } else {
            System.out.println("test FAILED!");
        }

        if (resultOfSubtraction == -10) {
            System.out.println("test OK");
        } else {
            System.out.println("test FAILED!");
        }
    }
}
