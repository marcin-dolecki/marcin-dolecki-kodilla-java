package com.kodilla.good.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class HamPizzaToppingOrderDecorator extends AbstractPizzaOrderDecorator {
    public HamPizzaToppingOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(BigDecimal.valueOf(10));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + ham";
    }
}
