package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchFacade {

    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    public SearchFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public List<Company> findCompaniesByNameFragment(String nameFragment) {
        return companyDao.retrieveCompaniesByNameFragment("%" + nameFragment + "%");
    }

    public List<Employee> findEmployeesByNameFragment(String nameFragment) {
        return employeeDao.retrieveEmployeesByNameFragment("%" + nameFragment + "%");
    }
}
