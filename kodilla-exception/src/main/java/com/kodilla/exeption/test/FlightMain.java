package com.kodilla.exeption.test;

public class FlightMain {
    public static void main(String[] args) {
//        Flight myFlight = new Flight("Warsaw", "Amsterdam");
        Flight myFlight = new Flight("Warsaw", "Paris");
        FlightFinding flightFinding = new FlightFinding();

        try {
            flightFinding.findFlight(myFlight);
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
