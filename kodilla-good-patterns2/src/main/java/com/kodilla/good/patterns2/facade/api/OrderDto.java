package com.kodilla.good.patterns2.facade.api;

import java.util.ArrayList;
import java.util.List;

public final class OrderDto {
    private final List<ItemDto> items = new ArrayList<>();

    public void addItem(final ItemDto item) {
        items.add(item);
    }

    public void removeItemById(final Long productId) {
        items.removeIf(item -> item.getProductId().equals(productId));
    }

    public List<ItemDto> getItems() {
        return items;
    }
}
