package com.kodilla.good.patterns2.adapter.company;

import com.kodilla.good.patterns2.adapter.company.oldhrsystem.Workers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SalaryAdapterTestSuite {

    @Test
    void testTotalSalary() {
        Workers workers = new Workers();
        SalaryAdapter salaryAdapter = new SalaryAdapter();

        double totalSalary = salaryAdapter.totalSalary(workers.getWorkers(), workers.getSalaries());

        System.out.println(totalSalary);
        assertEquals(27750, totalSalary, 0);
    }
}
