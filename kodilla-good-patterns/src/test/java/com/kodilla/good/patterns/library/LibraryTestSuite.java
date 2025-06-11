package com.kodilla.good.patterns.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryTestSuite {
    @Test
    void testGetBooks() {
        Library library1 = new Library("Library 1");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> library1.getBooks().add(new Book("Book " + n, "Author " + n, LocalDate.of(1990 + n, 1, 1))));

        System.out.println(library1);

        assertEquals(10, library1.getBooks().size());
    }
}
