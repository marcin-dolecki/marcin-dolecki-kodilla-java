package com.kodilla.good.patterns.ordering.repository;

public interface OrderRepository {
    void createOrder(String user, String product, int quantity);
}
