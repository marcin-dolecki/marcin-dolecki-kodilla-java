package com.kodilla.good.patterns2.adapter.bookclassifier;

import com.kodilla.good.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedianAdapterTestSuite {

    @Test
    void publicationYearMedianTest() {
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("Henryk Sienkiewicz", "Quo Vadis", 1896, "SIG001"));
        bookSet.add(new Book("Bolesław Prus", "Lalka", 1890, "SIG002"));
        bookSet.add(new Book("Adam Mickiewicz", "Pan Tadeusz", 1834, "SIG003"));
        bookSet.add(new Book("Juliusz Słowacki", "Kordian", 1834, "SIG004"));
        bookSet.add(new Book("Stefan Żeromski", "Ludzie bezdomni", 1900, "SIG005"));

        MedianAdapter medianAdapter = new MedianAdapter();
        int medianYear = medianAdapter.publicationYearMedian(bookSet);

        assertEquals(1890, medianYear);
    }
}
