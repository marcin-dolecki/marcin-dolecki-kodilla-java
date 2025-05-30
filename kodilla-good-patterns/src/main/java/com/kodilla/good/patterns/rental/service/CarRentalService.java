package com.kodilla.good.patterns.rental.service;

import com.kodilla.good.patterns.rental.model.User;

import java.time.LocalDateTime;

public class CarRentalService implements RentalService {
    @Override
    public boolean rent(User user, LocalDateTime from, LocalDateTime to) {
        return true;
    }
}
