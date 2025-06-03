package com.kodilla.good.patterns.flight.search.service.app;

import com.kodilla.good.patterns.flight.search.service.model.Flight;
import com.kodilla.good.patterns.flight.search.service.service.FlightSearchService;
import com.kodilla.good.patterns.flight.search.service.service.FlightSearchServiceInterface;
import com.kodilla.good.patterns.flight.search.service.ui.ConsoleMessageService;
import com.kodilla.good.patterns.flight.search.service.ui.UserInterface;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Flight> availableFlights = List.of(
                new Flight("GDAŃSK", "WROCŁAW"),
                new Flight("GDAŃSK", "KRAKÓW"),
                new Flight("KRAKÓW", "WROCŁAW"),
                new Flight("WARSZAWA", "GDAŃSK"),
                new Flight("WROCŁAW", "WARSZAWA")
        );

        FlightSearchServiceInterface searchService = new FlightSearchService(availableFlights);
        UserInterface ui = new ConsoleMessageService();

        printFlights("Flights from GDAŃSK", searchService.findFlightsFrom("GDAŃSK"), ui);
        printFlights("Flights to WROCŁAW", searchService.findFlightsTo("WROCŁAW"), ui);
        printFlights("Flights to POZNAŃ", searchService.findFlightsTo("POZNAŃ"), ui);
        printFlights("Flights from GDAŃSK to WROCŁAW via KRAKÓW", searchService.findFlightsThrough("GDAŃSK", "KRAKÓW", "WROCŁAW"), ui);
        printFlights("Flights from GDAŃSK to WROCŁAW via POZNAN", searchService.findFlightsThrough("GDAŃSK", "POZNAŃ", "WROCŁAW"), ui);
    }

    private static void printFlights(String title, List<Flight> flights, UserInterface ui) {
        ui.showMessage("\n" + title);
        if (flights.isEmpty()) {
            ui.showMessage("No flights found.");
        } else {
            flights.forEach(f -> ui.showMessage(f.toString()));
        }
    }
}
