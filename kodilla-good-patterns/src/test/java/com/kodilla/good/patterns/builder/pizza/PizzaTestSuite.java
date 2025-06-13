package com.kodilla.good.patterns.builder.pizza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzaTestSuite {
    @Test
    void testPizzaNew() {
        Pizza pizza = new Pizza.PizzaBuilder()
                .ingredient("Onion")
                .bottom("Thin")
//                .sauce("Spicy")
                .ingredient("Ham")
                .ingredient("Mushrooms")
                .build();

        System.out.println(pizza);

        int howManyIngredients = pizza.getIngredients().size();

        assertEquals(3, howManyIngredients);
    }
}
