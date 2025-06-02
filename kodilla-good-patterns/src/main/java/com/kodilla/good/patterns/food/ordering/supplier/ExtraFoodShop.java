package com.kodilla.good.patterns.food.ordering.supplier;

import com.kodilla.good.patterns.food.ordering.model.OrderRequest;
import com.kodilla.good.patterns.food.ordering.ui.UserInterface;

public class ExtraFoodShop implements Supplier {
    private final UserInterface ui;

    public ExtraFoodShop(UserInterface ui) {
        this.ui = ui;
    }

    @Override
    public boolean process(OrderRequest orderRequest) {
        ui.showMessage("[ExtraFoodShop] Checking availability: "
                + orderRequest.getProductName()
                + " x " + orderRequest.getQuantity());
        if (orderRequest.getQuantity() > 10) {
            ui.showMessage("[ExtraFoodShop] Not enough stock. Rejecting order.");
            return false;
        }
        if (orderRequest.getQuantity() > 5) {
            ui.showMessage("[ExtraFoodShop] Applying 5% discount.");
        }
        ui.showMessage("[ExtraFoodShop] Product available. Finalizing order.");
        return true;
    }

    @Override
    public String getName() {
        return "ExtraFoodShop";
    }
}
