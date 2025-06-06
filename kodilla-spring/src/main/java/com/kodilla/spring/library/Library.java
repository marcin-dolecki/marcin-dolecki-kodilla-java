package com.kodilla.spring.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/* INJECTION BY CONSTRUCTOR (THE BEST CHOICE) */
@Service
public final class Library {
    private final List<String> books = new ArrayList<>();
    private final LibraryDbController libraryDbController;

    public Library(final LibraryDbController libraryDbController) {
        this.libraryDbController = libraryDbController;
    }

    public void saveToDb() {
        libraryDbController.saveData();
    }

    public void loadFromDb() {
        libraryDbController.loadData();
    }
}

/* INJECTION BY CONSTRUCTOR WITH AUTOWIRED (THE BEST CHOICE)
@Service
public final class Library {
    private final List<String> books = new ArrayList<>();
    private LibraryDbController libraryDbController;

    @Autowired
    public Library(final LibraryDbController libraryDbController) {
        this.libraryDbController = libraryDbController;
    }

    public Library() {
        // do nothing
    }

    public void saveToDb() {
        libraryDbController.saveData();
    }

    public void loadFromDb() {
        libraryDbController.loadData();
    }
}
 */

/* INJECTION BY METHOD (NOT RECOMMENDED)
@Service
public final class Library {
    private final List<String> books = new ArrayList<>();
    private LibraryDbController libraryDbController;

    @Autowired
    public void setLibraryDbController(LibraryDbController libraryDbController) {
        this.libraryDbController = libraryDbController;
    }

    public void saveToDb() {
        libraryDbController.saveData();
    }

    public void loadFromDb() {
        libraryDbController.loadData();
    }
}
*/

/* INJECTION INTO CLASS PROPERTIES (VERY NOT RECOMMENDED)
@Service
public final class Library {
    private final List<String> books = new ArrayList<>();

    @Autowired
    private LibraryDbController libraryDbController;

    public void saveToDb() {
        libraryDbController.saveData();
    }

    public void loadFromDb() {
        libraryDbController.loadData();
    }
}

 */
