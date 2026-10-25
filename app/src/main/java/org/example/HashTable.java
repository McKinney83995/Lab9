package org.example;

import java.util.LinkedList;

class HashNode<K, V> { // node class
    K key;
    V value;

    HashNode(K k, V v) { // constructor -- intializes key and value values
        key = k;
        value = v;
    }
}

public class HashTable<V> {
    private int capacity = 64, size;
    private LinkedList<HashNode<Character, V>>[] table; // only v is generic bc im tired

    @SuppressWarnings("unchecked")
    HashTable() {
        table = new LinkedList[capacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V get(Character key) {
        if (size == 0) // if there are no values in the hash table at all
            return null;

        if (Character.isLetter(key)) { // convert letters to uppercase
            key = Character.toUpperCase(key);
        }

        return bucketGet(hashify(key), key);
    }

    public void put(Character key, V value) { // public function to put a new key value pair into hash table
        if (Character.isLetter((char) key)) { // if key is character
            key = Character.toUpperCase(key); // make sure its stored as uppercase
        }

        bucketPut(hashify(key), key, value);
        return;
    }

    public void remove(Character key) {
        if (size == 0) // if there are no values in the hash table at all
            return;

        if (Character.isLetter(key)) { // convert letters to uppercase
            key = Character.toUpperCase(key);
        }

        bucketRemove(hashify(key), key);
        return;
    }

    private int hashify(Character key) {
        return (int) key - 33; // take the ascii value, subtract 33 to acount for all the weird non characters
                               // like enter that i dont care about
    }

    private V bucketGet(int bucket, Character key) {
        if (table[bucket] == null || table[bucket].isEmpty()) // first checks if the buckets empty
            return null;

        int bucketsize = table[bucket].size();

        for (int i = 0; i < bucketsize; ++i) { // iterate through entries until you get to one that is equal to the key
            if (table[bucket].get(i).key == key) {
                return table[bucket].get(i).value;
            }
        }

        return null;
    }

    private void bucketPut(int bucket, Character key, V value) {
        if (table[bucket] == null) // if bucket is null
            table[bucket] = new LinkedList<>(); // create new linked list entry

        table[bucket].add(new HashNode(key, value));
        ++size;
        return;
    }

    private void bucketRemove(int bucket, Character key) {
        if (table[bucket] == null || table[bucket].isEmpty()) // first checks if its empty
            return;

        for (int i = 0; i < table[bucket].size(); ++i) { // iterate through entries
            if (table[bucket].get(i).key == key) {
                table[bucket].remove(i);
                --size;
                return;
            }
        }

        return;
    }
}