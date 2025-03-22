package com.interview.practice.javacoreandadvance.customLinkedHashSet;

public class Client {

    public static void main(String[] args) {

        CustomLinkedHashSet<Integer> integerCustomLinkedHashSetHashSet = new CustomLinkedHashSet<>();

        integerCustomLinkedHashSetHashSet.add(2);
        integerCustomLinkedHashSetHashSet.add(4);
        integerCustomLinkedHashSetHashSet.add(3);
        integerCustomLinkedHashSetHashSet.add(1);
        integerCustomLinkedHashSetHashSet.add(2);

        integerCustomLinkedHashSetHashSet.display();
        integerCustomLinkedHashSetHashSet.remove(4);
        System.out.println();
        System.out.println("After removing 4 hashset looks like");
        integerCustomLinkedHashSetHashSet.display();
        System.out.println();
        System.out.println("HashSet contains method for 4 : " + integerCustomLinkedHashSetHashSet.contains(4));
        System.out.println("HashSet contains method for 3 : " + integerCustomLinkedHashSetHashSet.contains(3));
    }

}
