package com.kodilla.good.patterns.food.ordering.repository;

import com.kodilla.good.patterns.food.ordering.model.Order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryOrderRepository implements OrderRepository {
    private final List<Order> store = Collections.synchronizedList(new ArrayList<>());

    @Override
    public void save(Order order) {
        store.add(order);
    }

    @Override
    public List<Order> findAll() {
        synchronized (store) {
            return new ArrayList<>(store);
        }
    }
}
