package com.kodilla.exeption.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinding {
    public void findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> availableRoutes = new HashMap<>();
        availableRoutes.put("Warsaw", true);
        availableRoutes.put("London", false);
        availableRoutes.put("Amsterdam", false);

        String arrivalAirport = flight.getArrivalAirport();

        if (!availableRoutes.containsKey(arrivalAirport)) {
            throw new RouteNotFoundException("Route to " + arrivalAirport + " not found");
        }

        if (availableRoutes.get(arrivalAirport)) {
            System.out.println("Route to " + arrivalAirport + " is available");
        } else {
            System.out.println("Route to " + arrivalAirport + " is currently not available");
        }
    }
}
