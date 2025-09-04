package com.kodilla.good.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzaOrderTestSuite {
    @Test
    void testBasicPizzaOrder() {
        PizzaOrder theOrder = new BasicPizzaOrder();

        BigDecimal calculatedCost = theOrder.getCost();
        String description = theOrder.getDescription();

        assertEquals(BigDecimal.valueOf(30), calculatedCost);
        assertEquals("Pizza with cheese", description);
    }

    @Test
    void testPizzaOrderWithToppings() {
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new HamPizzaToppingOrderDecorator(theOrder);
        theOrder = new GarlicSaucePizzaOrderDecorator(theOrder);

        BigDecimal calculatedCost = theOrder.getCost();
        String description = theOrder.getDescription();

        assertEquals(BigDecimal.valueOf(45), calculatedCost);
        assertEquals("Pizza with cheese + ham + garlic sauce", description);
    }
}
