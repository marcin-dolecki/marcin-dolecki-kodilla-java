package com.kodilla.testing;
import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
//        Calculator calculator = new Calculator();
//        int a = calculator.add(1, 2);
//        System.out.println(a);
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String username = simpleUser.getUsername();
        String realName = simpleUser.getRealName();

        System.out.println(username);
        System.out.println(realName);
    }
}
