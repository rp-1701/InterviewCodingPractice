package com.interview.practice.javacoreandadvance.customLinkedHashSet;

import com.interview.practice.javacoreandadvance.customeLinkedHashMap.CustomLinkedHashMap;

public class CustomLinkedHashSet<K> {

    private CustomLinkedHashMap<K, Object> internalMap;

    public CustomLinkedHashSet() {
        this.internalMap = new CustomLinkedHashMap<>();
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
