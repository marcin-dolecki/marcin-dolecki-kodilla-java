package com.kodilla.good.patterns.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.IntStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LibraryTestSuite {
    @Test
    void testGetBooks() {
        Library library = new Library("Library");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> library.getBooks().add(new Book("Book " + n, "Author " + n, LocalDate.of(1990 + n, 1, 1))));
        
        Library shallowClonedLibrary = null;
        try {
            shallowClonedLibrary = library.shallowCopy();
            shallowClonedLibrary.setName("Shallow Cloned Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Deep Cloned Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(library);
        System.out.println(shallowClonedLibrary);
        System.out.println(deepClonedLibrary);

        Set<String> titlesToRemove = Set.of("Book 1", "Book 2", "Book 3", "Book 4");
        library.getBooks().removeIf(book -> titlesToRemove.contains(book.getTitle()));

        System.out.println(library);
        System.out.println(shallowClonedLibrary);
        System.out.println(deepClonedLibrary);

        assertEquals(6, library.getBooks().size());
        assertNotNull(shallowClonedLibrary);
        assertEquals(6, shallowClonedLibrary.getBooks().size());
        assertNotNull(deepClonedLibrary);
        assertEquals(10, deepClonedLibrary.getBooks().size());
    }
}
