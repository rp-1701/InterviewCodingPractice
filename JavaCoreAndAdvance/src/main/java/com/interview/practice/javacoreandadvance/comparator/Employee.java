package com.interview.practice.javacoreandadvance.comparator;

public class Employee {

    private int empId;
    private String empName;
    private Department empDepartment;
    private double empSalary;
    private Designation empDesignation;
    private String empLocation;
    private int empJoiningDate;


    public Employee(int empId, String empName, Department empDepartment, double empSalary, Designation empDesignation,
        String empLocation, int empJoiningDate) {
        this.empId = empId;
        this.empName = empName;
        this.empDepartment = empDepartment;
        this.empSalary = empSalary;
        this.empDesignation = empDesignation;
        this.empLocation = empLocation;
        this.empJoiningDate = empJoiningDate;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public Department getEmpDepartment() {
        return empDepartment;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public Designation getEmpDesignation() {
        return empDesignation;
    }

    public String getEmpLocation() {
        return empLocation;
    }

    public int getEmpJoiningDate() {
        return empJoiningDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
            "empId=" + empId +
            ", empName='" + empName + '\'' +
            ", empDepartment=" + empDepartment +
            ", empSalary=" + empSalary +
            ", empDesignation=" + empDesignation +
            ", empLocation='" + empLocation + '\'' +
            ", empJoiningDate=" + empJoiningDate +
            '}';
    }
}
