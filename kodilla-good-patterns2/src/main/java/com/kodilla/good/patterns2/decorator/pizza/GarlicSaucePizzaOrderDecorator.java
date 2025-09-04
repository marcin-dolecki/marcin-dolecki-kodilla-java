package com.kodilla.good.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class GarlicSaucePizzaOrderDecorator  extends AbstractPizzaOrderDecorator {
    public GarlicSaucePizzaOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(BigDecimal.valueOf(5));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + garlic sauce";
    }
}
