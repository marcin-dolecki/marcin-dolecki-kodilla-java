package com.kodilla.good.patterns.ordering.service;

import com.kodilla.good.patterns.ordering.model.OrderDto;
import com.kodilla.good.patterns.ordering.model.OrderRequest;
import com.kodilla.good.patterns.ordering.notification.InformationService;
import com.kodilla.good.patterns.ordering.repository.OrderRepository;

public class ProductOrderService {
    private final InformationService informationService;
    private final OrderingService orderingService;
    private final OrderRepository orderRepository;

    public ProductOrderService(final InformationService informationService,
                               final OrderingService orderingService,
                               final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderingService = orderingService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isOrdered = orderingService.order(
                orderRequest.getUser(),
                orderRequest.getProduct(),
                orderRequest.getQuantity()
        );

        if (isOrdered) {
            String message = "Your order has been processed!";
            informationService.inform(orderRequest.getUser(), message);
            orderRepository.createOrder(orderRequest.getUser(),
                    orderRequest.getProduct(),
                    orderRequest.getQuantity()
            );
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            String message = "Unfortunately, Your order has been cancelled.";
            informationService.inform(orderRequest.getUser(), message);
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}
