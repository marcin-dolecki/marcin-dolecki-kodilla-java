package com.kodilla.good.patterns.factory.tasks.creators;

import com.kodilla.good.patterns.factory.tasks.contract.Task;
import com.kodilla.good.patterns.factory.tasks.params.ShoppingParams;
import com.kodilla.good.patterns.factory.tasks.tasks.ShoppingTask;

public class ShoppingTaskCreator implements TaskCreator<ShoppingParams> {
    @Override
    public Task create(ShoppingParams params) {
        return new ShoppingTask(params.name(), params.whatToBuy(), params.quantity());
    }
}
