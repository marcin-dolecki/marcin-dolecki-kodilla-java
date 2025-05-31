package com.kodilla.good.patterns.ordering.application;

import com.kodilla.good.patterns.ordering.model.OrderDto;
import com.kodilla.good.patterns.ordering.model.OrderRequest;
import com.kodilla.good.patterns.ordering.notification.ConsoleInformationService;
import com.kodilla.good.patterns.ordering.notification.InformationService;
import com.kodilla.good.patterns.ordering.repository.OrderRepository;
import com.kodilla.good.patterns.ordering.repository.ProductOrderRepository;
import com.kodilla.good.patterns.ordering.service.OrderingService;
import com.kodilla.good.patterns.ordering.service.ProductOrderService;
import com.kodilla.good.patterns.ordering.service.SimpleOrderingService;

public class Application {
    public static void main(String[] args) {
        InformationService informationService = new ConsoleInformationService();
        OrderingService orderingService = new SimpleOrderingService();
        OrderRepository orderRepository = new ProductOrderRepository();

        ProductOrderService productOrderService = new ProductOrderService(
                informationService, orderingService, orderRepository
        );

        OrderRequest order1 = new OrderRequest("ala123", "Board game", 1);
        OrderRequest order2 = new OrderRequest("marcel456", "Headphones no name extra", 2);
        OrderRequest order3 = new OrderRequest("ewa7362", "Cool dress xxs super brand", 1);

        OrderDto result1 = productOrderService.process(order1);
        OrderDto result2 = productOrderService.process(order2);
        OrderDto result3 = productOrderService.process(order3);

        System.out.println("\n---------------------------------------------------");
        System.out.println("Order 1 for user " + result1.getUser() + ". Status: " + result1.isSuccess());
        System.out.println("Order 2 for user " + result2.getUser() + ". Status: " + result2.isSuccess());
        System.out.println("Order 3 for user " + result3.getUser() + ". Status: " + result3.isSuccess());
        System.out.println("---------------------------------------------------");
    }
}
