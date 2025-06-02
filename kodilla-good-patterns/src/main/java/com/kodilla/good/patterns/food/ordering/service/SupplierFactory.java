package com.kodilla.good.patterns.food.ordering.service;

import com.kodilla.good.patterns.food.ordering.supplier.Supplier;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class SupplierFactory {
    private static final Map<String, Supplier> registry = new HashMap<>();

    private SupplierFactory() {/* private constructor */}

    public static Optional<Supplier> getSupplier(String supplierName) {
        return Optional.ofNullable(registry.get(supplierName));
    }
}
