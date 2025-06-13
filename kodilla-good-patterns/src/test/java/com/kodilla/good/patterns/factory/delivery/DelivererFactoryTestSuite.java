package com.kodilla.good.patterns.factory.delivery;

import org.junit.jupiter.api.Test;

class DelivererFactoryTestSuite {
    @Test
    void testFactoryCentralGrocery() {
        Order order = new Order("Iron 10 pcs", DelivererFactory.CENTRAL_GROCERY);
        Deliverer deliverer = DelivererFactory.create(order.getDelivererName());

        assert deliverer != null;
        deliverer.processOrder(order);
    }

    @Test
    void testFactoryCityStore() {
        Order order = new Order("Toy truck 25 pcs", DelivererFactory.CITY_STORE);
        Deliverer deliverer = DelivererFactory.create(order.getDelivererName());

        assert deliverer != null;
        deliverer.processOrder(order);
    }

    @Test
    void testFactoryMegaStore() {
        Order order = new Order("Super dishwasher 5 pcs", DelivererFactory.MEGA_STORE);
        Deliverer deliverer = DelivererFactory.create(order.getDelivererName());

        assert deliverer != null;
        deliverer.processOrder(order);
    }
}
