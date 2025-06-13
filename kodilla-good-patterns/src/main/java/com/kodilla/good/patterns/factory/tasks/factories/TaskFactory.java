package com.kodilla.good.patterns.factory.tasks.factories;

import com.kodilla.good.patterns.factory.tasks.contract.Task;
import com.kodilla.good.patterns.factory.tasks.creators.DrivingTaskCreator;
import com.kodilla.good.patterns.factory.tasks.creators.PaintingTaskCreator;
import com.kodilla.good.patterns.factory.tasks.creators.ShoppingTaskCreator;
import com.kodilla.good.patterns.factory.tasks.params.DrivingParams;
import com.kodilla.good.patterns.factory.tasks.params.PaintingParams;
import com.kodilla.good.patterns.factory.tasks.params.ShoppingParams;

public final class TaskFactory {

    public static Task createTask(Object params) {
        return switch (params) {
            case ShoppingParams shoppingParams -> new ShoppingTaskCreator().create(shoppingParams);
            case PaintingParams paintingParams -> new PaintingTaskCreator().create(paintingParams);
            case DrivingParams drivingParams -> new DrivingTaskCreator().create(drivingParams);
            default -> null;
        };
    }
}
