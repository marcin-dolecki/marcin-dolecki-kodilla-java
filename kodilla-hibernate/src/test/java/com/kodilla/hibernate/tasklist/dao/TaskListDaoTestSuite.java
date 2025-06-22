package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
