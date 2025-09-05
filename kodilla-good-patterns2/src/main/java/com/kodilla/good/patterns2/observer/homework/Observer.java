package com.kodilla.good.patterns2.observer.homework;

public interface Observer {
    void update(Student student, String task);
    void removeFirstTask(Student student);
}
