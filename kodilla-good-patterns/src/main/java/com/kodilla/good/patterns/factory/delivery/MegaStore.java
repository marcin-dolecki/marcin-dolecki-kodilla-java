package com.kodilla.good.patterns.factory.delivery;

public class MegaStore implements Deliverer {
    @Override
    public void processOrder(Order order) {
        System.out.println("Mega Store -> processing order: " + order);
    }
}
