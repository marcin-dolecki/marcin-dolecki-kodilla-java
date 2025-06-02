package com.kodilla.good.patterns.food.ordering.supplier;

import com.kodilla.good.patterns.food.ordering.model.OrderRequest;

public interface Supplier {
    boolean process(OrderRequest orderRequest);
    String getName();
}
