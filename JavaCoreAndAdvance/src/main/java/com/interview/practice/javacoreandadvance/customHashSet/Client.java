package com.interview.practice.javacoreandadvance.customHashSet;

public class Client {

    public static void main(String[] args) {

        CustomHashSet<Integer> integerCustomHashSet = new CustomHashSet<>();

        integerCustomHashSet.add(2);
        integerCustomHashSet.add(4);
        integerCustomHashSet.add(3);
        integerCustomHashSet.add(1);
        integerCustomHashSet.add(2);

        integerCustomHashSet.display();
        integerCustomHashSet.remove(4);
        System.out.println();
        System.out.println("After removing 4 hashset looks like");
        integerCustomHashSet.display();
        System.out.println();
        System.out.println("HashSet contains method for 4 : " + integerCustomHashSet.contains(4));
        System.out.println("HashSet contains method for 3 : " + integerCustomHashSet.contains(3));

    }

}
