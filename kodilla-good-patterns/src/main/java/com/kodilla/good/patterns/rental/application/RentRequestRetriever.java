package com.kodilla.good.patterns.rental.application;

import com.kodilla.good.patterns.rental.model.RentRequest;
import com.kodilla.good.patterns.rental.model.User;

import java.time.LocalDateTime;

public class RentRequestRetriever {

    public RentRequest retrieve() {
        User user = new User("John", "Wekl");
        LocalDateTime from = LocalDateTime.of(2020, 1, 1, 12, 0);
        LocalDateTime to = LocalDateTime.of(2020, 1, 10, 12, 0);

        return new RentRequest(user, from, to);
    }
}
