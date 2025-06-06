package com.kodilla.spring.library;

import org.springframework.stereotype.Repository;

/* WAY FOR AUTOMATICALLY INJECTION WITH @Component, @Service, @Repository, ect
@Repository
public final class LibraryDbController {
    public void saveData() {
        System.out.println("Saving data to the database");
    }

    public void loadData() {
        System.out.println("Loading data from the database");
    }
}

 */

/* WAY FOR MANUAL INJECTION WITH @Configuration*/
public final class LibraryDbController {
    public void saveData() {
        System.out.println("Saving data to the database");
    }

    public void loadData() {
        System.out.println("Loading data from the database");
    }
}