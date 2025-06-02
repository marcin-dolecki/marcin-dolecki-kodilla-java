package com.kodilla.good.patterns.food.ordering.model;

import java.util.Objects;

public final class Order {
    private final String supplierName;
    private final OrderRequest request;
    private final boolean isCompleted;

    public Order(final String supplierName, final OrderRequest request, final boolean isCompleted) {
        this.supplierName = Objects.requireNonNull(supplierName, "supplierName cannot be null");
        this.request = Objects.requireNonNull(request, "request cannot be null");
        this.isCompleted = isCompleted;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public OrderRequest getRequest() {
        return request;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}
