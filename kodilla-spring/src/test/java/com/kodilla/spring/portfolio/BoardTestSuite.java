package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.jupiter.api.Assertions.*;

/* @SpringBootTest --> not use if not needed, it launches whole Spring Boot app */
class BoardTestSuite {
    @Test
    void testTaskAdd() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        board.toDoList.addTask("Go shopping");
        board.inProgressList.addTask("Cleaning house");
        board.doneList.addTask("Walking the dog");

        assertEquals("Go shopping", board.toDoList.getTasks().get(0));
        assertEquals("Cleaning house", board.inProgressList.getTasks().get(0));
        assertEquals("Walking the dog", board.doneList.getTasks().get(0));
    }
}
