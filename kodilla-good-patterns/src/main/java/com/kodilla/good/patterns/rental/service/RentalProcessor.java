package com.kodilla.good.patterns.rental.service;


import com.kodilla.good.patterns.rental.notification.InformationService;
import com.kodilla.good.patterns.rental.repository.RentalRepository;
import com.kodilla.good.patterns.rental.model.RentRequest;
import com.kodilla.good.patterns.rental.model.RentalDto;

public class RentalProcessor {
    private final InformationService informationService;
    private final RentalService rentalService;
    private final RentalRepository rentalRepository;

    public RentalProcessor(final InformationService informationService,
                           final RentalService rentalService,
                           final RentalRepository rentalRepository) {
        this.informationService = informationService;
        this.rentalService = rentalService;
        this.rentalRepository = rentalRepository;
    }

    public RentalDto process(final RentRequest rentRequest) {
        boolean isRented = rentalService.rent(rentRequest.getUser(), rentRequest.getFrom(), rentRequest.getTo());

        if (isRented) {
            informationService.inform(rentRequest.getUser());
            rentalRepository.createRental(rentRequest.getUser(), rentRequest.getFrom(), rentRequest.getTo());

            return new RentalDto(rentRequest.getUser(), true);
        } else {
            return new RentalDto(rentRequest.getUser(), false);
        }
    }
}
