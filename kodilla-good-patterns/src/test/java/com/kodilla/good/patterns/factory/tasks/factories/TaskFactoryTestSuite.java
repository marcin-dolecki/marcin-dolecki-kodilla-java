package com.kodilla.good.patterns.factory.tasks.factories;

import com.kodilla.good.patterns.factory.tasks.contract.Task;
import com.kodilla.good.patterns.factory.tasks.params.DrivingParams;
import com.kodilla.good.patterns.factory.tasks.params.PaintingParams;
import com.kodilla.good.patterns.factory.tasks.params.ShoppingParams;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskFactoryTestSuite {
    @Test
    void testFactoryShoppingTask() {
        ShoppingParams params = new ShoppingParams("Buy groceries", "Milk", 2.0);
        Task task = TaskFactory.createTask(params);

        assert task != null;
        assertEquals("Buy groceries", task.getTaskName());
        assertFalse(task.isTaskExecuted());

        task.executeTask();

        assertTrue(task.isTaskExecuted());
    }

    @Test
    void testFactoryPaintingTask() {
        PaintingParams params = new PaintingParams("Painting", "blue", "wall");
        Task task = TaskFactory.createTask(params);

        assert task != null;
        assertEquals("Painting", task.getTaskName());
        assertFalse(task.isTaskExecuted());

        task.executeTask();

        assertTrue(task.isTaskExecuted());
    }

    @Test
    void testFactoryDrivingTask() {
        DrivingParams params = new DrivingParams("Driving", "home", "car");
        Task task = TaskFactory.createTask(params);

        assert task != null;
        assertEquals("Driving", task.getTaskName());
        assertFalse(task.isTaskExecuted());

        task.executeTask();

        assertTrue(task.isTaskExecuted());
    }
}
