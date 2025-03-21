package com.interview.practice.javacoreandadvance.customeHashMap;

public class CustomHashMap<K, V> {

    private int initial_size = 4;
    private Entry<K, V>[] hashtable;

    public CustomHashMap() {
        hashtable = new Entry[initial_size];
    }

    private static class Entry<K, V> {

        K key;
        V value;
        Entry next;

        public Entry(K key, V value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private int getHash(K key) {
        return Math.abs(key.hashCode()) % initial_size;
    }

    public void put(K newKey, V newValue) {
        if (newKey == null) {
            return;
        }
        int index = getHash(newKey);
        Entry<K, V> oldKvEntry = hashtable[index];
        Entry<K, V> newEntry = new Entry<>(newKey, newValue, null);
        if (oldKvEntry == null) {
            // for first time, when the index is empty
            hashtable[index] = newEntry;
        } else {
            // when index is not empty, need to iterate the single LL
            Entry<K, V> head = oldKvEntry;
            Entry<K, V> previous = null;
            while (head != null) {
                if (head.key.equals(newKey)) {
                    // need to replace the value for that key
                    head.value = newValue;
                    return;
                }
                previous = head;
                head = head.next;

            }
            // add the newEntry as the end node
            previous.next = newEntry;
        }
    }

    public V get(K newKey) {
        if (newKey == null) {
            return null;
        }
        int index = getHash(newKey);
        Entry<K, V> kvEntry = hashtable[index];
        Entry<K, V> head = kvEntry;

        while (head != null) {
            if (head.key.equals(newKey)) {
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    public void remove(K removeKey) {
        if (removeKey == null) {
            return;
        }

        int index = getHash(removeKey);
        Entry<K, V> kvEntryToRemove = hashtable[index];

        if (kvEntryToRemove != null) {
            Entry<K, V> head = kvEntryToRemove;
            Entry<K, V> previous = null;
            while (head != null) {
                if (head.key.equals(removeKey)) {

                    if (previous == null) {
                        // removing head, need to assign new head
                        hashtable[index] = head.next;
                        return;
                    } else {
                        // removing in-between node
                        previous.next = head.next;
                        head.next = null;
                    }
                    previous = head;
                    head = head.next;
                }
            }
        }
    }

    public void display() {
        for (int i = 0; i < initial_size; i++) {
            Entry<K, V> head = hashtable[i];
            while (head != null) {
                System.out.println("key : " + head.key + " value : " + head.value);
                head = head.next;
            }
        }
    }

    public boolean contains(K searchKey) {
        int index = getHash(searchKey);
        Entry<K, V> kvEntry = hashtable[index];
        if(kvEntry == null) {
            return false;
        }
        Entry<K, V> temp = kvEntry;
        while(temp != null) {
            if(temp.key.equals(searchKey)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

}
