package com.kodilla.good.patterns.rental.model;

public class RentalDto {
    private final User user;
    private final boolean isRented;

    public RentalDto(final User user, final boolean isRented) {
        this.user = user;
        this.isRented = isRented;
    }

    public User getUser() {
        return user;
    }

    public boolean isRented() {
        return isRented;
    }
}
