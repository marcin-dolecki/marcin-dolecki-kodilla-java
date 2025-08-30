package com.kodilla.good.patterns2.facade.api;

import com.kodilla.good.patterns2.facade.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderFacade.class);
    private final ShopService shopService;

    @Autowired
    public OrderFacade(ShopService shopService) {
        this.shopService = shopService;
    }

    public void processOrder(final OrderDto order, final Long userId) throws OrderProcessingException {
        boolean wasError = false;
        Long orderId = shopService.openOrder(userId);
        LOGGER.info("Registering new order, ID: {}", orderId);

        if (orderId < 0) {
            LOGGER.error(OrderProcessingException.ERR_NOT_AUTHORIZED);
            wasError = true;
            throw new OrderProcessingException(OrderProcessingException.ERR_NOT_AUTHORIZED);
        }

        try {
            for (ItemDto orderItem : order.getItems()) {
                LOGGER.info("Adding item:{}, {} pcs", orderItem.getProductId(), orderItem.getQuantity());
                shopService.addItem(orderId, orderItem.getProductId(), orderItem.getQuantity());
            }

            BigDecimal value = shopService.calculateValue(orderId);
            LOGGER.info("Order value is {} USD", value);

            if (!shopService.doPayment(orderId)) {
                LOGGER.error(OrderProcessingException.ERR_PAYMENT_REJECTED);
                wasError = true;
                throw new OrderProcessingException(OrderProcessingException.ERR_PAYMENT_REJECTED);
            }
            LOGGER.info("Payment for order was done");

        }
    }
}
