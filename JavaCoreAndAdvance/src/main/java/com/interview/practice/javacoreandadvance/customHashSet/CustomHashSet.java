package com.interview.practice.javacoreandadvance.customHashSet;

import com.interview.practice.javacoreandadvance.customeHashMap.CustomHashMap;

public class CustomHashSet<K> {

    private CustomHashMap<K,Object> internalMap;

    public CustomHashSet() {
        this.internalMap = new CustomHashMap<>();
    }

    public void add(K value) {
        internalMap.put(value,null);
    }

    public void remove(K value) {
        internalMap.remove(value);
    }

    public boolean contains(K value) {
        return internalMap.contains(value);
    }

    public void display() {
        internalMap.displaySet();
    }
}
