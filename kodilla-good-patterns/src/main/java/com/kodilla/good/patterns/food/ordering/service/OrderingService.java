package com.kodilla.good.patterns.food.ordering.service;

import com.kodilla.good.patterns.food.ordering.model.OrderRequest;

public interface OrderingService {
    boolean placeOrder(String supplierName, OrderRequest orderRequest);
}
