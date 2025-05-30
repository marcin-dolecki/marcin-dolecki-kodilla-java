package com.kodilla.good.patterns.rental.notification;

import com.kodilla.good.patterns.rental.model.User;

public class MailService implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println(user.firstName() + " " + user.lastName() + "'s rental processed");
    }
}
