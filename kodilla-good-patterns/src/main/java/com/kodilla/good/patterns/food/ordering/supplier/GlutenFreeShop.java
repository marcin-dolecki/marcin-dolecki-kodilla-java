package com.kodilla.good.patterns.food.ordering.supplier;

import com.kodilla.good.patterns.food.ordering.model.OrderRequest;
import com.kodilla.good.patterns.food.ordering.ui.UserInterface;

public class GlutenFreeShop implements Supplier {
    private final UserInterface ui;

    public GlutenFreeShop(UserInterface ui) {
        this.ui = ui;
    }

    @Override
    public boolean process(OrderRequest request) {
        ui.showMessage("[GlutenFreeShop] Checking if "
                + request.getProductName()
                + " is gluten-free.");
        if (!request.getProductName().toLowerCase().contains("glutenfree")) {
            ui.showMessage("[GlutenFreeShop] Product not labeled as GLUTENFREE. Rejecting.");
            return false;
        }
        if (request.getQuantity() > 20) {
            ui.showMessage("[GlutenFreeShop] Max 20 units allowed. Rejecting.");
            return false;
        }
        ui.showMessage("[GlutenFreeShop] Product available. Processing order.");
        return true;
    }


    @Override
    public String getName() {
        return "GlutenFreeShop";
    }
}
