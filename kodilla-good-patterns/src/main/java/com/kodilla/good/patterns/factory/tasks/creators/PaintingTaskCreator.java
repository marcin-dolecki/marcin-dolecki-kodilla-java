package com.kodilla.good.patterns.factory.tasks.creators;

import com.kodilla.good.patterns.factory.tasks.contract.Task;
import com.kodilla.good.patterns.factory.tasks.params.PaintingParams;
import com.kodilla.good.patterns.factory.tasks.tasks.PaintingTask;

public class PaintingTaskCreator implements TaskCreator<PaintingParams> {
    @Override
    public Task create(PaintingParams params) {
        return new PaintingTask(params.name(), params.color(), params.whatToPain());
    }
}
