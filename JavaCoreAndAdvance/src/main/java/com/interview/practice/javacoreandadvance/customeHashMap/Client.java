package com.interview.practice.javacoreandadvance.customeHashMap;

public class Client {

    public static void main(String[] args) {
        CustomHashMap<Integer, String> integerStringCustomHashMap = new CustomHashMap<>();

        integerStringCustomHashMap.put(1,"Delhi");
        integerStringCustomHashMap.put(2,"London");
        integerStringCustomHashMap.put(3,"Islamabad");
        integerStringCustomHashMap.put(4,"New York");
        integerStringCustomHashMap.put(1, "Indore"); // this should override Delhi
        integerStringCustomHashMap.put(5, "Washington DC");
        integerStringCustomHashMap.put(6,"Mexico");
        integerStringCustomHashMap.put(8,"Mumbai");

        integerStringCustomHashMap.display();

        System.out.println("using get method for key : 3 and value : " + integerStringCustomHashMap.get(3));

        integerStringCustomHashMap.remove(4);
        System.out.println("hashMap after removing key 4");
        integerStringCustomHashMap.display();
        System.out.println("checking the contains method for key 4 : "+ integerStringCustomHashMap.contains(4));
        System.out.println("checking the contains method for key 5 : "+ integerStringCustomHashMap.contains(5));
    }

}
