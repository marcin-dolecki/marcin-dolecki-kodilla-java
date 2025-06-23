package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TaskFinancialDetailsDaoTestSuite {

    @Autowired
    private TaskFinancialDetailsDao taskFinancialDetailsDao;
    @Autowired
    private TaskDao taskDao;

    @Test
    void testFindByPaid() {
        TaskFinancialDetails taskFinancialDetails = new TaskFinancialDetails(new BigDecimal(115), false);
        taskFinancialDetailsDao.save(taskFinancialDetails);
        int id = taskFinancialDetails.getId();

        List<TaskFinancialDetails> resultList = taskFinancialDetailsDao.findByPaid(false);

        assertEquals(1, resultList.size());

        taskFinancialDetailsDao.deleteById(id);
    }

    @Test
    void testTaskDaoSaveWithFinancialDetails() {
        Task task = new Task("Test task description", 30);
        task.setTaskFinancialDetails(new TaskFinancialDetails(new BigDecimal(120), false));

        taskDao.save(task);
        int id = task.getId();
        System.out.println("Task id: " + id);

        assertNotEquals(0, id);

        taskDao.deleteById(id);
    }
}
