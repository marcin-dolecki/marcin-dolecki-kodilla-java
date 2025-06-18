package com.kodilla.good.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public final class Bigmac {

    public static final List<String> AVAILABLE_INGREDIENTS = List.of(
        "sałata", "cebulka", "bekon", "ogórek", "papryczki chilli", "pieczarki", "krewetki", "ser"
    );

    private final String bun;
    private final int burgers;
    private final String sauce;
    private final List<String> ingredients = new ArrayList<>();

    private Bigmac(BigmacBuilder builder) {
        this.bun = builder.bun;
        this.burgers = builder.burgers;
        this.sauce = builder.sauce;
        this.ingredients.addAll(builder.ingredients);
    }

    public String getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public static class BigmacBuilder {
        private String bun;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder bun(String bun) {
            if (!bun.equals("z sezamem") && !bun.equals("bez sezamu")) {
                throw new IllegalArgumentException("Dozwolone wartości: z sezamem, bez sezamu.");
            }
            this.bun = bun;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            if (burgers < 1 || burgers > 3) {
                throw new IllegalArgumentException("Big Mac musi mieć od 1 do 3 burgerów.");
            }
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            if (!List.of("standard", "1000 wysp", "barbecue").contains(sauce)) {
                throw new IllegalArgumentException("Nieznany sos.");
            }
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(String ingredient) {
            if (!Bigmac.AVAILABLE_INGREDIENTS.contains(ingredient)) {
                throw new IllegalArgumentException("Składnik niedozwolony: " + ingredient);
            }
            this.ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            return new Bigmac(this);
        }
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun='" + bun + '\'' +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
