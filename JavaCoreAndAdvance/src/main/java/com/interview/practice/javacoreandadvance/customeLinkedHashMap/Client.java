package com.interview.practice.javacoreandadvance.customeLinkedHashMap;

public class Client {

    public static void main(String[] args) {
        CustomLinkedHashMap<Integer, String> integerStringCustomLinkedHashMap = new CustomLinkedHashMap<>();

        integerStringCustomLinkedHashMap.put(4,"New York");
        integerStringCustomLinkedHashMap.put(3,"Islamabad");
        integerStringCustomLinkedHashMap.put(1,"Delhi");
        integerStringCustomLinkedHashMap.put(6,"Mexico");
        integerStringCustomLinkedHashMap.put(2,"London");
        integerStringCustomLinkedHashMap.put(5, "Washington DC");
        integerStringCustomLinkedHashMap.put(1, "Indore"); // this should override Delhi
        integerStringCustomLinkedHashMap.put(8,"Cairo");

        integerStringCustomLinkedHashMap.display();

        System.out.println("using get method for key : 3 and value : " + integerStringCustomLinkedHashMap.get(3));

        integerStringCustomLinkedHashMap.remove(4);
        System.out.println("hashMap after removing key 4");
        integerStringCustomLinkedHashMap.display();
        System.out.println("checking the contains method for key 4 : "+ integerStringCustomLinkedHashMap.contains(4));
        System.out.println("checking the contains method for key 5 : "+ integerStringCustomLinkedHashMap.contains(5));
    }

}
