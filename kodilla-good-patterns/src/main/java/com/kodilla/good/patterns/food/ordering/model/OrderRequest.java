package com.kodilla.good.patterns.food.ordering.model;

import java.util.Objects;

public final class OrderRequest {
    private final String productName;
    private final int quantity;
    private final String customer;

    public OrderRequest(final String productName, final int quantity, final String customer) {
        this.productName = Objects.requireNonNull(productName, "productName cannot be null");
        if (quantity < 0) {
            throw new IllegalArgumentException("quantity cannot be negative");
        }
        this.quantity = quantity;
        this.customer = Objects.requireNonNull(customer, "customer cannot be null");
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCustomer() {
        return customer;
    }
}
