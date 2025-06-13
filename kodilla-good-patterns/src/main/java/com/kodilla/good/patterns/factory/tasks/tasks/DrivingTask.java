package com.kodilla.good.patterns.factory.tasks.tasks;

import com.kodilla.good.patterns.factory.tasks.contract.Task;

public class DrivingTask implements Task {
    private final String taskName;
    private final String where;
    private final String using;
    private boolean executed = false;

    public DrivingTask(final String taskName, final String where, final String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public void executeTask() {
        System.out.println("Driving to " + where + " using " + using);
        executed = true;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return executed;
    }
}
