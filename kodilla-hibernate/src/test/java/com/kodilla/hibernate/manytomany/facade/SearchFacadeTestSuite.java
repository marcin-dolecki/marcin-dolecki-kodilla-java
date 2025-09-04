package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
class SearchFacadeTestSuite {

    @Autowired
    private SearchFacade searchFacade;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testFindCompaniesByNameFragment() {
        Company softwareMachine = new Company("Software Machine");
        Company dataMasters = new Company("Data Masters");
        companyDao.save(softwareMachine);
        companyDao.save(dataMasters);

        List<Company> result = searchFacade.findCompaniesByNameFragment("ware");

        assertEquals(1, result.size());
        assertEquals("Software Machine", result.get(0).getName());

        companyDao.deleteAll();
    }

    @Test
    void testFindEmployeesByNameFragment() {
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);

        List<Employee> result = searchFacade.findEmployeesByNameFragment("mith");

        assertEquals(1, result.size());
        assertEquals("Smith", result.get(0).getLastName());

        employeeDao.deleteAll();
    }
}
