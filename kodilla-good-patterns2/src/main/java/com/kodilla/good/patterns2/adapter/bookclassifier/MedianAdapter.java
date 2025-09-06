package com.kodilla.good.patterns2.adapter.bookclassifier;

import com.kodilla.good.patterns2.adapter.bookclassifier.librarya.Book;
import com.kodilla.good.patterns2.adapter.bookclassifier.librarya.Classifier;
import com.kodilla.good.patterns2.adapter.bookclassifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    @Override
    public int publicationYearMedian(Set<Book> bookSet) {
        Map<BookSignature, com.kodilla.good.patterns2.adapter.bookclassifier.libraryb.Book> booksMap = new HashMap<>();

        for (Book oldBook : bookSet) {
            BookSignature signature = new BookSignature(oldBook.getSignature());
            com.kodilla.good.patterns2.adapter.bookclassifier.libraryb.Book newBook = new com.kodilla.good.patterns2.adapter.bookclassifier.libraryb.Book(
                    oldBook.getAuthor(),
                    oldBook.getTitle(),
                    oldBook.getPublicationYear()
            );
            booksMap.put(signature, newBook);
        }
        return medianPublicationYear(booksMap);
    }
}
