package com.kodilla.good.patterns.ordering.model;

public class OrderRequest {
    private final String user;
    private final String product;
    private final int quantity;

    public OrderRequest(final String user, final String product, final int quantity) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
    }

    public String getUser() {
        return user;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
