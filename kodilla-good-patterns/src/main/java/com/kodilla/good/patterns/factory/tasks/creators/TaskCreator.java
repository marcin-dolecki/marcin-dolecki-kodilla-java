package com.kodilla.good.patterns.factory.tasks.creators;

import com.kodilla.good.patterns.factory.tasks.contract.Task;

public interface TaskCreator<T> {
    Task create(T params);
}
