package com.kodilla.good.patterns2.decorator.taxiportal;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaxiOrderTestSuite {
    @Test
    void testBasicTaxiOrderGetCost() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();

        //When
        BigDecimal calculatedCost = theOrder.getCost();

        //Then
        assertEquals(new BigDecimal(5), calculatedCost);
    }

    @Test
    void testBasicTaxiOrderGetDescription() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();

        //When
        String description = theOrder.getDescription();

        //Then
        assertEquals("Drive a course", description);
    }

    @Test
    void testTaxiNetworkGetCost() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);

        //When
        BigDecimal theCost = theOrder.getCost();

        //Then
        assertEquals(new BigDecimal(40), theCost);
    }

    @Test
    void testTaxiNetworkGetDescription() {
        //Given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);

        //When
        String description = theOrder.getDescription();

        //Then
        assertEquals("Drive a course by Taxi Network", description);
    }
}
