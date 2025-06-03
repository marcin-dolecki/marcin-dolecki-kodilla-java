package com.kodilla.good.patterns.flight.search.service.service;

import com.kodilla.good.patterns.flight.search.service.model.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class FlightSearchService implements FlightSearchServiceInterface {
    private final List<Flight> flights;

    public FlightSearchService(final List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public List<Flight> findFlightsFrom(String from) {
        return flights.stream()
                .filter(flight -> flight.getFrom().equalsIgnoreCase(from))
                .collect(Collectors.toList());
    }

    @Override
    public List<Flight> findFlightsTo(String to) {
        return flights.stream()
                .filter(flight -> flight.getTo().equalsIgnoreCase(to))
                .collect(Collectors.toList());
    }

    @Override
    public List<Flight> findFlightsThrough(String from, String through, String to) {
        boolean isFlightFromAndThrough = flights.stream()
                .anyMatch(flight -> flight.getFrom().equalsIgnoreCase(from) && flight.getTo().equalsIgnoreCase(through));
        boolean isFlightThroughAndTo = flights.stream()
                .anyMatch(flight -> flight.getFrom().equalsIgnoreCase(through) && flight.getTo().equalsIgnoreCase(to));

        if (isFlightFromAndThrough && isFlightThroughAndTo) {
            return List.of(
                    new Flight(from, through),
                    new Flight(through, to)
            );
        }
        return List.of();
    }
}
