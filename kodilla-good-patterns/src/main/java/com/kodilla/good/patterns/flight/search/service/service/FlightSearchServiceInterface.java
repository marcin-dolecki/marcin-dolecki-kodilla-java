package com.kodilla.good.patterns.flight.search.service.service;

import com.kodilla.good.patterns.flight.search.service.model.Flight;

import java.util.List;

public interface FlightSearchServiceInterface {
    List<Flight> findFlightsFrom(String from);
    List<Flight> findFlightsTo(String to);
    List<Flight> findFlightsThrough(String from, String through, String to);
}
