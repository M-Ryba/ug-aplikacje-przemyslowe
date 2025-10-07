package org.example.services;

import org.example.models.Employee;
import org.example.enums.JobPositions;

import java.util.*;
import java.util.stream.Collectors;

public class Company {
    private final Set<Employee> employees = new HashSet<>();

    // Add new employee to the company
    public boolean addEmployee(Employee employee) {
        return employees.add(employee);
    }

    // List of all employees
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    // Search for employees by company name
    public List<Employee> findByCompany(String companyName) {
        return employees.stream()
                .filter(e -> e.getCompanyName().equalsIgnoreCase(companyName))
                .collect(Collectors.toList());
    }

    // Sort employees by last name
    public List<Employee> getEmployeesSortedByLastName() {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getLastName))
                .collect(Collectors.toList());
    }

    // Group employees by position
    public Map<JobPositions, List<Employee>> groupByPosition() {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getPosition));
    }

    // Count employees by position
    public Map<JobPositions, Long> countByPosition() {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getPosition, Collectors.counting()));
    }

    // Mean salary of all employees
    public double getAverageSalary() {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }

    // Employee with the highest salary
    public Optional<Employee> getHighestPaidEmployee() {
        return employees.stream()
                .max(Comparator.comparing(Employee::getSalary));
    }
}