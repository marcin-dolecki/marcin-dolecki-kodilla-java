package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveManyToMany() {
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine ");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);
        int softwareMachineId = softwareMachine.getId();
        int dataMaesterId = dataMaesters.getId();
        int greyMatterId = greyMatter.getId();

        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaesterId);
        assertNotEquals(0, greyMatterId);

        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaesterId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            // do nothing
        }
    }

    @Test
    void testRetrieveEmployeeBySurname() {
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        Employee laraSmith = new Employee("Lara", "Smith");

        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaKovalsky);
        employeeDao.save(laraSmith);

        List<Employee> smithEmployees = employeeDao.retrieveEmployeesBySurname("Smith");

        try {
            assertEquals("Smith", smithEmployees.get(0).getLastName());
            assertEquals(2, smithEmployees.size());
        } finally {
            employeeDao.deleteAll();
        }
    }

    @Test
    void testRetrieveCompaniesByFirst3Letters() {
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");
        Company softwareEngineering = new Company("Software Engineering");

        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);
        companyDao.save(softwareEngineering);

        List<Company> sofCompanies = companyDao.retrieveCompaniesByFirst3Letters("Sof");

        try {
            assertEquals("Software Machine", sofCompanies.get(0).getName());
            assertEquals(2, sofCompanies.size());
        } finally {
            companyDao.deleteAll();
        }
    }
}
