package com.interview.practice.javacoreandadvance.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentClient {

    public static void main(String[] args) {
        List<Student> studentsList = new ArrayList<>();
        studentsList.add(new Student("abhishek","kumar",Standard.EIGHT,26,List.of("English","Mathematics")));
        studentsList.add(new Student("Rohit","Jadhav",Standard.FIVE,12,List.of("Physics","Chemistry")));
        studentsList.add(new Student("Anubhav","Patil",Standard.FOUR,34,List.of("Geography","English")));
        studentsList.add(new Student("Tauseef","khan",Standard.NINE,10,List.of("Biology","Economics")));
        studentsList.add(new Student("Balaji","Singh",Standard.TEN,41,List.of("History","Hindi")));
        studentsList.add(new Student("Anubhav","Singh",Standard.FOUR,48,List.of("Geography","English")));
        studentsList.add(new Student("Rohan","Patil",Standard.EIGHT,24,List.of("English","Mathematics")));


        /*
        comparable is used as default sorting for a specific class
        In this case, lets say default sorting is Standard wise and then FirstName then rollNo.

        Now in the Future, lets say sorting requirement changes
        sort it as Lastname then FirstName then rollNo
        to implement this new requirement we need to change the compareTo method completely
         */
        Collections.sort(studentsList);

        studentsList.forEach(System.out::println);


    }

}
