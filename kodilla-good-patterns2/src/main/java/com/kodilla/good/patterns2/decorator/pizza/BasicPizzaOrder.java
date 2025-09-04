package com.kodilla.good.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BasicPizzaOrder implements PizzaOrder {
    @Override
    public BigDecimal getCost() {
        return BigDecimal.valueOf(30);
    }

    @Override
    public String getDescription() {
        return "Pizza with cheese";
    }
}
