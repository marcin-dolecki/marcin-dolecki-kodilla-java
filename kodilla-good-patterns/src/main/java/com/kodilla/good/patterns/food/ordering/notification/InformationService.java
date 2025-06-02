package com.kodilla.good.patterns.food.ordering.notification;

import com.kodilla.good.patterns.food.ordering.model.Order;
import com.kodilla.good.patterns.food.ordering.model.OrderRequest;

public interface InformationService {
    void notifyCustomer(Order order);
    void notifySupplier(OrderRequest orderRequest, String supplierName);
}
