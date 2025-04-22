package com.interview.practice.javacoreandadvance.comparable;

import java.util.List;

public class Student implements Comparable<Student> {

    private String firstName;
    private String lastName;
    private Standard standard;
    private int rollNo;
    private List<String> favSubject;

    public Student(String firstName, String lastName, Standard standard, int rollNo, List<String> favSubject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.standard = standard;
        this.rollNo = rollNo;
        this.favSubject = favSubject;
    }



    @Override
    public String toString() {
        return "Student{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", standard=" + standard +
            ", rollNo=" + rollNo +
            ", favSubject=" + favSubject +
            '}';
    }

    @Override
    public int compareTo(Student o) {
        int standardComparison = this.standard.compareTo(o.standard);
        if (standardComparison != 0) {
            return standardComparison;
        }

        int firstNameComparison = this.firstName.compareToIgnoreCase(o.firstName);
        if (firstNameComparison != 0) {
            return firstNameComparison;
        }

        return Integer.compare(this.rollNo, o.rollNo);
    }
}
