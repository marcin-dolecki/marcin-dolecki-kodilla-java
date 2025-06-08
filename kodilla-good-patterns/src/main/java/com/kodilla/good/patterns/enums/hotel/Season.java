package com.kodilla.good.patterns.enums.hotel;

import java.math.BigDecimal;

public enum Season {
    LOW(new BigDecimal(250), new BigDecimal(350)),
    HIGH(new BigDecimal(320), new BigDecimal(400)),
    HOLIDAY(new BigDecimal(400), new BigDecimal(500));

    private BigDecimal singleRoomPrice;
    private BigDecimal doubleBedPrice;

    Season(BigDecimal singleRoomPrice, BigDecimal doubleBedPrice) {
        this.singleRoomPrice = singleRoomPrice;
        this.doubleBedPrice = doubleBedPrice;
    }

    public BigDecimal getSingleRoomPrice() {
        return singleRoomPrice;
    }

    public BigDecimal getDoubleBedPrice() {
        return doubleBedPrice;
    }
}
