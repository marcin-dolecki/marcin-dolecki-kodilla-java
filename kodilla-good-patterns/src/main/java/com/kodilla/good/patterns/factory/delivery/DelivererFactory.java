package com.kodilla.good.patterns.factory.delivery;

public class DelivererFactory {
    public static final String CENTRAL_GROCERY = "CENTRAL_GROCERY";
    public static final String CITY_STORE = "CITY_STORE";
    public static final String MEGA_STORE = "MEGA_STORE";

    public static Deliverer create(final String delivererName) {
        return switch (delivererName) {
            case CENTRAL_GROCERY -> new CentralGrocery();
            case CITY_STORE -> new CityStore();
            case MEGA_STORE -> new MegaStore();
            default -> null;
        };
    }
}
