package com.kodilla.good.patterns.factory.delivery;

public class CentralGrocery implements Deliverer {
    @Override
    public void processOrder(Order order) {
        System.out.println("Central Grocery -> processing order: " + order);
    }
}
