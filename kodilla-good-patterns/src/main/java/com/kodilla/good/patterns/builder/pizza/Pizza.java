package com.kodilla.good.patterns.builder.pizza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Pizza {
    private final String bottom;
    private final String sauce;
    private List<String> ingredients = new ArrayList<>();

    public static class PizzaBuilder {
        private String bottom;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public PizzaBuilder bottom(String bottom) {
            this.bottom = bottom;
            return this;
        }

        public PizzaBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public PizzaBuilder ingredient(String ingredient) {
            this.ingredients.add(ingredient);
            return this;
        }

        public Pizza build() {
            return new Pizza(bottom, sauce, ingredients);
        }
    }

    private Pizza(final String bottom, final String sauce, final List<String> ingredients) {
        this.bottom = bottom;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public String getBottom() {
        return bottom;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "bottom='" + bottom + '\'' +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
