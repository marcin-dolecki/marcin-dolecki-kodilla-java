package com.kodilla.good.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    @Test
    void testBigmacBuilder() {
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("z sezamem")
                .burgers(2)
                .sauce("1000 wysp")
                .ingredient("sałata")
                .ingredient("bekon")
                .ingredient("ser")
                .build();

        System.out.println(bigmac);

        assertEquals("z sezamem", bigmac.getBun());
        assertEquals(2, bigmac.getBurgers());
        assertEquals("1000 wysp", bigmac.getSauce());
        assertTrue(bigmac.getIngredients().contains("sałata"));
        assertTrue(bigmac.getIngredients().contains("bekon"));
        assertTrue(bigmac.getIngredients().contains("ser"));
        assertEquals(3, bigmac.getIngredients().size());
    }

    @Test
    void testBigmacBuilderWithInvalidIngredient() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Bigmac.BigmacBuilder()
                    .bun("z sezamem")
                    .burgers(2)
                    .ingredient("ananas")
                    .build();
        });

        assertEquals("Składnik niedozwolony: ananas", exception.getMessage());
    }
}
