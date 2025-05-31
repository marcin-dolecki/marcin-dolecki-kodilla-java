package com.kodilla.good.patterns.ordering.model;

public class OrderDto {
    private final String user;
    private final boolean success;

    public OrderDto(final String user, final boolean success) {
        this.user = user;
        this.success = success;
    }

    public String getUser() {
        return user;
    }

    public boolean isSuccess() {
        return success;
    }
}
