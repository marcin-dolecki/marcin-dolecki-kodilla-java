package com.kodilla.exeption.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightFindingTestSuite {
    @Test
    void testFindFlight() {
        //given
        Flight flightToAmsterdam = new Flight("Warsaw", "Amsterdam");
        Flight flightToParis = new Flight("Warsaw", "Paris");
        FlightFinding flightFinding = new FlightFinding();

        //when & then
        assertAll(
            () -> assertDoesNotThrow(() -> flightFinding.findFlight(flightToAmsterdam)),
            () -> assertThrows(RouteNotFoundException.class, () -> flightFinding.findFlight(flightToParis)),
            () -> assertEquals("Route to Paris not found", assertThrows(RouteNotFoundException.class, () -> flightFinding.findFlight(flightToParis)).getMessage())
        );
    }
}
