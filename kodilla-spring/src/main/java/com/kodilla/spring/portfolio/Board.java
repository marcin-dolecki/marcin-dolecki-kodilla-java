package com.kodilla.spring.portfolio;

public class Board {
    public final TaskList toDoList;
    public final TaskList inProgressList;
    public final TaskList doneList;

    public Board(final TaskList toDoList, final TaskList inProgressList, final TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }
}
