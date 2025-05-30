package com.kodilla.good.patterns.rental.application;

import com.kodilla.good.patterns.rental.model.RentRequest;
import com.kodilla.good.patterns.rental.notification.MailService;
import com.kodilla.good.patterns.rental.repository.CarRentalRepository;
import com.kodilla.good.patterns.rental.service.CarRentalService;
import com.kodilla.good.patterns.rental.service.RentalProcessor;

public class Application {
    public static void main(String[] args) {
        RentRequestRetriever rentRequestRetriever = new RentRequestRetriever();
        RentRequest rentRequest = rentRequestRetriever.retrieve();

        RentalProcessor rentalProcessor = new RentalProcessor(
                new MailService(), new CarRentalService(), new CarRentalRepository()
        );

        rentalProcessor.process(rentRequest);
    }
}
