package com.kodilla.good.patterns.factory.delivery;

public class CityStore implements Deliverer {
    @Override
    public void processOrder(Order order) {
        System.out.println("City Store -> processing order: " + order);
    }
}
