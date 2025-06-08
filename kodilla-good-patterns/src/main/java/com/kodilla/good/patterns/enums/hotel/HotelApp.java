package com.kodilla.good.patterns.enums.hotel;

/* OLD WAY --> with PriceList class
public class HotelApp {
    public static void main(String[] args) {
        System.out.println("Accomodation prices:");
        System.out.println("1. Single Bed rooms");
        System.out.println("    - low season: " + PriceList.getSingleBedPrice(Season.LOW));
        System.out.println("    - high season: " + PriceList.getSingleBedPrice(Season.HIGH));
        System.out.println("    - holiday season: " + PriceList.getSingleBedPrice(Season.HOLIDAY));
        System.out.println("2. Double Bed rooms");
        System.out.println("    - low season: " + PriceList.getDoubleBedPrice(Season.LOW));
        System.out.println("    - high season: " + PriceList.getDoubleBedPrice(Season.HIGH));
        System.out.println("    - holiday season: " + PriceList.getDoubleBedPrice(Season.HOLIDAY));

        Season season = Season.HOLIDAY;
        System.out.println(season);
    }
}
 */

/*NEW WAY --> prices directly from ENUM */
public class HotelApp {
    public static void main(String[] args) {
        System.out.println("Accomodation prices:");
        System.out.println("1. Single Bed rooms");
        System.out.println("    - low season: " + Season.LOW.getSingleRoomPrice());
        System.out.println("    - high season: " + Season.HIGH.getSingleRoomPrice());
        System.out.println("    - holiday season: " + Season.HOLIDAY.getSingleRoomPrice());
        System.out.println("2. Double Bed rooms");
        System.out.println("    - low season: " + Season.LOW.getDoubleBedPrice());
        System.out.println("    - high season: " + Season.HIGH.getDoubleBedPrice());
        System.out.println("    - holiday season: " + Season.HOLIDAY.getDoubleBedPrice());

        Season season = Season.HOLIDAY;
        System.out.println(season);
    }
}
