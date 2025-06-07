package com.kodilla.spring.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/* USING GET BEAN */
//@SpringBootTest
//class LibraryTestSuite {
//    @Test
//    void testLoadFromDb() {
//        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.library");
//        Library library = context.getBean(Library.class);
//
//        library.loadFromDb();
//    }
//
//    @Test
//    void testSaveToDb() {
//        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.library");
//        Library library = context.getBean(Library.class);
//
//        library.saveToDb();
//    }
//}


/* USING AUTOWIRED */
//@SpringBootTest
//class LibraryTestSuite {
//    @Autowired
//    private Library library;
//
//    @Test
//    void testLoadFromDb() {
//        library.loadFromDb();
//    }
//
//    @Test
//    void testSaveToDb() {
//        library.saveToDb();
//    }
//}

/* APPLICATION CONTEXT */
@SpringBootTest
class LibraryTestSuite {
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

    @Test
    void testContext() {
        ApplicationContext context = new AnnotationConfigApplicationContext(LibraryConfig.class);

        System.out.println("===== Beans list: ==== >>");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        System.out.println("<< ==== Beans list: =====");
    }

    @Test
    void testContextFromWholeSpringPackage() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");

        System.out.println("===== Beans list: ==== >>");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        System.out.println("<< ==== Beans list: =====");
    }
}