package com.kodilla.good.patterns.factory.delivery;

public class Order {
    private String order;
    private String delivererName;

    public Order(String order, String delivererName) {
        this.order = order;
        this.delivererName = delivererName;
    }

    public String getOrder() {
        return order;
    }

    public String getDelivererName() {
        return delivererName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order='" + order + '\'' +
                ", delivererName='" + delivererName + '\'' +
                '}';
    }
}
