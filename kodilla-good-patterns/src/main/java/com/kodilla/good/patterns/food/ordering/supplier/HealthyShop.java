package com.kodilla.good.patterns.food.ordering.supplier;

import com.kodilla.good.patterns.food.ordering.model.OrderRequest;
import com.kodilla.good.patterns.food.ordering.ui.UserInterface;

public class HealthyShop implements Supplier {
    private final UserInterface ui;

    public HealthyShop(UserInterface ui) {
        this.ui = ui;
    }

    @Override
    public boolean process(OrderRequest request) {
        ui.showMessage("[HealthyShop] Verifying product: "
                + request.getProductName());
        if (request.getProductName().toLowerCase().contains("fastfood")) {
            ui.showMessage("[HealthyShop] Unhealthy product. Rejecting.");
            return false;
        }
        ui.showMessage("[HealthyShop] Product OK. Adding freshness guarantee.");
        return true;
    }

    @Override
    public String getName() {
        return "HealthyShop";
    }
}
