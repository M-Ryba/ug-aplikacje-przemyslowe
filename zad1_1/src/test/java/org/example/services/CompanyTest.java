package org.example.services;

import org.example.models.Employee;
import org.example.enums.JobPositions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {
    private Company company;
    private Employee emp1;
    private Employee emp2;
    private Employee emp3;
    private Employee emp4;

    @BeforeEach
    void setUp() {
        company = new Company();
        emp1 = new Employee("Jan", "Nowak", "jan.nowak@techcorp.com", "TechCorp", JobPositions.PRESIDENT, 25000);
        emp2 = new Employee("Anna", "Kowalska", "anna.kowalska@techcorp.com", "TechCorp", JobPositions.MANAGER, 12000);
        emp3 = new Employee("Piotr", "Zieliński", "piotr.zielinski@softdev.com", "SoftDev", JobPositions.PROGRAMMER, 8000);
        emp4 = new Employee("Ewa", "Wiśniewska", "ewa.wisniewska@techcorp.com", "TechCorp", JobPositions.INTERN, 3000);
    }

    @Test
    void testAddEmployeeUniqueEmail() {
        assertTrue(company.addEmployee(emp1));
        assertFalse(company.addEmployee(new Employee("Jan", "Nowak", "jan.nowak@techcorp.com", "TechCorp", JobPositions.PRESIDENT, 25000)));
    }

    @Test
    void testGetAllEmployees() {
        company.addEmployee(emp1);
        company.addEmployee(emp2);
        List<Employee> all = company.getAllEmployees();
        assertEquals(2, all.size());
        assertTrue(all.contains(emp1));
        assertTrue(all.contains(emp2));
    }

    @Test
    void testFindByCompany() {
        company.addEmployee(emp1);
        company.addEmployee(emp2);
        company.addEmployee(emp3);
        List<Employee> techCorpEmployees = company.findByCompany("TechCorp");
        assertEquals(2, techCorpEmployees.size());
        assertTrue(techCorpEmployees.contains(emp1));
        assertTrue(techCorpEmployees.contains(emp2));
        assertFalse(techCorpEmployees.contains(emp3));
    }

    @Test
    void testGetEmployeesSortedByLastName() {
        company.addEmployee(emp1);
        company.addEmployee(emp2);
        company.addEmployee(emp3);
        List<Employee> sorted = company.getEmployeesSortedByLastName();
        assertEquals(List.of(emp2, emp1, emp3), sorted);
    }

    @Test
    void testGroupByPosition() {
        company.addEmployee(emp1);
        company.addEmployee(emp2);
        company.addEmployee(emp3);
        company.addEmployee(emp4);
        Map<JobPositions, List<Employee>> grouped = company.groupByPosition();
        assertEquals(1, grouped.get(JobPositions.PRESIDENT).size());
        assertEquals(1, grouped.get(JobPositions.MANAGER).size());
        assertEquals(1, grouped.get(JobPositions.PROGRAMMER).size());
        assertEquals(1, grouped.get(JobPositions.INTERN).size());
    }

    @Test
    void testCountByPosition() {
        company.addEmployee(emp1);
        company.addEmployee(emp2);
        company.addEmployee(emp3);
        company.addEmployee(emp4);
        Map<JobPositions, Long> counted = company.countByPosition();
        assertEquals(1, counted.get(JobPositions.PRESIDENT));
        assertEquals(1, counted.get(JobPositions.MANAGER));
        assertEquals(1, counted.get(JobPositions.PROGRAMMER));
        assertEquals(1, counted.get(JobPositions.INTERN));
    }

    @Test
    void testGetAverageSalary() {
        company.addEmployee(emp1);
        company.addEmployee(emp2);
        company.addEmployee(emp3);
        double avg = company.getAverageSalary();
        assertEquals((25000 + 12000 + 8000) / 3.0, avg);
    }

    @Test
    void testGetHighestPaidEmployee() {
        company.addEmployee(emp1);
        company.addEmployee(emp2);
        company.addEmployee(emp3);
        Optional<Employee> highest = company.getHighestPaidEmployee();
        assertTrue(highest.isPresent());
        assertEquals(emp1, highest.get());
    }
}
