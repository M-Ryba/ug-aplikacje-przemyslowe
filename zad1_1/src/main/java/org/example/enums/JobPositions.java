package org.example.enums;

public enum JobPositions {
    PRESIDENT(25000, 1),
    VICE_PRESIDENT(18000, 2),
    MANAGER(12000, 3),
    PROGRAMMER(8000, 4),
    INTERN(3000, 5);

    public final float baseSalary;
    public final int hierarchyLevel;

    JobPositions(float baseSalary, int hierarchyLevel) {
        this.baseSalary = baseSalary;
        this.hierarchyLevel = hierarchyLevel;
    }
}
