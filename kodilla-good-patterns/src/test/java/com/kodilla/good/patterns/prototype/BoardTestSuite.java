package com.kodilla.good.patterns.prototype;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BoardTestSuite {
    @Test
    void testToString() {
        TaskList listToDo = new TaskList("To Do Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listToDo.getTasks().add(new Task("To Do Task Number " + n)));

        TaskList listInProgress = new TaskList("In Progress Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listInProgress.getTasks().add(new Task("In Progress Task Number " + n)));

        TaskList listDone = new TaskList("Done Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listDone.getTasks().add(new Task("Done Task Number " + n)));

        Board board  = new Board("Project number 1");
        board.getLists().add(listToDo);
        board.getLists().add(listInProgress);
        board.getLists().add(listDone);

        Board clonedBoard = null;
        try {
            clonedBoard = board.shallowCopy();
            clonedBoard.setName("Project number 2");
        } catch (CloneNotSupportedException e) {
            System.out.println("Error:" + e);
        }

        System.out.println(board);
        System.out.println(clonedBoard);

        // be careful! swallow cloning, copy references to other classes (no creating the new ones).
        // so doing change on the new board, we are changing also first board
        board.getLists().remove(listToDo);

        System.out.println(board);
        System.out.println(clonedBoard);

        assertEquals(2, board.getLists().size());
        assertNotNull(clonedBoard);
        assertEquals(2, clonedBoard.getLists().size());
    }
}
