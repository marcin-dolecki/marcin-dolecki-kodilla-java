package com.kodilla.good.patterns.food.ordering.repository;

import com.kodilla.good.patterns.food.ordering.model.Order;

import java.util.List;

public interface OrderRepository {
    void save(Order order);
    List<Order> findAll();
}
