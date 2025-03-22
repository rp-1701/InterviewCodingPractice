package com.interview.practice.javacoreandadvance.customArrayList;

import java.sql.Array;
import java.util.Arrays;

public class CustomArrayList<E> {

    private int initial_capacity = 10;
    private int size = 0;
    private Object[] internalArray = {};

    public CustomArrayList() {
        this.internalArray = new Object[initial_capacity];
    }

    public void add(E element) {
        if(size == internalArray.length) {
            increaseCapacity();
        }
        internalArray[size++] = element;
    }

    public E get(int index) {
        if(index < 0 || index > initial_capacity) {
            throw new ArrayIndexOutOfBoundsException(index + " does not exist");
        }
        return (E)internalArray[index];
    }

    public E remove(int index) {
        if(index < 0 || index > initial_capacity) {
            throw new ArrayIndexOutOfBoundsException(index + " does not exist");
        }
        E removedElement = (E) internalArray[index];
        for(int i = index; i < initial_capacity-1; i++) {
            internalArray[i] = internalArray[i + 1];
        }
        --size;
        return removedElement;
    }

    public void display() {
        for(Object e : internalArray) {
            if(e != null)
                System.out.print(e + " ");
        }
    }

    private void increaseCapacity() {
        initial_capacity = internalArray.length * 2;
        internalArray = Arrays.copyOf(internalArray, initial_capacity);
    }
}
