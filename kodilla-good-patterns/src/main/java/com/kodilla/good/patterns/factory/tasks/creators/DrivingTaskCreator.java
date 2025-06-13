package com.kodilla.good.patterns.factory.tasks.creators;

import com.kodilla.good.patterns.factory.tasks.contract.Task;
import com.kodilla.good.patterns.factory.tasks.params.DrivingParams;
import com.kodilla.good.patterns.factory.tasks.tasks.DrivingTask;

public class DrivingTaskCreator implements TaskCreator<DrivingParams> {
    @Override
    public Task create(DrivingParams params) {
        return new DrivingTask(params.name(), params.where(), params.using());
    }
}
