package com.interview.practice.javacoreandadvance.customArrayList;

public class Client {

    public static void main(String[] args) {

        CustomArrayList<Integer> integerCustomArrayList = new CustomArrayList<>();

        integerCustomArrayList.add(2);
        integerCustomArrayList.add(3);
        integerCustomArrayList.add(1);
        integerCustomArrayList.add(4);
        integerCustomArrayList.add(1);

        integerCustomArrayList.display();
        System.out.println();
        System.out.println("Getting the value at index 3 : " + integerCustomArrayList.get(3));
        integerCustomArrayList.remove(3);
        System.out.println("After removing the value from index 3");
        integerCustomArrayList.display();

    }

}
