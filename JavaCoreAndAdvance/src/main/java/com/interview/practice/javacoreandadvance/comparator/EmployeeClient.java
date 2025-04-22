package com.interview.practice.javacoreandadvance.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class EmployeeClient {

    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "John Doe", Department.IT, 60000, Designation.SENIOR_DEVELOPER, "New York", 2020);
        Employee emp2 = new Employee(2, "Jane Smith", Department.HR, 50000, Designation.JUNIOR_DEVELOPER, "Los Angeles", 2019);
        Employee emp3 = new Employee(3, "Alice Johnson", Department.FINANCE, 70000, Designation.MANAGER, "Chicago", 2018);
        Employee emp4 = new Employee(4, "Bob Brown", Department.SALES, 55000, Designation.TEAM_LEAD, "Houston", 2021);
        Employee emp5 = new Employee(5, "Charlie White", Department.RESEARCH_AND_DEVELOPMENT, 80000, Designation.ARCHITECT, "Phoenix", 2017);
        Employee emp6 = new Employee(6, "David Green", Department.RESEARCH_AND_DEVELOPMENT, 65000, Designation.SENIOR_DEVELOPER, "Philadelphia", 2022);
        Employee emp7 = new Employee(7, "Eve Black", Department.IT, 45000, Designation.JUNIOR_DEVELOPER, "San Antonio", 2023);
        Employee emp8 = new Employee(6, "John White", Department.RESEARCH_AND_DEVELOPMENT, 75000, Designation.SENIOR_DEVELOPER, "Philadelphia", 2022);
        Employee emp9 = new Employee(1, "Jack Reacher", Department.IT, 60000, Designation.SENIOR_DEVELOPER, "New York", 2018);


        ArrayList<Employee> employeesList = new ArrayList<>(Arrays.asList(emp9, emp2, emp3, emp4, emp5, emp8, emp7, emp6, emp1));

        /*
           let us say we want to sort the employee as per Department, then Designation, then Salary, then Year of Joining

              Now in the Future, lets say sorting requirement changes
                sort it as Designation, then Department, then Salary, then Year of Joining

              while implementing this new requirement we do not need to change anything in the Employee class.

         */

        // using lamda expression
        Comparator<Employee> comparator1 = (e1, e2) -> {

            int departmentComparison = e1.getEmpDepartment().compareTo(e2.getEmpDepartment());
            if(departmentComparison != 0) {
                return departmentComparison;
            }

            int designationComparison = e1.getEmpDesignation().compareTo(e2.getEmpDesignation());
            if(designationComparison != 0) {
                return designationComparison;
            }

            int salaryComparison = Double.compare(e1.getEmpSalary(), e2.getEmpSalary());
            if(salaryComparison != 0) {
                return salaryComparison;
            }

            return Integer.compare(e1.getEmpJoiningDate(), e2.getEmpJoiningDate());

        };

        // using anonymous class
        Comparator<Employee> comparator2 = new Comparator<>() {

            @Override
            public int compare(Employee e1, Employee e2) {

                int designationComparison = e1.getEmpDesignation().compareTo(e2.getEmpDesignation());
                if(designationComparison != 0) {
                    return designationComparison;
                }

                int departmentComparison = e1.getEmpDepartment().compareTo(e2.getEmpDepartment());
                if(departmentComparison != 0) {
                    return departmentComparison;
                }

                int salaryComparison = Double.compare(e1.getEmpSalary(), e2.getEmpSalary());
                if(salaryComparison != 0) {
                    return salaryComparison;
                }

                return Integer.compare(e1.getEmpJoiningDate(), e2.getEmpJoiningDate());

            }
        };

        System.out.println("Sorting as per Department, then Designation, then Salary, then Year of Joining");
        System.out.println("----------------------------------------");

        employeesList.sort(comparator1);
        employeesList.forEach(System.out::println);

        System.out.println();

        System.out.println("Sorting as per Designation, then Department, then Salary, then Year of Joining");
        System.out.println("----------------------------------------");

        employeesList.sort(comparator2);
        employeesList.forEach(System.out::println);

    }

}
