package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculatorTestSuite {
    @Autowired
    private Calculator calculator;

    @Test
    void testAdd() {
        double result = calculator.add(8, 2);
        assertEquals(10.0, result);
    }

    @Test
    void testSub() {
        double result = calculator.sub(8, 2);
        assertEquals(6.0, result);
    }

    @Test
    void testMul() {
        double result = calculator.mul(8, 2);
        assertEquals(16.0, result);
    }

    @Test
    void testDiv() {
        double result = calculator.div(8, 2);
        assertEquals(4.0, result);
    }
}
