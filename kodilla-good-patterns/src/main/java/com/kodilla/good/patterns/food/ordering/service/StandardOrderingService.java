package com.kodilla.good.patterns.food.ordering.service;

import com.kodilla.good.patterns.food.ordering.model.OrderRequest;
import com.kodilla.good.patterns.food.ordering.supplier.Supplier;
import com.kodilla.good.patterns.food.ordering.ui.UserInterface;

import java.util.Optional;

public class StandardOrderingService implements OrderingService {
    private final UserInterface ui;

    public StandardOrderingService(UserInterface ui) {
        this.ui = ui;
    }

    @Override
    public boolean placeOrder(String supplierName, OrderRequest orderRequest) {
        Optional<Supplier> optionalSupplier = SupplierFactory.getSupplier(supplierName);
        if (optionalSupplier.isEmpty()) {
            ui.showMessage("[OrderingService] Supplier not found: " + supplierName);
            return false;
        }
        Supplier supplier = optionalSupplier.get();
        ui.showMessage("[OrderingService] Passing to the producer: " + supplierName);
        return supplier.process(orderRequest);
    }
}
