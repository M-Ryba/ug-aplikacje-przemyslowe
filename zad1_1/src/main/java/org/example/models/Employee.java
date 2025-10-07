package org.example.models;

import org.example.enums.JobPositions;
import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private String email;
    private String companyName;
    private JobPositions position;
    private float salary;

    public Employee(String firstName, String lastName, String email, String companyName, JobPositions position, float salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.companyName = companyName;
        this.position = position;
        this.salary = salary;
    }

    // Getters and setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public JobPositions getPosition() { return position; }
    public void setPosition(JobPositions position) { this.position = position; }
    public float getSalary() { return salary; }
    public void setSalary(float salary) { this.salary = salary; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(email, employee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return String.format("%s %s, email: %s, company: %s, position: %s, salary: %.2f",
                firstName, lastName, email, companyName, position.name(), salary);
    }
}
