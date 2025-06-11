package com.kodilla.good.patterns.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTestSuite {
    @Test
    void testDefaultInvestingStrategies() {
        Customer steven = new IndividualCustomer("Steven Links");
        Customer john = new IndividualYoungCustomer("John Hemerald");
        Customer kodilla = new CorporateCustomer("Kodilla");

        String stevenShouldBuy = steven.predict();
        System.out.println("Steven should: " + stevenShouldBuy);
        String johnShouldBuy = john.predict();
        System.out.println("John should: " + johnShouldBuy);
        String kodillaShouldBuy = kodilla.predict();
        System.out.println("Kodilla should: " + kodillaShouldBuy);

        assertEquals("[Conservative Predictor] Buy debentures of XYZ", stevenShouldBuy);
        assertEquals("[Aggressive Predictor] Buy stock of XYZ", johnShouldBuy);
        assertEquals("[Balanced Predictor] Buy shared units of Fund XYZ", kodillaShouldBuy);
    }
}
