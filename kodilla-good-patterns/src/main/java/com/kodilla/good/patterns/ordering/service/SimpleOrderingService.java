package com.kodilla.good.patterns.ordering.service;

public class SimpleOrderingService implements OrderingService {
    @Override
    public boolean order(String user, String product, int quantity) {
        System.out.println("[ORDERING] Attempt to order product: " + product + " (quantity: " + quantity + ") for user: " + user);

        return quantity == 1;
    }
}
