package com.kodilla.good.patterns.builder.pizza;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzaTestSuite {
    @Test
    void testPizzaNew() {
        Pizza pizza = new Pizza("Thin", "Spicy", "Mushrooms", "Onion", "Ham");
        System.out.println(pizza);

        int howManyIngredients = pizza.getIngredients().size();

        assertEquals(3, howManyIngredients);
    }
}
