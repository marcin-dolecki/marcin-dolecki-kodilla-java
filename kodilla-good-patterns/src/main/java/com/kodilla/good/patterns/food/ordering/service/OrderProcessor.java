package com.kodilla.good.patterns.food.ordering.service;

import com.kodilla.good.patterns.food.ordering.model.Order;
import com.kodilla.good.patterns.food.ordering.model.OrderRequest;
import com.kodilla.good.patterns.food.ordering.notification.InformationService;
import com.kodilla.good.patterns.food.ordering.repository.OrderRepository;
import com.kodilla.good.patterns.food.ordering.ui.UserInterface;

public class OrderProcessor {
    private final OrderingService orderingService;
    private final OrderRepository orderRepository;
    private final InformationService informationService;
    private final UserInterface ui;

    public OrderProcessor(final OrderingService orderingService,
                          final OrderRepository orderRepository,
                          final InformationService informationService,
                          final UserInterface ui) {
        this.orderingService = orderingService;
        this.orderRepository = orderRepository;
        this.informationService = informationService;
        this.ui = ui;
    }

    public void process(final OrderRequest orderRequest, final String supplierName) {
        ui.showMessage("[OrderProcessor] Starting order process with: " + supplierName);
        informationService.notifySupplier(orderRequest, supplierName);
        boolean result = orderingService.placeOrder(supplierName, orderRequest);
        Order order = new Order(supplierName, orderRequest, result);
        orderRepository.save(order);
        informationService.notifyCustomer(order);
    }
}
