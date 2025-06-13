package com.kodilla.good.patterns.factory.tasks.contract;

public interface Task {
    void executeTask();
    String getTaskName();
    boolean isTaskExecuted();
}
