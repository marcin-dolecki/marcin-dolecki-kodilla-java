package com.kodilla.spring.library;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class LibraryTestSuite {
    @Test
    void testLoadFromDb() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.library");
        Library library = context.getBean(Library.class);

        library.loadFromDb();
    }

    @Test
    void testSaveToDb() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.library");
        Library library = context.getBean(Library.class);

        library.saveToDb();
    }
}
