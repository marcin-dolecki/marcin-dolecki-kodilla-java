package com.kodilla.good.patterns.food.ordering.app;

import com.kodilla.good.patterns.food.ordering.model.Order;
import com.kodilla.good.patterns.food.ordering.model.OrderRequest;
import com.kodilla.good.patterns.food.ordering.notification.InformationService;
import com.kodilla.good.patterns.food.ordering.notification.StandardInformationService;
import com.kodilla.good.patterns.food.ordering.repository.InMemoryOrderRepository;
import com.kodilla.good.patterns.food.ordering.repository.OrderRepository;
import com.kodilla.good.patterns.food.ordering.service.OrderProcessor;
import com.kodilla.good.patterns.food.ordering.service.OrderingService;
import com.kodilla.good.patterns.food.ordering.service.StandardOrderingService;
import com.kodilla.good.patterns.food.ordering.service.SupplierFactory;
import com.kodilla.good.patterns.food.ordering.supplier.ExtraFoodShop;
import com.kodilla.good.patterns.food.ordering.supplier.GlutenFreeShop;
import com.kodilla.good.patterns.food.ordering.supplier.HealthyShop;
import com.kodilla.good.patterns.food.ordering.ui.ConsoleUserInterface;
import com.kodilla.good.patterns.food.ordering.ui.UserInterface;

public class Application {
    public static void main(String[] args) {
        UserInterface ui = new ConsoleUserInterface();

        SupplierFactory.registerSupplier(new ExtraFoodShop(ui));
        SupplierFactory.registerSupplier(new HealthyShop(ui));
        SupplierFactory.registerSupplier(new GlutenFreeShop(ui));

        OrderRepository orderRepository = new InMemoryOrderRepository();
        InformationService informationService = new StandardInformationService(ui);

        OrderingService orderingService = new StandardOrderingService(ui);
        OrderProcessor orderProcessor = new OrderProcessor(orderingService, orderRepository, informationService, ui);

        OrderRequest r1 = new OrderRequest("Apples", 3, "Adam");
        orderProcessor.process(r1, "ExtraFoodShop");
        ui.showMessage("");

        OrderRequest r2 = new OrderRequest("Bananas", 12, "Ewa");
        orderProcessor.process(r2, "ExtraFoodShop");
        ui.showMessage("");

        OrderRequest r3 = new OrderRequest("FastFoodWrap", 2, "Marek");
        orderProcessor.process(r3, "HealthyShop");
        ui.showMessage("");

        OrderRequest r4 = new OrderRequest("OrganicSalad", 10, "Karolina");
        orderProcessor.process(r4, "HealthyShop");
        ui.showMessage("");

        OrderRequest r5 = new OrderRequest("GlutenFreeBread", 5, "Piotr");
        orderProcessor.process(r5, "GlutenFreeShop");
        ui.showMessage("");

        OrderRequest r6 = new OrderRequest("Bread", 1, "Zofia");
        orderProcessor.process(r6, "GlutenFreeShop");
        ui.showMessage("");

        OrderRequest r7 = new OrderRequest("Milk", 1, "Tomek");
        orderProcessor.process(r7, "RandomShop");
        ui.showMessage("");

        ui.showMessage("=== ALL ORDERS IN THE REPOSITORY ===");
        for (Order o : orderRepository.findAll()) {
            String status = o.isCompleted() ? "ACCEPTED" : "REJECTED";
            ui.showMessage("[" + o.getSupplierName() + "] "
                    + o.getRequest().getProductName()
                    + " x" + o.getRequest().getQuantity()
                    + " (customer: " + o.getRequest().getCustomer() + ") → "
                    + status);
        }
    }
}
