package com.kodilla.good.patterns.enums.hotel;

public class HotelApp {
    public static void main(String[] args) {
        System.out.println("Accomodation prices:");
        System.out.println("1. Single Bed rooms");
        System.out.println("    - low season: " + PriceList.getSingleBedPrice("LOW"));
        System.out.println("    - high season: " + PriceList.getSingleBedPrice("HlGH"));
        System.out.println("    - holiday season: " + PriceList.getSingleBedPrice("HOLIDAY"));
        System.out.println("2. Double Bed rooms");
        System.out.println("    - low season: " + PriceList.getDoubleBedPrice("LOW"));
        System.out.println("    - high season: " + PriceList.getDoubleBedPrice("HIGH"));
        System.out.println("    - holiday season: " + PriceList.getDoubleBedPrice("HOLIDAY"));
    }
}
