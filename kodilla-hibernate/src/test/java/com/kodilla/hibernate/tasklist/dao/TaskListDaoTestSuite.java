package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Test
    void testTaskListDaoFindByListName() {
        TaskList taskList = new TaskList("To do list", "Lista zadań do wykonania");
        taskListDao.save(taskList);
        String listName = taskList.getListName();

        List<TaskList> readTaskLists = taskListDao.findByListName(listName);

        assertEquals("To do list", readTaskLists.get(0).getListName());

        int id = readTaskLists.get(0).getId();
        taskListDao.deleteById(id);
    }

    @Test
    void testTaskListDaoSaveWithTasks() {
        Task task = new Task("Test: learn hibernate", 14);
        Task task2 = new Task("Test: write some entities", 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);
        TaskList taskList = new TaskList("ToDo", "Tasks to do");
        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);
        task.setTaskList(taskList);
        task2.setTaskList(taskList);

        taskListDao.save(taskList);
        int id = taskList.getId();

        assertNotEquals(0, id);

        taskListDao.deleteById(id);
    }
}
