package com.kodilla.good.patterns.ordering.repository;

public class ProductOrderRepository implements OrderRepository {
    @Override
    public void createOrder(String user, String product, int quantity) {
        String record = String.format("Order {user=%s, product=%s, quantity=%d}", user, product, quantity);
        System.out.println("[REPOSITORY] Saving order: " + record);
    }
}
