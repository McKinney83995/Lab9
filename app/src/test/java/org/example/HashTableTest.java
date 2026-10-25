package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
     @Test
     void works() {
          HashTable<Integer> testTable = new HashTable<>();
          testTable.put('a', 1);
          assertEquals(testTable.isEmpty(), false);
     }

}
