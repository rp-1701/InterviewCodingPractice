package com.interview.practice.javacoreandadvance.customeLinkedHashMap;

public class CustomLinkedHashMap<K,V> {

    private Entry<K,V>[] hashtable;
    private Entry<K,V> head;
    private Entry<K,V> tail;
    private int initial_size = 4;

    public CustomLinkedHashMap() {
        this.hashtable = new Entry[initial_size];
    }

    private class Entry<K,V> {
        K key;
        V value;
        Entry<K,V> next;
        // double LL attributes
        Entry<K,V> after;
        Entry<K,V> before;

        public Entry(K key, V value, Entry next, Entry after, Entry before) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private int getHash(K key) {
        return Math.abs(key.hashCode()) % initial_size;
    }

    public void put(K newKey, V newValue) {
        if(newKey == null) {
            return;
        }

        int index = getHash(newKey);
        Entry<K, V> oldKvEntry = hashtable[index];
        Entry<K, V> newKvEntry = new Entry<>(newKey, newValue, null, null, null);
        if(oldKvEntry == null) {
            // for the first time, just assign the new entry
            hashtable[index] = newKvEntry;
        }
        else {
            Entry<K, V> currentHead = oldKvEntry;
            Entry<K,V> previousEntry = currentHead;
            while(currentHead != null) {
                if(currentHead.key.equals(newKey)) {
                    // if key already exist just update it
                    currentHead.value = newValue;
                    return;
                }
                previousEntry = currentHead;
                currentHead = currentHead.next;
            }
            // add the newEntry as the end node
            previousEntry.next = newKvEntry;
        }

        // maintain the insertion logic
        if(head == null) {
            // it is a new node
            head = newKvEntry;
            tail = newKvEntry;
        } else {
            tail.after = newKvEntry;
            newKvEntry.before = tail;
            tail = newKvEntry;
        }
    }

    public V get(K searchKey) {
        int index = getHash(searchKey);
        Entry<K, V> kvEntry = hashtable[index];

        if(kvEntry == null) {
            return null;
        } else {
           Entry<K,V> currentHead = hashtable[index];
           while(currentHead != null) {
               if(currentHead.key.equals(searchKey)) {
                   return currentHead.value;
               }
               currentHead = currentHead.next;
           }
        }

        return null;
    }

    public void display() {
        Entry<K,V> temp = head;
        while(temp != null) {
            System.out.println("Key : " + temp.key + " Value : " + temp.value);
            temp = temp.after;
        }
    }

    public void remove(K removeKey) {
        if(removeKey == null) {
            return;
        }
        int index = getHash(removeKey);
        Entry<K, V> kvEntryToRemove = hashtable[index];
        if (kvEntryToRemove != null) {
            Entry<K, V> currenthead = kvEntryToRemove;
            Entry<K, V> previous = null;
            while (currenthead != null) {
                if (currenthead.key.equals(removeKey)) {
                    if (previous == null) {
                        // removing head, need to assign new head
                        hashtable[index] = currenthead.next;
                    } else {
                        // removing in-between node
                        previous.next = currenthead.next;
                        currenthead.next = null;
                    }

                    Entry<K, V> beforeEntry = currenthead.before;
                    Entry<K, V> frontEntry = currenthead.after;

                    // need to maintain the insertion order
                    if(currenthead.before != null) {
                        // for in-between node
                        beforeEntry.after = frontEntry;
                    } else {
                        // remove old head and assign new head
                        head = frontEntry;
                    }

                    if(currenthead.after != null) {
                        frontEntry.before = beforeEntry;
                    } else {
                        tail = beforeEntry;
                    }
                    return;
                }
                previous = head;
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
