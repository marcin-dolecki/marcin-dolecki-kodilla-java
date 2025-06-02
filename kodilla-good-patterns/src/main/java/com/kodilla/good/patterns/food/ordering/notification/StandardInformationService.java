package com.kodilla.good.patterns.food.ordering.notification;

import com.kodilla.good.patterns.food.ordering.model.Order;
import com.kodilla.good.patterns.food.ordering.model.OrderRequest;
import com.kodilla.good.patterns.food.ordering.ui.UserInterface;

public class StandardInformationService implements InformationService {
    private final UserInterface ui;

    public StandardInformationService(UserInterface ui) {
        this.ui = ui;
    }

    @Override
    public void notifyCustomer(Order order) {
        String status = order.isCompleted() ? "ACCEPTED" : "REJECTED";
        String msg = "[Notification->Customer] Your order at "
                + order.getSupplierName()
                + " for " + order.getRequest().getProductName()
                + " x " + order.getRequest().getQuantity()
                + " has been " + status + ".";
        ui.showMessage(msg);
    }

    @Override
    public void notifySupplier(OrderRequest orderRequest, String supplierName) {
        String msg = "[Notification->Supplier:  " + supplierName + "] "
                + "New order: " + orderRequest.getProductName()
                + " x " + orderRequest.getQuantity()
                + " from customer: " + orderRequest.getCustomer() + ".";
        ui.showMessage(msg);
    }
}
